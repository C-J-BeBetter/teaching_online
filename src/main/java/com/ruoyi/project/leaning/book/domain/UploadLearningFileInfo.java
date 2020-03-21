package com.ruoyi.project.leaning.book.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 学习资料管理对象 t_upload_learning_file_info
 * 
 * @author ruoyi
 * @date 2020-03-21
 */
public class UploadLearningFileInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 资料ID */
    private Long id;

    /** 资料名 */
    @Excel(name = "资料名")
    private String fileName;

    /** 目录 */
    @Excel(name = "目录")
    private String path;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 关联上传人员id */
    @Excel(name = "关联上传人员id")
    private String userId;

    /** 关联上传人员姓名 */
    @Excel(name = "关联上传人员姓名")
    private String userName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileName", getFileName())
            .append("path", getPath())
            .append("description", getDescription())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
