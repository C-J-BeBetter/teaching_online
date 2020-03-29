package com.ruoyi.project.learning.studentfile.service.impl;

import java.util.List;
import java.util.Optional;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.role.domain.Role;
import com.ruoyi.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.learning.studentfile.mapper.LCommitWorkInfoMapper;
import com.ruoyi.project.learning.studentfile.domain.LCommitWorkInfo;
import com.ruoyi.project.learning.studentfile.service.ILCommitWorkInfoService;
import com.ruoyi.common.utils.text.Convert;

import javax.annotation.Resource;

/**
 * 提交作业信息Service业务层处理
 * 
 * @author zsls
 * @date 2020-03-28
 */
@Service
public class LCommitWorkInfoServiceImpl implements ILCommitWorkInfoService 
{
    @Resource
    private LCommitWorkInfoMapper lCommitWorkInfoMapper;

    /**
     * 查询提交作业信息
     * 
     * @param id 提交作业信息ID
     * @return 提交作业信息
     */
    @Override
    public LCommitWorkInfo selectLCommitWorkInfoById(Long id)
    {
        return lCommitWorkInfoMapper.selectLCommitWorkInfoById(id);
    }

    /**
     * 查询提交作业信息列表
     * 
     * @param lCommitWorkInfo 提交作业信息
     * @return 提交作业信息
     */
    @Override
    public List<LCommitWorkInfo> selectLCommitWorkInfoList(LCommitWorkInfo lCommitWorkInfo)
    {
        String loginName = ShiroUtils.getLoginName();
        if (ShiroUtils.checkUserRole("teacher")) {
            lCommitWorkInfo.setCorrectUserId(loginName);
        }
        if (ShiroUtils.checkUserRole("student")) {
            lCommitWorkInfo.setCommitUserId(loginName);
        }
        return lCommitWorkInfoMapper.selectLCommitWorkInfoList(lCommitWorkInfo);
    }

    /**
     * 新增提交作业信息
     * 
     * @param lCommitWorkInfo 提交作业信息
     * @return 结果
     */
    @Override
    public int insertLCommitWorkInfo(LCommitWorkInfo lCommitWorkInfo)
    {
        return lCommitWorkInfoMapper.insertLCommitWorkInfo(lCommitWorkInfo);
    }

    /**
     * 修改提交作业信息
     * 
     * @param lCommitWorkInfo 提交作业信息
     * @return 结果
     */
    @Override
    public int updateLCommitWorkInfo(LCommitWorkInfo lCommitWorkInfo)
    {
        return lCommitWorkInfoMapper.updateLCommitWorkInfo(lCommitWorkInfo);
    }

    /**
     * 删除提交作业信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLCommitWorkInfoByIds(String ids)
    {
        return lCommitWorkInfoMapper.deleteLCommitWorkInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除提交作业信息信息
     * 
     * @param id 提交作业信息ID
     * @return 结果
     */
    @Override
    public int deleteLCommitWorkInfoById(Long id)
    {
        return lCommitWorkInfoMapper.deleteLCommitWorkInfoById(id);
    }
}
