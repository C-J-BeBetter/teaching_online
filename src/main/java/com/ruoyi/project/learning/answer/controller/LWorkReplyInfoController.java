package com.ruoyi.project.learning.answer.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.learning.answer.domain.LWorkReplyInfo;
import com.ruoyi.project.learning.answer.service.ILWorkReplyInfoService;
import com.ruoyi.project.learning.work.domain.UploadWorkFileInfo;
import com.ruoyi.project.learning.work.service.IUploadWorkFileInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
public class LWorkReplyInfoController extends BaseController
{
    private String prefix = "learning/answer";

    @Autowired
    private ILWorkReplyInfoService lWorkReplyInfoService;


    @RequiresPermissions("learning:answer:view")
    @GetMapping("/info")
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询作业讨论答疑信息列表
     */
    @RequiresPermissions("learning:answer:list")
    @GetMapping()
    public String answer(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,ModelMap mmap)
    {
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
    @RequiresPermissions("learning:answer:list")
    @GetMapping("/detail/{wbId}")
    public String detail(@PathVariable(value = "wbId") Long wdId, ModelMap mmap)
    {

//        List<LWorkReplyInfo> replyInfos = lWorkReplyInfoService.selectLWorkReplyInfoList(workReplyInfo);
//        mmap.put("replyInfos",replyInfos);
        return prefix + "/detail";
    }


    /**
     * 导出作业讨论答疑信息列表
     */
    @RequiresPermissions("learning:answer:export")
    @Log(title = "作业讨论答疑信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LWorkReplyInfo lWorkReplyInfo)
    {
        List<LWorkReplyInfo> list = lWorkReplyInfoService.selectLWorkReplyInfoList(lWorkReplyInfo);
        ExcelUtil<LWorkReplyInfo> util = new ExcelUtil<LWorkReplyInfo>(LWorkReplyInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增作业讨论答疑信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存作业讨论答疑信息
     */
    @RequiresPermissions("learning:answer:add")
    @Log(title = "作业讨论答疑信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LWorkReplyInfo lWorkReplyInfo)
    {
        return toAjax(lWorkReplyInfoService.insertLWorkReplyInfo(lWorkReplyInfo));
    }

    /**
     * 修改作业讨论答疑信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LWorkReplyInfo lWorkReplyInfo = lWorkReplyInfoService.selectLWorkReplyInfoById(id);
        mmap.put("lWorkReplyInfo", lWorkReplyInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存作业讨论答疑信息
     */
    @RequiresPermissions("learning:answer:edit")
    @Log(title = "作业讨论答疑信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LWorkReplyInfo lWorkReplyInfo)
    {
        return toAjax(lWorkReplyInfoService.updateLWorkReplyInfo(lWorkReplyInfo));
    }

    /**
     * 删除作业讨论答疑信息
     */
    @RequiresPermissions("learning:answer:remove")
    @Log(title = "作业讨论答疑信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(lWorkReplyInfoService.deleteLWorkReplyInfoByIds(ids));
    }
}
