package com.entor.hrm.service;

import com.entor.hrm.po.Dept;
import com.entor.hrm.service.impl.PageModel;

import java.util.List;

public interface DeptService {


    /**
     * 根据id查询用户
     * @return
     */
    Dept getById(Integer id);
    /**
     * 获得所有用户信息
     *
     * @return {@link List <Dept>}
     */
    List<Dept> getAll();

    /**
     * 根据参数获得用户分页信息
     *
     * @param dept      关键字
     * @param pageIndex 当前页码
     * @param pageSize  指定分页记录数
     * @return {@link PageModel <Dept>}
     */
    PageModel<Dept> getByPage(Dept dept, Integer pageIndex, Integer pageSize);

    /**
     * 动态修改用户
     *
     * @param dept
     */
    void modifyUser(Dept dept);

    /**
     * 动态保存用户
     *
     * @param dept
     */
    void save(Dept dept);

    /**
     * 根据id移除用户
     *
     * @param id
     */
    void removeById(Integer id);

    /**
     * 根据id批量移除用户
     *
     * @param ids
     */
    void batchRemoveDept(Integer[] ids);
}
