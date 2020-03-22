package com.ruoyi.project.learning.answer.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.learning.answer.domain.LWorkReplyInfo;
import com.ruoyi.project.learning.answer.service.ILWorkReplyInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequiresPermissions("learning:answer:view")
    @GetMapping()
    public String answer()
    {
        return prefix + "/answer";
    }

    /**
     * 查询作业讨论答疑信息列表
     */
    @RequiresPermissions("learning:answer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LWorkReplyInfo lWorkReplyInfo)
    {
        startPage();
        List<LWorkReplyInfo> list = lWorkReplyInfoService.selectLWorkReplyInfoList(lWorkReplyInfo);
        return getDataTable(list);
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
