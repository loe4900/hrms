package com.entor.hrm.service.impl;

import com.entor.hrm.mapper.EmployeeMapper;
import com.entor.hrm.po.Employee;
import com.entor.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.transaction.annotation.Isolation.DEFAULT;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service("EmployeeService")
@Transactional(propagation = REQUIRED, isolation = DEFAULT, readOnly = false)
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll() {
        System.out.println("调用了EmployeeServiceImpl里的getAll()方法");
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageModel<Employee> getByPage(Employee employee, Integer pageIndex, Integer pageSize) {
        System.out.println("调用了EmployeeServiceImpl里的getByPage()方法");
        // 1.整理参数
        Map<String, Object> params = new HashMap<>();
        params.put("employee", employee);
        // 根据检索条件查询记录总数
        int recordCount = employeeMapper.count(params);
        // 整理分页参数
        PageModel<Employee> pageModel = new PageModel<>();
        pageModel.setPageIndex(pageIndex);
        pageModel.setPageSize(pageSize);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            // 根据检索和分页条件查询用户记录，保存到分页对象中
            params.put("pageModel", pageModel);
            pageModel.setPageList(employeeMapper.selectByPage(params));
        }
        return pageModel;
    }
    @Override
    public Employee getById(Integer id) {
        System.out.println("调用了EmployeeServiceImpl里的getById()方法");
        return employeeMapper.selectById(id);
    }
    @Override
    public void modifyEmployee(Employee employee) {
        System.out.println("调用了EmployeeServiceImpl里的modifyEmployee()方法");
        employeeMapper.update(employee);
    }
    @Override
    public void removeById(Integer id) {
        System.out.println("调用了EmployeeServiceImpl里的removeById()方法");
        employeeMapper.deleteById(id);
    }
    @Override
    public void batchRemoveEmployee(Integer[] ids) {
        System.out.println("调用了EmployeeServiceImpl里的batchRemoveEmployee()方法");
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        employeeMapper.batchDelete(params);
    }

    @Override
    public void save(Employee employee) {
        System.out.println("调用了EmployeeServiceImpl里的save()方法");
        employeeMapper.save(employee);
    }
}
