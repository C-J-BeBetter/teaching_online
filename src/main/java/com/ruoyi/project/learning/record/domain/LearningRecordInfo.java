package com.ruoyi.project.learning.record.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 学习记录信息对象 l_learning_record_info
 * 
 * @author ruoyi
 * @date 2020-03-27
 */
public class LearningRecordInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 笔记ID */
    private Long id;

    /** 笔记标题 */
    @Excel(name = "笔记标题")
    private String title;

    /** 笔记内容 */
    @Excel(name = "笔记内容")
    private String description;

    /** 关联学员ID */
    @Excel(name = "关联学员ID")
    private String userId;

    /** 关联学员姓名 */
    @Excel(name = "关联学员姓名")
    private String userName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LearningRecordInfo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
