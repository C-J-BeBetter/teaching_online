package com.ruoyi.project.learning.answer.service.impl;

import com.google.common.collect.Maps;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.learning.answer.domain.LWorkReplyInfo;
import com.ruoyi.project.learning.answer.mapper.LWorkReplyInfoMapper;
import com.ruoyi.project.learning.answer.service.ILWorkReplyInfoService;
import com.ruoyi.project.learning.work.domain.UploadWorkFileInfo;
import com.ruoyi.project.learning.work.service.IUploadWorkFileInfoService;
import com.ruoyi.project.system.role.domain.Role;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 作业讨论答疑信息Service业务层处理
 *
 * @author ruoyi
 * @date 2020-03-22
 */
@Service
public class LWorkReplyInfoServiceImpl implements ILWorkReplyInfoService {
    public static final String ADMIN = "admin";
    public static final String TEACHER = "teacher";
    public static final String STUDENT = "student";
    @Autowired
    private LWorkReplyInfoMapper lWorkReplyInfoMapper;

    @Autowired
    private IUploadWorkFileInfoService iUploadWorkFileInfoService;

    /**
     * 查询作业讨论答疑信息
     *
     * @param id 作业讨论答疑信息ID
     * @return 作业讨论答疑信息
     */
    @Override
    public LWorkReplyInfo selectLWorkReplyInfoById(Long id) {
        return lWorkReplyInfoMapper.selectLWorkReplyInfoById(id);
    }

    /**
     * 查询作业讨论答疑信息列表
     *
     * @param lWorkReplyInfo 作业讨论答疑信息
     * @return 作业讨论答疑信息
     */
    @Override
    public List<LWorkReplyInfo> selectLWorkReplyInfoList(LWorkReplyInfo lWorkReplyInfo) {
        return lWorkReplyInfoMapper.selectLWorkReplyInfoList(lWorkReplyInfo);
    }

    /**
     * 新增作业讨论答疑信息
     *
     * @param lWorkReplyInfo 作业讨论答疑信息
     * @return 结果
     */
    @Override
    public int insertLWorkReplyInfo(LWorkReplyInfo lWorkReplyInfo) {
        return lWorkReplyInfoMapper.insertLWorkReplyInfo(lWorkReplyInfo);
    }

    /**
     * 修改作业讨论答疑信息
     *
     * @param lWorkReplyInfo 作业讨论答疑信息
     * @return 结果
     */
    @Override
    public int updateLWorkReplyInfo(LWorkReplyInfo lWorkReplyInfo) {
        return lWorkReplyInfoMapper.updateLWorkReplyInfo(lWorkReplyInfo);
    }

    /**
     * 删除作业讨论答疑信息对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLWorkReplyInfoByIds(String ids) {
        return lWorkReplyInfoMapper.deleteLWorkReplyInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除作业讨论答疑信息信息
     *
     * @param id 作业讨论答疑信息ID
     * @return 结果
     */
    @Override
    public int deleteLWorkReplyInfoById(Long id) {
        return lWorkReplyInfoMapper.deleteLWorkReplyInfoById(id);
    }

    @Override
    public List<UploadWorkFileInfo> selectWorkByUser() {
        //1.登录信息
        User user = ShiroUtils.getSysUser();
        List<Role> roles = user.getRoles();
        boolean teacher_flag = roles.stream().anyMatch(role -> role.getRoleKey().equals(ADMIN) || role.getRoleKey().equals(TEACHER));
        boolean student_flag = roles.stream().anyMatch(role -> role.getRoleKey().equals(STUDENT));
//        //2.根据登录信息获取对应老师发布的作业
//        List<UploadWorkFileInfo> uploadWorkFileInfoList;
//        if(teacher_flag){
//              //所有班级信息
//            UploadWorkFileInfo uploadWorkFileInfo = new UploadWorkFileInfo();
//            uploadWorkFileInfo.setUserId(String.valueOf(user.getUserId()));
//            uploadWorkFileInfoList = iUploadWorkFileInfoService.selectUploadWorkFileInfoList(uploadWorkFileInfo);
//        }else if(student_flag){
//            //查看所在班级作业信息
//        }

        UploadWorkFileInfo uploadWorkFileInfo = new UploadWorkFileInfo();
        if (teacher_flag) {
            //所有作业
            uploadWorkFileInfo.setUserId(String.valueOf(user.getUserId()));
        } else if (student_flag) {
            //自己作业
//            uploadWorkFileInfo.setUserId(String.valueOf(user.getUserId()));
        }

        List<UploadWorkFileInfo> uploadWorkFileInfoList = iUploadWorkFileInfoService.selectUploadWorkFileInfoList(uploadWorkFileInfo);
        if (StringUtils.isNotEmpty(uploadWorkFileInfoList)) {
            uploadWorkFileInfoList.stream().forEach(x -> x.setPublishDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, x.getCreateTime())));
            uploadWorkFileInfoList = uploadWorkFileInfoList.stream().sorted(Comparator.comparing(UploadWorkFileInfo::getCreateTime).reversed()).collect(Collectors.toList());
        }

        return uploadWorkFileInfoList;
    }

    @Override
    public Map<String, Object> replyContnet(Long wbId) {
        Map<String, Object> map = Maps.newHashMap();
        // 根据wbId查找关于这条主题的所有信息
        UploadWorkFileInfo workFileInfo = iUploadWorkFileInfoService.selectUploadWorkFileInfoById(wbId);
        String themeDescription = workFileInfo.getDescription();
        String themeName = workFileInfo.getFileName();
        Long themeId = workFileInfo.getId();
        map.put("themeDescription", themeDescription);
        map.put("themeName", themeName);
        map.put("themeId", themeId);

        LWorkReplyInfo workReplyInfo = new LWorkReplyInfo();
        workReplyInfo.setWbId(wbId);
        //获取所有回复信息
        List<LWorkReplyInfo> replyInfos = lWorkReplyInfoMapper.selectLWorkReplyInfoList(workReplyInfo);

        if (StringUtils.isEmpty(replyInfos)) {
            return map;
        }
        replyInfos.stream().forEach(x -> x.setPublishDate(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, x.getReplyTime())));
        replyInfos = replyInfos.stream().sorted(Comparator.comparing(LWorkReplyInfo::getReplyTime).reversed()).collect(Collectors.toList());
//        // 根据内容  回复对象id 为空 说明是评论
//        List<LWorkReplyInfo> commentList = replyInfos.stream().filter(x -> StringUtils.isEmpty(x.getReplyToUserId())).collect(Collectors.toList());
//
//        // 根据内容  回复对象id 非空 说明是回复
//        List<LWorkReplyInfo> replyList = replyInfos.stream().filter(x -> StringUtils.isNotEmpty(x.getReplyToUserId())).collect(Collectors.toList());

        map.put("replyInfos", replyInfos);
        return map;


    }
}
