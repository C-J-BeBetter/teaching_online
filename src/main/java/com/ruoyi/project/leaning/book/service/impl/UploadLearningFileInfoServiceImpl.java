package com.ruoyi.project.leaning.book.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.leaning.book.mapper.UploadLearningFileInfoMapper;
import com.ruoyi.project.leaning.book.domain.UploadLearningFileInfo;
import com.ruoyi.project.leaning.book.service.IUploadLearningFileInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 学习资料管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-21
 */
@Service
public class UploadLearningFileInfoServiceImpl implements IUploadLearningFileInfoService 
{
    @Autowired
    private UploadLearningFileInfoMapper uploadLearningFileInfoMapper;

    /**
     * 查询学习资料管理
     * 
     * @param id 学习资料管理ID
     * @return 学习资料管理
     */
    @Override
    public UploadLearningFileInfo selectUploadLearningFileInfoById(Long id)
    {
        return uploadLearningFileInfoMapper.selectUploadLearningFileInfoById(id);
    }

    /**
     * 查询学习资料管理列表
     * 
     * @param uploadLearningFileInfo 学习资料管理
     * @return 学习资料管理
     */
    @Override
    public List<UploadLearningFileInfo> selectUploadLearningFileInfoList(UploadLearningFileInfo uploadLearningFileInfo)
    {
        return uploadLearningFileInfoMapper.selectUploadLearningFileInfoList(uploadLearningFileInfo);
    }

    /**
     * 新增学习资料管理
     * 
     * @param uploadLearningFileInfo 学习资料管理
     * @return 结果
     */
    @Override
    public int insertUploadLearningFileInfo(UploadLearningFileInfo uploadLearningFileInfo)
    {
        uploadLearningFileInfo.setCreateTime(DateUtils.getNowDate());
        return uploadLearningFileInfoMapper.insertUploadLearningFileInfo(uploadLearningFileInfo);
    }

    /**
     * 修改学习资料管理
     * 
     * @param uploadLearningFileInfo 学习资料管理
     * @return 结果
     */
    @Override
    public int updateUploadLearningFileInfo(UploadLearningFileInfo uploadLearningFileInfo)
    {
        uploadLearningFileInfo.setUpdateTime(DateUtils.getNowDate());
        return uploadLearningFileInfoMapper.updateUploadLearningFileInfo(uploadLearningFileInfo);
    }

    /**
     * 删除学习资料管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUploadLearningFileInfoByIds(String ids)
    {
        return uploadLearningFileInfoMapper.deleteUploadLearningFileInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学习资料管理信息
     * 
     * @param id 学习资料管理ID
     * @return 结果
     */
    @Override
    public int deleteUploadLearningFileInfoById(Long id)
    {
        return uploadLearningFileInfoMapper.deleteUploadLearningFileInfoById(id);
    }
}
