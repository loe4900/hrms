package com.entor.hrm.service;

import com.entor.hrm.po.Employee;
import com.entor.hrm.po.Job;
import com.entor.hrm.service.impl.PageModel;

import java.util.List;

public interface EmployeeService {


    /**
     * 获得所有用户信息
     *
     * @return {@link List<Employee>}
     */
    List<Employee> getAll();

    /**
     * 根据参数获得用户分页信息
     *
     * @param employee      关键字
     * @param pageIndex 当前页码
     * @param pageSize  指定分页记录数
     * @return {@link PageModel<Employee>}
     */
    PageModel<Employee> getByPage(Employee employee, Integer pageIndex, Integer pageSize);

    /**
     * 根据id查询通知
     *
     * @param id
     * @return
     */
    Employee getById(Integer id);
    /**
     * 修改通知
     *
     * @param employee
     */
    void modifyEmployee(Employee employee);

    /**
     * 根据id删除通知
     *
     * @param id
     */
    void removeById(Integer id);

    /**
     * 根据id批量移除通知
     *
     * @param ids
     */
    void batchRemoveEmployee(Integer[] ids);

    /**
     * 添加通知
     *
     * @param employee
     */
    void save(Employee employee);
}
