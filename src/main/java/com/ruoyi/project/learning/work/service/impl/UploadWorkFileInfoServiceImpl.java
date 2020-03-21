package com.ruoyi.project.learning.work.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.learning.work.mapper.UploadWorkFileInfoMapper;
import com.ruoyi.project.learning.work.domain.UploadWorkFileInfo;
import com.ruoyi.project.learning.work.service.IUploadWorkFileInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 作业资料管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-21
 */
@Service
public class UploadWorkFileInfoServiceImpl implements IUploadWorkFileInfoService 
{
    @Autowired
    private UploadWorkFileInfoMapper uploadWorkFileInfoMapper;

    /**
     * 查询作业资料管理
     * 
     * @param id 作业资料管理ID
     * @return 作业资料管理
     */
    @Override
    public UploadWorkFileInfo selectUploadWorkFileInfoById(Long id)
    {
        return uploadWorkFileInfoMapper.selectUploadWorkFileInfoById(id);
    }

    /**
     * 查询作业资料管理列表
     * 
     * @param uploadWorkFileInfo 作业资料管理
     * @return 作业资料管理
     */
    @Override
    public List<UploadWorkFileInfo> selectUploadWorkFileInfoList(UploadWorkFileInfo uploadWorkFileInfo)
    {
        return uploadWorkFileInfoMapper.selectUploadWorkFileInfoList(uploadWorkFileInfo);
    }

    /**
     * 新增作业资料管理
     * 
     * @param uploadWorkFileInfo 作业资料管理
     * @return 结果
     */
    @Override
    public int insertUploadWorkFileInfo(UploadWorkFileInfo uploadWorkFileInfo)
    {
        uploadWorkFileInfo.setCreateTime(DateUtils.getNowDate());
        return uploadWorkFileInfoMapper.insertUploadWorkFileInfo(uploadWorkFileInfo);
    }

    /**
     * 修改作业资料管理
     * 
     * @param uploadWorkFileInfo 作业资料管理
     * @return 结果
     */
    @Override
    public int updateUploadWorkFileInfo(UploadWorkFileInfo uploadWorkFileInfo)
    {
        uploadWorkFileInfo.setUpdateTime(DateUtils.getNowDate());
        return uploadWorkFileInfoMapper.updateUploadWorkFileInfo(uploadWorkFileInfo);
    }

    /**
     * 删除作业资料管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUploadWorkFileInfoByIds(String ids)
    {
        return uploadWorkFileInfoMapper.deleteUploadWorkFileInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除作业资料管理信息
     * 
     * @param id 作业资料管理ID
     * @return 结果
     */
    @Override
    public int deleteUploadWorkFileInfoById(Long id)
    {
        return uploadWorkFileInfoMapper.deleteUploadWorkFileInfoById(id);
    }
}
