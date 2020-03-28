package com.ruoyi.project.learning.studentfile.service;

import java.util.List;
import com.ruoyi.project.learning.studentfile.domain.LCommitWorkInfo;

/**
 * 提交作业信息Service接口
 * 
 * @author zsls
 * @date 2020-03-28
 */
public interface ILCommitWorkInfoService 
{
    /**
     * 查询提交作业信息
     * 
     * @param id 提交作业信息ID
     * @return 提交作业信息
     */
    public LCommitWorkInfo selectLCommitWorkInfoById(Long id);

    /**
     * 查询提交作业信息列表
     * 
     * @param lCommitWorkInfo 提交作业信息
     * @return 提交作业信息集合
     */
    public List<LCommitWorkInfo> selectLCommitWorkInfoList(LCommitWorkInfo lCommitWorkInfo);

    /**
     * 新增提交作业信息
     * 
     * @param lCommitWorkInfo 提交作业信息
     * @return 结果
     */
    public int insertLCommitWorkInfo(LCommitWorkInfo lCommitWorkInfo);

    /**
     * 修改提交作业信息
     * 
     * @param lCommitWorkInfo 提交作业信息
     * @return 结果
     */
    public int updateLCommitWorkInfo(LCommitWorkInfo lCommitWorkInfo);

    /**
     * 批量删除提交作业信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLCommitWorkInfoByIds(String ids);

    /**
     * 删除提交作业信息信息
     * 
     * @param id 提交作业信息ID
     * @return 结果
     */
    public int deleteLCommitWorkInfoById(Long id);
}
