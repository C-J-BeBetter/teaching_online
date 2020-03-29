package com.ruoyi.project.learning.studentfile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 提交作业信息对象 l_commit_work_info
 * 
 * @author zsls
 * @date 2020-03-28
 */
public class LCommitWorkInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件ID */
    private Long id;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 目录 */
    @Excel(name = "目录")
    private String path;

    /** 分数 */
    @Excel(name = "分数")
    private Double score;

    /** 关联提交人id */
    @Excel(name = "关联提交人id")
    private String commitUserId;

    /** 关联提交人姓名 */
    @Excel(name = "关联提交人姓名")
    private String commitUserName;

    /** 提交时间 */
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commitTime;

    /** 关联审批人id */
    @Excel(name = "关联审批人id")
    private String correctUserId;

    /** 关联审批人姓名 */
    @Excel(name = "关联审批人姓名")
    private String correctUserName;

    /** 审批时间 */
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date correctTime;

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
    public void setScore(Double score) 
    {
        this.score = score;
    }

    public Double getScore() 
    {
        return score;
    }
    public void setCommitUserId(String commitUserId) 
    {
        this.commitUserId = commitUserId;
    }

    public String getCommitUserId() 
    {
        return commitUserId;
    }
    public void setCommitUserName(String commitUserName) 
    {
        this.commitUserName = commitUserName;
    }

    public String getCommitUserName() 
    {
        return commitUserName;
    }
    public void setCommitTime(Date commitTime) 
    {
        this.commitTime = commitTime;
    }

    public Date getCommitTime() 
    {
        return commitTime;
    }
    public void setCorrectUserId(String correctUserId) 
    {
        this.correctUserId = correctUserId;
    }

    public String getCorrectUserId() 
    {
        return correctUserId;
    }
    public void setCorrectUserName(String correctUserName) 
    {
        this.correctUserName = correctUserName;
    }

    public String getCorrectUserName() 
    {
        return correctUserName;
    }
    public void setCorrectTime(Date correctTime) 
    {
        this.correctTime = correctTime;
    }

    public Date getCorrectTime() 
    {
        return correctTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileName", getFileName())
            .append("path", getPath())
            .append("score", getScore())
            .append("commitUserId", getCommitUserId())
            .append("commitUserName", getCommitUserName())
            .append("commitTime", getCommitTime())
            .append("correctUserId", getCorrectUserId())
            .append("correctUserName", getCorrectUserName())
            .append("correctTime", getCorrectTime())
            .toString();
    }
}
