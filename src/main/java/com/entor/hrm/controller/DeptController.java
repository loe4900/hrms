package com.entor.hrm.controller;


import com.entor.hrm.po.Dept;
import com.entor.hrm.service.DeptService;
import com.entor.hrm.to.CommonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.entor.hrm.util.common.HrmConstants.PAGE_DEFAULT_SIZE;

@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;


    @GetMapping("/dept/list")
    @ResponseBody
    public Object list(@ModelAttribute Dept dept, Integer pageIndex, Integer pageSize) {
        if (pageIndex == null) {
            pageIndex = 1;
        }

        if (pageSize == null) {
            pageSize = PAGE_DEFAULT_SIZE;
        }
        return deptService.getByPage(dept, pageIndex, pageSize);
    }

    @GetMapping("/dept/del/{id}")
    @ResponseBody
    public Object del(@PathVariable("id") Integer id) {
        deptService.removeById(id);
        return new CommonMessage("删除成功！");
    }

    @GetMapping("/dept/look/{id}")
    public String look(@PathVariable("id") Integer id, Model model) {
        Dept dept = deptService.getById(id);
        model.addAttribute(dept);
        return "/dept/hrms_dept_look";
    }

    @RequestMapping("/dept/update")
    public String update(@ModelAttribute Dept dept, Model model, HttpServletRequest request) {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            model.addAttribute(deptService.getById(dept.getId()));
            return "/dept/hrms_dept_update";
        }
        deptService.modifyUser(dept);
        model.addAttribute(new CommonMessage("修改成功！"));
        return "/dept/hrms_dept";
    }

    @RequestMapping("/dept/add")
    public String add(@ModelAttribute Dept dept, Model model, HttpServletRequest request) {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            return "/dept/hrms_dept_add";
        }
        deptService.save(dept);
        model.addAttribute(new CommonMessage("添加成功！"));
        return "/dept/hrms_dept";
    }

}
