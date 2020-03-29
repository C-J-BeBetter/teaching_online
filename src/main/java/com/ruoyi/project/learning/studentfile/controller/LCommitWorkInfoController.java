package com.ruoyi.project.learning.studentfile.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.learning.work.domain.UploadWorkFileInfo;
import com.ruoyi.project.learning.work.service.IUploadWorkFileInfoService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.learning.studentfile.domain.LCommitWorkInfo;
import com.ruoyi.project.learning.studentfile.service.ILCommitWorkInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 提交作业信息Controller
 *
 * @author zsls
 * @date 2020-03-28
 */
@Controller
@RequestMapping("learning/studentfile")
public class LCommitWorkInfoController extends BaseController {
    private String prefix = "learning/studentfile";

    @Autowired
    private ILCommitWorkInfoService lCommitWorkInfoService;
    @Autowired
    private IUploadWorkFileInfoService uploadWorkFileInfoService;
    @Autowired
    private IUserService userService;

    @RequiresPermissions("learning:studentfile:view")
    @GetMapping()
    public String info() {
        return prefix + "/info";
    }

    /**
     * 查询提交作业信息列表
     */
    @RequiresPermissions("learning:studentfile:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(LCommitWorkInfo lCommitWorkInfo) {
        startPage();
        List<LCommitWorkInfo> list = lCommitWorkInfoService.selectLCommitWorkInfoList(lCommitWorkInfo);
        return getDataTable(list);
    }

    /**
     * 导出提交作业信息列表
     */
    @RequiresPermissions("learning:studentfile:export")
    @Log(title = "提交作业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LCommitWorkInfo lCommitWorkInfo) {
        List<LCommitWorkInfo> list = lCommitWorkInfoService.selectLCommitWorkInfoList(lCommitWorkInfo);
        ExcelUtil<LCommitWorkInfo> util = new ExcelUtil<LCommitWorkInfo>(LCommitWorkInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增提交作业信息
     */
    @GetMapping("/add")
    public String add(ModelMap map) {
        map.put("workFiles", uploadWorkFileInfoService.selectUploadWorkFileInfoList(new UploadWorkFileInfo()));
        return prefix + "/add";
    }

    /**
     * 新增保存提交作业信息
     */
    @RequiresPermissions("learning:studentfile:add")
    @Log(title = "提交作业信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file,LCommitWorkInfo lCommitWorkInfo) throws Exception {
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
        // 上传并返回新文件名称
        String path = FileUploadUtils.upload(filePath, file);
        User user = userService.selectUserByLoginName(lCommitWorkInfo.getCorrectUserId());
        lCommitWorkInfo.setCommitTime(new Date());
        lCommitWorkInfo.setPath(path);
        lCommitWorkInfo.setCorrectUserId(String.valueOf(user.getLoginName()));
        lCommitWorkInfo.setCorrectUserName(user.getUserName());
        lCommitWorkInfo.setCommitUserId(String.valueOf(ShiroUtils.getLoginName()));
        lCommitWorkInfo.setCommitUserName(ShiroUtils.getSysUser().getUserName());
        return toAjax(lCommitWorkInfoService.insertLCommitWorkInfo(lCommitWorkInfo));
    }

    /**
     * 修改提交作业信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        LCommitWorkInfo lCommitWorkInfo = lCommitWorkInfoService.selectLCommitWorkInfoById(id);
        mmap.put("lCommitWorkInfo", lCommitWorkInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存提交作业信息
     */
    @RequiresPermissions("learning:studentfile:edit")
    @Log(title = "提交作业信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(LCommitWorkInfo lCommitWorkInfo) {
        lCommitWorkInfo.setCorrectTime(new Date());
        return toAjax(lCommitWorkInfoService.updateLCommitWorkInfo(lCommitWorkInfo));
    }

    /**
     * 删除提交作业信息
     */
    @RequiresPermissions("learning:studentfile:remove")
    @Log(title = "提交作业信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(lCommitWorkInfoService.deleteLCommitWorkInfoByIds(ids));
    }
}
