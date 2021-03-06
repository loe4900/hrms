package com.entor.hrm.controller;

import com.entor.hrm.po.User;
import com.entor.hrm.service.UserService;
import com.entor.hrm.to.CommonMessage;
import com.entor.hrm.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.entor.hrm.util.common.HrmConstants.PAGE_DEFAULT_SIZE;
import static com.entor.hrm.util.common.HrmConstants.USER_SESSION;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@ModelAttribute User user, Model model, HttpSession session, HttpServletRequest request) {
        // 1.拦截/main的GET请求
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            model.addAttribute(new CommonMessage("请先登录..."));
            return "redirect:index";
        }

        // 2.判断当前session是否已经保存用户
        if (session.getAttribute(USER_SESSION) != null)
            return "redirect:main";

        // 3.根据登录名和密码查找用户
        user = userService.findByLoginNameAndPassword(user.getLoginName(), user.getPassword());
        if (user != null) {
            model.addAttribute(user);
            session.setAttribute(USER_SESSION, user);
            return "redirect:main";
        }
        model.addAttribute(new CommonMessage("用户名或密码不匹配！"));
        return "login";
    }

    @GetMapping("/main")
    public String main(Model model, HttpSession session) {
        model.addAttribute(session.getAttribute(USER_SESSION));
        return "hrms_main";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(USER_SESSION);
        return "login";
    }

    @GetMapping("/personel/{id}")
    public String personel(@PathVariable("id") Integer id, Model model) {
        model.addAttribute(userService.getById(id));
        return "user/hrms_user_center";
    }

    @PostMapping("/personel/edit")
    public String personel(@ModelAttribute User user, Model model) {
        userService.modifyUser(user);
        model.addAttribute("user", userService.getById(user.getId()));
        model.addAttribute(new CommonMessage("修改成功！"));
        return "user/hrms_user_center";
    }

    @GetMapping("/user/list")
    @ResponseBody
    public Object list(@ModelAttribute User user, Integer pageIndex, Integer pageSize) {
        if (pageIndex == null) {
            pageIndex = 1;
        }

        if (pageSize == null) {
            pageSize = PAGE_DEFAULT_SIZE;
        }
        return userService.getByPage(user, pageIndex, pageSize);
    }

    @GetMapping("/user/del/{id}")
    @ResponseBody
    public Object del(@PathVariable("id") Integer id) {
        userService.removeById(id);
        return new CommonMessage("删除成功！");
    }

    @PostMapping("/user/froze")
    @ResponseBody
    public Object froze(@ModelAttribute User user) {
        userService.modifyUser(user);
        if (user.getStatus() == 0)
            return new CommonMessage("冻结成功！");
        return new CommonMessage("解冻成功！");
    }

    @GetMapping("/user/look/{id}")
    public String look(@PathVariable("id") Integer id, Model model) {
        User user = userService.getById(id);
        user.setCreateDate(new java.sql.Date(user.getCreateDate().getTime()));
        model.addAttribute(user);
        return "user/hrms_user_look";
    }

    @RequestMapping("/user/update")
    public String update(@ModelAttribute User user, Model model, HttpServletRequest request) {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            model.addAttribute(userService.getById(user.getId()));
            return "user/hrms_user_update";
        }
        userService.modifyUser(user);
        model.addAttribute(new CommonMessage("修改成功！"));
        return "user/hrms_user";
    }

    @RequestMapping("/user/add")
    public String add(@ModelAttribute User user, Model model, HttpServletRequest request) {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            return "user/hrms_user_add";
        }
        userService.save(user);
        model.addAttribute(new CommonMessage("添加成功！"));
        return "user/hrms_user";
    }

    @RequestMapping("/user/batchDelete")
    @ResponseBody
    public Object batchDelete(@RequestParam("ids[]") Integer[] ids) {
        userService.batchRemoveUser(ids);
        return new CommonMessage("删除成功！");
    }

    @RequestMapping("/user/export")
    public void export(@RequestParam("ids[]") Integer[] ids, HttpServletResponse response) {
        try {
            // 1.准备集合
            List<User> list = userService.getByIds(ids);

            // 2.准备标题
            Map<String, String> titles = new HashMap<>();
            titles.put("id", "用户ID");
            titles.put("loginName", "登录名");
            titles.put("password", "密码");
            titles.put("status", "状态");
            titles.put("username", "用户名");
            titles.put("createDate", "创建日期");

            // 3.准备响应流
            String filename = new String("用户列表.xls".getBytes("UTF-8"), "iso-8859-1");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + filename);
            response.setHeader("Pragma", "No-cache");

            // 4.准备sheet名称
            String sheetName = "用户列表";

            // 4.调用导出Excel
            ExcelUtil<User> excelUtil = new ExcelUtil<>();
            excelUtil.export(titles, response.getOutputStream(), list, sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
