package com.baker.learning.learnshirojwt.controller;

import com.baker.learning.learnshirojwt.constant.RedirectConstants;
import com.baker.learning.learnshirojwt.exception.UnauthorizedException;
import com.baker.learning.learnshirojwt.model.User;
import com.baker.learning.learnshirojwt.model.req.RespVO;
import com.baker.learning.learnshirojwt.service.UserService;
import com.baker.learning.learnshirojwt.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @desc
 * @date 2020/2/6 0006 - 11:17
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public RespVO login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        User User = userService.getByName(username);
        if (User.getPassword().equals(password)) {
            return new RespVO(200, "login success", JWTUtil.sign(username, password));
        } else {
            throw new UnauthorizedException("login fail");
        }
    }

    /**
     * 所有人都可以访问，但是用户与游客看到的内容不同
     *
     * @return
     */
    @GetMapping("/article")
    public RespVO article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new RespVO(200, "You are already logged in", null);
        } else {
            return new RespVO(200, "You are guest", null);
        }
    }


    /**
     * 登入的用户才可以进行访问
     *
     * @return
     */
    @GetMapping("/require_auth")
    @RequiresAuthentication
    public RespVO requireAuth() {
        return new RespVO(200, "You are authenticated", null);
    }

    /**
     * admin的角色用户才可以登入
     *
     * @return
     */
    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public RespVO requireRole() {
        return new RespVO(200, "You are visiting require_role", null);
    }

    /**
     * 拥有view和edit权限的用户才可以访问
     *
     * @return
     */
    @GetMapping("/require_permission")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public RespVO requirePermission() {
        return new RespVO(200, "You are visiting permission require edit,view", null);
    }

    @RequestMapping(path = RedirectConstants.ROUTER_MAPPING_401)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public RespVO unauthorized() {
        return new RespVO(401, "Unauthorized", null);
    }

}
