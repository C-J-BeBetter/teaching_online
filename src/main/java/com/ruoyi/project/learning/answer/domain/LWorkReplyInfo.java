package com.ruoyi.project.learning.answer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;
import java.util.List;

/**
 * 作业讨论答疑信息对象 l_work_reply_info
 * 
 * @author ruoyi
 * @date 2020-03-22
 */
public class LWorkReplyInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 回复ID */
    private Long id;

    /** 回复内容 */
    @Excel(name = "回复内容")
    private String reply;

    /** 回复人id */
    @Excel(name = "回复人id")
    private String replyFromUserId;

    /** 回复人姓名 */
    @Excel(name = "回复人姓名")
    private String replyFromUserName;

    /** 回复对象id */
    @Excel(name = "回复对象id")
    private String replyToUserId;

    /** 回复对象姓名 */
    @Excel(name = "回复对象姓名")
    private String replyToUserName;

    /** 回复时间 */
    @Excel(name = "回复时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date replyTime;

    /** 关联作业成绩id */
    @Excel(name = "关联作业成绩id")
    private Long wbId;

    /** 关联作业名 */
    @Excel(name = "关联作业名")
    private String wbName;

    private String publishDate;

    private List<LWorkReplyInfo> replyInfoList;

    public List<LWorkReplyInfo> getReplyInfoList() {
        return replyInfoList;
    }

    public void setReplyInfoList(List<LWorkReplyInfo> replyInfoList) {
        this.replyInfoList = replyInfoList;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setReply(String reply) 
    {
        this.reply = reply;
    }

    public String getReply() 
    {
        return reply;
    }
    public void setReplyFromUserId(String replyFromUserId) 
    {
        this.replyFromUserId = replyFromUserId;
    }

    public String getReplyFromUserId() 
    {
        return replyFromUserId;
    }
    public void setReplyFromUserName(String replyFromUserName) 
    {
        this.replyFromUserName = replyFromUserName;
    }

    public String getReplyFromUserName() 
    {
        return replyFromUserName;
    }
    public void setReplyToUserId(String replyToUserId) 
    {
        this.replyToUserId = replyToUserId;
    }

    public String getReplyToUserId() 
    {
        return replyToUserId;
    }
    public void setReplyToUserName(String replyToUserName) 
    {
        this.replyToUserName = replyToUserName;
    }

    public String getReplyToUserName() 
    {
        return replyToUserName;
    }
    public void setReplyTime(Date replyTime) 
    {
        this.replyTime = replyTime;
    }

    public Date getReplyTime() 
    {
        return replyTime;
    }
    public void setWbId(Long wbId) 
    {
        this.wbId = wbId;
    }

    public Long getWbId() 
    {
        return wbId;
    }
    public void setWbName(String wbName) 
    {
        this.wbName = wbName;
    }

    public String getWbName() 
    {
        return wbName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("reply", getReply())
            .append("replyFromUserId", getReplyFromUserId())
            .append("replyFromUserName", getReplyFromUserName())
            .append("replyToUserId", getReplyToUserId())
            .append("replyToUserName", getReplyToUserName())
            .append("replyTime", getReplyTime())
            .append("wbId", getWbId())
            .append("wbName", getWbName())
            .toString();
    }
}
