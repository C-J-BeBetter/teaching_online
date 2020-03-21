package com.ruoyi.project.learning.work.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.learning.work.domain.UploadWorkFileInfo;
import com.ruoyi.project.learning.work.service.IUploadWorkFileInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 作业资料管理Controller
 * 
 * @author ruoyi
 * @date 2020-03-21
 */
@Controller
@RequestMapping("/learning/work")
public class UploadWorkFileInfoController extends BaseController
{
    private String prefix = "learning/work";

    @Autowired
    private IUploadWorkFileInfoService uploadWorkFileInfoService;

    @RequiresPermissions("learning:work:view")
    @GetMapping()
    public String work()
    {
        return prefix + "/work";
    }

    /**
     * 查询作业资料管理列表
     */
    @RequiresPermissions("learning:work:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UploadWorkFileInfo uploadWorkFileInfo)
    {
        startPage();
        List<UploadWorkFileInfo> list = uploadWorkFileInfoService.selectUploadWorkFileInfoList(uploadWorkFileInfo);
        return getDataTable(list);
    }

    /**
     * 导出作业资料管理列表
     */
    @RequiresPermissions("learning:work:export")
    @Log(title = "作业资料管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UploadWorkFileInfo uploadWorkFileInfo)
    {
        List<UploadWorkFileInfo> list = uploadWorkFileInfoService.selectUploadWorkFileInfoList(uploadWorkFileInfo);
        ExcelUtil<UploadWorkFileInfo> util = new ExcelUtil<UploadWorkFileInfo>(UploadWorkFileInfo.class);
        return util.exportExcel(list, "work");
    }

    /**
     * 新增作业资料管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存作业资料管理
     */
    @RequiresPermissions("learning:work:add")
    @Log(title = "作业资料管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file, UploadWorkFileInfo uploadWorkFileInfo) throws IOException {
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, file);
        User   sysUser  = ShiroUtils.getSysUser();
        uploadWorkFileInfo.setPath(fileName);
        uploadWorkFileInfo.setUserId(sysUser.getLoginName());
        uploadWorkFileInfo.setUserName(sysUser.getUserName());
        return toAjax(uploadWorkFileInfoService.insertUploadWorkFileInfo(uploadWorkFileInfo));
    }

    /**
     * 修改作业资料管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UploadWorkFileInfo uploadWorkFileInfo = uploadWorkFileInfoService.selectUploadWorkFileInfoById(id);
        mmap.put("uploadWorkFileInfo", uploadWorkFileInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存作业资料管理
     */
    @RequiresPermissions("learning:work:edit")
    @Log(title = "作业资料管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UploadWorkFileInfo uploadWorkFileInfo)
    {
        return toAjax(uploadWorkFileInfoService.updateUploadWorkFileInfo(uploadWorkFileInfo));
    }

    /**
     * 删除作业资料管理
     */
    @RequiresPermissions("learning:work:remove")
    @Log(title = "作业资料管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uploadWorkFileInfoService.deleteUploadWorkFileInfoByIds(ids));
    }
}
