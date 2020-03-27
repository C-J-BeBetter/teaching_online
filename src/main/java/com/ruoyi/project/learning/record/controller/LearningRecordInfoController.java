package com.ruoyi.project.learning.record.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.learning.record.domain.LearningRecordInfo;
import com.ruoyi.project.learning.record.service.ILearningRecordInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 学习记录信息Controller
 * 
 * @author ruoyi
 * @date 2020-03-27
 */
@Controller
@RequestMapping("/learning/record")
public class LearningRecordInfoController extends BaseController
{
    private String prefix = "learning/record";

    @Autowired
    private ILearningRecordInfoService learningRecordInfoService;

    @RequiresPermissions("learning:record:view")
    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }

    /**
     * 查询学习记录信息列表
     */
    @RequiresPermissions("learning:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LearningRecordInfo learningRecordInfo)
    {
        startPage();
        List<LearningRecordInfo> list = learningRecordInfoService.selectLearningRecordInfoList(learningRecordInfo);
        return getDataTable(list);
    }

    /**
     * 导出学习记录信息列表
     */
    @RequiresPermissions("learning:record:export")
    @Log(title = "学习记录信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LearningRecordInfo learningRecordInfo)
    {
        List<LearningRecordInfo> list = learningRecordInfoService.selectLearningRecordInfoList(learningRecordInfo);
        ExcelUtil<LearningRecordInfo> util = new ExcelUtil<LearningRecordInfo>(LearningRecordInfo.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 新增学习记录信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学习记录信息
     */
    @RequiresPermissions("learning:record:add")
    @Log(title = "学习记录信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(LearningRecordInfo learningRecordInfo)
    {
        return toAjax(learningRecordInfoService.insertLearningRecordInfo(learningRecordInfo));
    }

    /**
     * 修改学习记录信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        LearningRecordInfo learningRecordInfo = learningRecordInfoService.selectLearningRecordInfoById(id);
        mmap.put("learningRecordInfo", learningRecordInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存学习记录信息
     */
    @RequiresPermissions("learning:record:edit")
    @Log(title = "学习记录信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LearningRecordInfo learningRecordInfo)
    {
        return toAjax(learningRecordInfoService.updateLearningRecordInfo(learningRecordInfo));
    }

    /**
     * 删除学习记录信息
     */
    @RequiresPermissions("learning:record:remove")
    @Log(title = "学习记录信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(learningRecordInfoService.deleteLearningRecordInfoByIds(ids));
    }
}
