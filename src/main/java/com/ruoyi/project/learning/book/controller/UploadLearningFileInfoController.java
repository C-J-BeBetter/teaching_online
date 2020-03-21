package com.ruoyi.project.learning.book.controller;

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
import com.ruoyi.project.learning.book.domain.UploadLearningFileInfo;
import com.ruoyi.project.learning.book.service.IUploadLearningFileInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 学习资料管理Controller
 * 
 * @author ruoyi
 * @date 2020-03-21
 */
@Controller
@RequestMapping("/learning/book")
public class UploadLearningFileInfoController extends BaseController
{
    private String prefix = "learning/book";

    @Autowired
    private IUploadLearningFileInfoService uploadLearningFileInfoService;

    @RequiresPermissions("learning:book:view")
    @GetMapping()
    public String book()
    {
        return prefix + "/book";
    }

    /**
     * 查询学习资料管理列表
     */
    @RequiresPermissions("learning:book:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UploadLearningFileInfo uploadLearningFileInfo)
    {
        startPage();
        List<UploadLearningFileInfo> list = uploadLearningFileInfoService.selectUploadLearningFileInfoList(uploadLearningFileInfo);
        return getDataTable(list);
    }

    /**
     * 导出学习资料管理列表
     */
    @RequiresPermissions("learning:book:export")
    @Log(title = "学习资料管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UploadLearningFileInfo uploadLearningFileInfo)
    {
        List<UploadLearningFileInfo> list = uploadLearningFileInfoService.selectUploadLearningFileInfoList(uploadLearningFileInfo);
        ExcelUtil<UploadLearningFileInfo> util = new ExcelUtil<UploadLearningFileInfo>(UploadLearningFileInfo.class);
        return util.exportExcel(list, "book");
    }

    /**
     * 新增学习资料管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学习资料管理
     */
    @RequiresPermissions("learning:book:add")
    @Log(title = "学习资料管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file")MultipartFile file, UploadLearningFileInfo uploadLearningFileInfo) throws IOException
    {
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
        // 上传并返回新文件名称
        String fileName = FileUploadUtils.upload(filePath, file);
        User sysUser = ShiroUtils.getSysUser();
        uploadLearningFileInfo.setPath(fileName);
        uploadLearningFileInfo.setUserId(sysUser.getLoginName());
        uploadLearningFileInfo.setUserName(sysUser.getUserName());
        return toAjax(uploadLearningFileInfoService.insertUploadLearningFileInfo(uploadLearningFileInfo));
    }

    /**
     * 修改学习资料管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        UploadLearningFileInfo uploadLearningFileInfo = uploadLearningFileInfoService.selectUploadLearningFileInfoById(id);
        mmap.put("uploadLearningFileInfo", uploadLearningFileInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存学习资料管理
     */
    @RequiresPermissions("learning:book:edit")
    @Log(title = "学习资料管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UploadLearningFileInfo uploadLearningFileInfo)
    {
        return toAjax(uploadLearningFileInfoService.updateUploadLearningFileInfo(uploadLearningFileInfo));
    }

    /**
     * 删除学习资料管理
     */
    @RequiresPermissions("learning:book:remove")
    @Log(title = "学习资料管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uploadLearningFileInfoService.deleteUploadLearningFileInfoByIds(ids));
    }
}
