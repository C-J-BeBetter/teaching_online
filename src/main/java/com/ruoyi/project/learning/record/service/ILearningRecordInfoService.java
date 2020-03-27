package com.ruoyi.project.learning.record.service;

import java.util.List;
import com.ruoyi.project.learning.record.domain.LearningRecordInfo;

/**
 * 学习记录信息Service接口
 * 
 * @author ruoyi
 * @date 2020-03-27
 */
public interface ILearningRecordInfoService 
{
    /**
     * 查询学习记录信息
     * 
     * @param id 学习记录信息ID
     * @return 学习记录信息
     */
    public LearningRecordInfo selectLearningRecordInfoById(Long id);

    /**
     * 查询学习记录信息列表
     * 
     * @param learningRecordInfo 学习记录信息
     * @return 学习记录信息集合
     */
    public List<LearningRecordInfo> selectLearningRecordInfoList(LearningRecordInfo learningRecordInfo);

    /**
     * 新增学习记录信息
     * 
     * @param learningRecordInfo 学习记录信息
     * @return 结果
     */
    public int insertLearningRecordInfo(LearningRecordInfo learningRecordInfo);

    /**
     * 修改学习记录信息
     * 
     * @param learningRecordInfo 学习记录信息
     * @return 结果
     */
    public int updateLearningRecordInfo(LearningRecordInfo learningRecordInfo);

    /**
     * 批量删除学习记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLearningRecordInfoByIds(String ids);

    /**
     * 删除学习记录信息信息
     * 
     * @param id 学习记录信息ID
     * @return 结果
     */
    public int deleteLearningRecordInfoById(Long id);
}
