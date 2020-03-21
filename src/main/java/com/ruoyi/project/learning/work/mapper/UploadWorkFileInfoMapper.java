package com.ruoyi.project.learning.work.mapper;

import java.util.List;
import com.ruoyi.project.learning.work.domain.UploadWorkFileInfo;

/**
 * 作业资料管理Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-21
 */
public interface UploadWorkFileInfoMapper 
{
    /**
     * 查询作业资料管理
     * 
     * @param id 作业资料管理ID
     * @return 作业资料管理
     */
    public UploadWorkFileInfo selectUploadWorkFileInfoById(Long id);

    /**
     * 查询作业资料管理列表
     * 
     * @param uploadWorkFileInfo 作业资料管理
     * @return 作业资料管理集合
     */
    public List<UploadWorkFileInfo> selectUploadWorkFileInfoList(UploadWorkFileInfo uploadWorkFileInfo);

    /**
     * 新增作业资料管理
     * 
     * @param uploadWorkFileInfo 作业资料管理
     * @return 结果
     */
    public int insertUploadWorkFileInfo(UploadWorkFileInfo uploadWorkFileInfo);

    /**
     * 修改作业资料管理
     * 
     * @param uploadWorkFileInfo 作业资料管理
     * @return 结果
     */
    public int updateUploadWorkFileInfo(UploadWorkFileInfo uploadWorkFileInfo);

    /**
     * 删除作业资料管理
     * 
     * @param id 作业资料管理ID
     * @return 结果
     */
    public int deleteUploadWorkFileInfoById(Long id);

    /**
     * 批量删除作业资料管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUploadWorkFileInfoByIds(String[] ids);
}
