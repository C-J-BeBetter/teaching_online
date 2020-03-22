package com.ruoyi.project.learning.answer.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.learning.answer.domain.LWorkReplyInfo;
import com.ruoyi.project.learning.answer.mapper.LWorkReplyInfoMapper;
import com.ruoyi.project.learning.answer.service.ILWorkReplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作业讨论答疑信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-22
 */
@Service
public class LWorkReplyInfoServiceImpl implements ILWorkReplyInfoService
{
    @Autowired
    private LWorkReplyInfoMapper lWorkReplyInfoMapper;

    /**
     * 查询作业讨论答疑信息
     * 
     * @param id 作业讨论答疑信息ID
     * @return 作业讨论答疑信息
     */
    @Override
    public LWorkReplyInfo selectLWorkReplyInfoById(Long id)
    {
        return lWorkReplyInfoMapper.selectLWorkReplyInfoById(id);
    }

    /**
     * 查询作业讨论答疑信息列表
     * 
     * @param lWorkReplyInfo 作业讨论答疑信息
     * @return 作业讨论答疑信息
     */
    @Override
    public List<LWorkReplyInfo> selectLWorkReplyInfoList(LWorkReplyInfo lWorkReplyInfo)
    {
        return lWorkReplyInfoMapper.selectLWorkReplyInfoList(lWorkReplyInfo);
    }

    /**
     * 新增作业讨论答疑信息
     * 
     * @param lWorkReplyInfo 作业讨论答疑信息
     * @return 结果
     */
    @Override
    public int insertLWorkReplyInfo(LWorkReplyInfo lWorkReplyInfo)
    {
        return lWorkReplyInfoMapper.insertLWorkReplyInfo(lWorkReplyInfo);
    }

    /**
     * 修改作业讨论答疑信息
     * 
     * @param lWorkReplyInfo 作业讨论答疑信息
     * @return 结果
     */
    @Override
    public int updateLWorkReplyInfo(LWorkReplyInfo lWorkReplyInfo)
    {
        return lWorkReplyInfoMapper.updateLWorkReplyInfo(lWorkReplyInfo);
    }

    /**
     * 删除作业讨论答疑信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLWorkReplyInfoByIds(String ids)
    {
        return lWorkReplyInfoMapper.deleteLWorkReplyInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除作业讨论答疑信息信息
     * 
     * @param id 作业讨论答疑信息ID
     * @return 结果
     */
    @Override
    public int deleteLWorkReplyInfoById(Long id)
    {
        return lWorkReplyInfoMapper.deleteLWorkReplyInfoById(id);
    }
}
