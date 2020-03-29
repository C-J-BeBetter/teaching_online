package com.ruoyi.project.system.user.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.post.service.IPostService;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 注册用户信息
 *
 * @author ruoyi
 */
@Controller
public class RegisterController extends BaseController
{
    private String prefix = "register";

    @Autowired
    private IPostService postService;

    @GetMapping("/register")
    public String user(ModelMap mmap)
    {
        mmap.put("posts", postService.selectPostAll());
        return prefix;
    }


}