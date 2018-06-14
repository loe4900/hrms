package com.entor.hrm.service;

import com.entor.hrm.po.Job;
import com.entor.hrm.service.impl.PageModel;

import java.util.List;

/**
 * 用户服务接口
 */
public interface JobService {


    /**
     * 获得所有用户信息
     *
     * @return {@link List<Job>}
     */
    List<Job> getAll();

    /**
     * 根据参数获得用户分页信息
     *
     * @param job      关键字
     * @param pageIndex 当前页码
     * @param pageSize  指定分页记录数
     * @return {@link PageModel<Job>}
     */
    PageModel<Job> getByPage(Job job, Integer pageIndex, Integer pageSize);

    /**
     * 动态修改用户
     *
     * @param job
     */
    void modifyJob(Job job);

    /**
     * 动态保存用户
     *
     * @param job
     */
    void save(Job job);

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
    void batchRemoveJob(Integer[] ids);

    /**
     * 根据id获得用户
     *
     * @param id
     * @return
     */
    Job getById(Integer id);
}
