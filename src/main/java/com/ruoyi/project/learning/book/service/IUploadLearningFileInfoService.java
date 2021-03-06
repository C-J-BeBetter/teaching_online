package com.ruoyi.project.learning.book.service;

import java.util.List;
import com.ruoyi.project.learning.book.domain.UploadLearningFileInfo;

/**
 * 学习资料管理Service接口
 * 
 * @author ruoyi
 * @date 2020-03-21
 */
public interface IUploadLearningFileInfoService 
{
    /**
     * 查询学习资料管理
     * 
     * @param id 学习资料管理ID
     * @return 学习资料管理
     */
    public UploadLearningFileInfo selectUploadLearningFileInfoById(Long id);

    /**
     * 查询学习资料管理列表
     * 
     * @param uploadLearningFileInfo 学习资料管理
     * @return 学习资料管理集合
     */
    public List<UploadLearningFileInfo> selectUploadLearningFileInfoList(UploadLearningFileInfo uploadLearningFileInfo);

    /**
     * 新增学习资料管理
     * 
     * @param uploadLearningFileInfo 学习资料管理
     * @return 结果
     */
    public int insertUploadLearningFileInfo(UploadLearningFileInfo uploadLearningFileInfo);

    /**
     * 修改学习资料管理
     * 
     * @param uploadLearningFileInfo 学习资料管理
     * @return 结果
     */
    public int updateUploadLearningFileInfo(UploadLearningFileInfo uploadLearningFileInfo);

    /**
     * 批量删除学习资料管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUploadLearningFileInfoByIds(String ids);

    /**
     * 删除学习资料管理信息
     * 
     * @param id 学习资料管理ID
     * @return 结果
     */
    public int deleteUploadLearningFileInfoById(Long id);
}
