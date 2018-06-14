package com.entor.hrm.controller;

import com.entor.hrm.po.Dept;
import com.entor.hrm.po.Employee;
import com.entor.hrm.po.Job;
import com.entor.hrm.po.User;
import com.entor.hrm.service.EmployeeService;
import com.entor.hrm.to.CommonMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.entor.hrm.util.common.HrmConstants.EMPLOYEE_TABLE;
import static com.entor.hrm.util.common.HrmConstants.PAGE_DEFAULT_SIZE;
import static com.entor.hrm.util.common.HrmConstants.USER_SESSION;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/list")
    @ResponseBody
    public Object list(@ModelAttribute Employee employee, Integer pageIndex, Integer pageSize) {
        if (pageIndex == null) {
            pageIndex = 1;
        }

        if (pageSize == null) {
            pageSize = PAGE_DEFAULT_SIZE;
        }
        return employeeService.getByPage(employee, pageIndex, pageSize);
    }

    @GetMapping("/employee/look/{id}")
    public String look(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.getById(id);
        employee.setCreateDate(new java.sql.Date(employee.getCreateDate().getTime()));
        model.addAttribute(employee);
        return "employee/hrms_employee_look";
    }

    @RequestMapping("/employee/update")
    public String update(@ModelAttribute Employee employee, Model model, HttpServletRequest request) {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            model.addAttribute(employeeService.getById(employee.getId()));
            return "employee/hrms_employee_update";
        }
        employeeService.modifyEmployee(employee);
        model.addAttribute(new CommonMessage("修改成功！"));
        return "employee/hrms_employee";
    }

    @GetMapping("/employee/del/{id}")
    @ResponseBody
    public Object del(@PathVariable("id") Integer id) {
        employeeService.removeById(id);
        return new CommonMessage("删除成功！");
    }
    @RequestMapping("/employee/batchDelete")
    @ResponseBody
    public Object batchDelete(@RequestParam("ids[]") Integer[] ids) {
        employeeService.batchRemoveEmployee(ids);
        return new CommonMessage("删除成功！");
    }

    @RequestMapping("/employee/add")
    public String add(@ModelAttribute Employee employee, Model model, HttpServletRequest request, HttpSession session) {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            return "employee/hrms_employee_add";
        }
        employeeService.save(employee);
        model.addAttribute(new CommonMessage("添加成功！"));
        return "employee/hrms_employee";
    }


}
