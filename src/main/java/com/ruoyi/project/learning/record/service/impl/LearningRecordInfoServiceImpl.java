package com.ruoyi.project.learning.record.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.learning.record.mapper.LearningRecordInfoMapper;
import com.ruoyi.project.learning.record.domain.LearningRecordInfo;
import com.ruoyi.project.learning.record.service.ILearningRecordInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 学习记录信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-27
 */
@Service
public class LearningRecordInfoServiceImpl implements ILearningRecordInfoService 
{
    @Autowired
    private LearningRecordInfoMapper learningRecordInfoMapper;

    /**
     * 查询学习记录信息
     * 
     * @param id 学习记录信息ID
     * @return 学习记录信息
     */
    @Override
    public LearningRecordInfo selectLearningRecordInfoById(Long id)
    {
        return learningRecordInfoMapper.selectLearningRecordInfoById(id);
    }

    /**
     * 查询学习记录信息列表
     * 
     * @param learningRecordInfo 学习记录信息
     * @return 学习记录信息
     */
    @Override
    public List<LearningRecordInfo> selectLearningRecordInfoList(LearningRecordInfo learningRecordInfo)
    {
        if (ShiroUtils.checkUserRole("student") || ShiroUtils.checkUserRole("teacher"))
            learningRecordInfo.setUserId(ShiroUtils.getLoginName());
        return learningRecordInfoMapper.selectLearningRecordInfoList(learningRecordInfo);
    }

    /**
     * 新增学习记录信息
     * 
     * @param learningRecordInfo 学习记录信息
     * @return 结果
     */
    @Override
    public int insertLearningRecordInfo(LearningRecordInfo learningRecordInfo)
    {
        learningRecordInfo.setCreateTime(DateUtils.getNowDate());
        User sysUser  = ShiroUtils.getSysUser();
        learningRecordInfo.setUserId(sysUser.getLoginName());
        learningRecordInfo.setUserName(sysUser.getUserName());
        return learningRecordInfoMapper.insertLearningRecordInfo(learningRecordInfo);
    }

    /**
     * 修改学习记录信息
     * 
     * @param learningRecordInfo 学习记录信息
     * @return 结果
     */
    @Override
    public int updateLearningRecordInfo(LearningRecordInfo learningRecordInfo)
    {
        learningRecordInfo.setUpdateTime(DateUtils.getNowDate());
        return learningRecordInfoMapper.updateLearningRecordInfo(learningRecordInfo);
    }

    /**
     * 删除学习记录信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLearningRecordInfoByIds(String ids)
    {
        return learningRecordInfoMapper.deleteLearningRecordInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学习记录信息信息
     * 
     * @param id 学习记录信息ID
     * @return 结果
     */
    @Override
    public int deleteLearningRecordInfoById(Long id)
    {
        return learningRecordInfoMapper.deleteLearningRecordInfoById(id);
    }
}
