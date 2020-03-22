package com.ruoyi.project.learning.answer.service;

import com.ruoyi.project.learning.answer.domain.LWorkReplyInfo;

import java.util.List;

/**
 * 作业讨论答疑信息Service接口
 * 
 * @author ruoyi
 * @date 2020-03-22
 */
public interface ILWorkReplyInfoService 
{
    /**
     * 查询作业讨论答疑信息
     * 
     * @param id 作业讨论答疑信息ID
     * @return 作业讨论答疑信息
     */
    public LWorkReplyInfo selectLWorkReplyInfoById(Long id);

    /**
     * 查询作业讨论答疑信息列表
     * 
     * @param lWorkReplyInfo 作业讨论答疑信息
     * @return 作业讨论答疑信息集合
     */
    public List<LWorkReplyInfo> selectLWorkReplyInfoList(LWorkReplyInfo lWorkReplyInfo);

    /**
     * 新增作业讨论答疑信息
     * 
     * @param lWorkReplyInfo 作业讨论答疑信息
     * @return 结果
     */
    public int insertLWorkReplyInfo(LWorkReplyInfo lWorkReplyInfo);

    /**
     * 修改作业讨论答疑信息
     * 
     * @param lWorkReplyInfo 作业讨论答疑信息
     * @return 结果
     */
    public int updateLWorkReplyInfo(LWorkReplyInfo lWorkReplyInfo);

    /**
     * 批量删除作业讨论答疑信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLWorkReplyInfoByIds(String ids);

    /**
     * 删除作业讨论答疑信息信息
     * 
     * @param id 作业讨论答疑信息ID
     * @return 结果
     */
    public int deleteLWorkReplyInfoById(Long id);
}
