package com.ruoyi.project.learning.answer.controller;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.learning.answer.domain.LWorkReplyInfo;
import com.ruoyi.project.learning.answer.service.ILWorkReplyInfoService;
import com.ruoyi.project.learning.work.domain.UploadWorkFileInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 作业讨论答疑信息Controller
 *
 * @author ruoyi
 * @date 2020-03-22
 */
@Controller
@RequestMapping("/learning/answer")
public class LWorkReplyInfoController extends BaseController {
    private String prefix = "learning/answer";

    @Autowired
    private ILWorkReplyInfoService lWorkReplyInfoService;


    @RequiresPermissions("learning:answer:view")
    @GetMapping("/info")
    public String info() {
        return prefix + "/info";
    }

    /**
     * 查询作业讨论答疑信息列表
     */
    @RequiresPermissions("learning:answer:list")
    @GetMapping()
    public String answer(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, ModelMap mmap) {
        startPage();
        List<UploadWorkFileInfo> answerList = lWorkReplyInfoService.selectWorkByUser();

        PageInfo<UploadWorkFileInfo> pageInfo = PageInfo.of(answerList);
        mmap.put("tableDataInfo", pageInfo);
        mmap.put("currentPage", pageNum);
        mmap.put("size", pageSize);
        return prefix + "/answer";
    }


    /**
     * 作业答疑详情
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(value = "id") String wdId, ModelMap mmap) {

        Map<String, Object> themeInfo = lWorkReplyInfoService.replyContnet(Long.valueOf(wdId));
        mmap.put("themeDescription", themeInfo.get("themeDescription"));
        mmap.put("themeName", themeInfo.get("themeName"));
        mmap.put("themeId", themeInfo.get("themeId"));
        mmap.put("replyInfos", themeInfo.get("replyInfos"));
        return prefix + "/detail";
    }


    /**
     * 新增保存作业讨论答疑信息
     */
    @RequiresPermissions("learning:answer:add")
    @Log(title = "作业讨论答疑信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("reply") String reply, @RequestParam("wbId") String wbId, @RequestParam("wbName") String wbName,
                              @RequestParam("replyToUserId") String replyToUserId, @RequestParam("replyToUserName") String replyToUserName) {
        LWorkReplyInfo lWorkReplyInfo = new LWorkReplyInfo();
        lWorkReplyInfo.setWbId(Long.valueOf(wbId));
        lWorkReplyInfo.setReply(reply);
        lWorkReplyInfo.setWbName(wbName);
        lWorkReplyInfo.setReplyTime(new Date());
        lWorkReplyInfo.setReplyFromUserId(String.valueOf(ShiroUtils.getSysUser().getUserId()));
        lWorkReplyInfo.setReplyFromUserName(ShiroUtils.getSysUser().getUserName());
        if(StringUtils.isNotEmpty(replyToUserId)){
            lWorkReplyInfo.setReplyToUserId(replyToUserId);
            lWorkReplyInfo.setReplyToUserName(replyToUserName);
        }
        return toAjax(lWorkReplyInfoService.insertLWorkReplyInfo(lWorkReplyInfo));
    }


    /**
     * 删除作业讨论答疑信息
     */
    @RequiresPermissions("learning:answer:remove")
    @Log(title = "作业讨论答疑信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(lWorkReplyInfoService.deleteLWorkReplyInfoByIds(ids));
    }
}
