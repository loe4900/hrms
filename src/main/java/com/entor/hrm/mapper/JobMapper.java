package com.entor.hrm.mapper;

import com.entor.hrm.mapper.provider.JobDynaSQLProvider;
import com.entor.hrm.po.Job;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.entor.hrm.util.common.HrmConstants.JOB_TABLE;

public interface JobMapper {

    /**
     * 根据id查询用户
     *
     * @param id
     * @return {@link Job}
     */
    @Select("select * from " + JOB_TABLE + " where id = #{id}")
    Job selectById(Integer id);

    /**
     * 查询所有记录
     *
     * @return
     */
    @Select("select * from " + JOB_TABLE)
    @Results({
            @Result(column = "login_name", property = "loginName", javaType = String.class),
            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class)
    })
    List<Job> selectAll();

    /**
     * 动态查询用户分页记录
     *
     * @param params ①检索的条件；②分页参数
     * @return {@link List<Job>}
     */
    @SelectProvider(type = JobDynaSQLProvider.class, method = "selectWithParams")
    @Results({
            @Result(column = "login_name", property = "loginName", javaType = String.class),
            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class)
    })
    List<Job> selectByPage(Map<String, Object> params);

    /**
     * 动态查询用户记录总数
     *
     * @param params ①检索的条件
     * @return
     */
    @SelectProvider(type = JobDynaSQLProvider.class, method = "count")
    int count(Map<String, Object> params);

    /**
     * 动态更新用户
     *
     * @param job
     */
    @UpdateProvider(type = JobDynaSQLProvider.class, method = "updatejob")
    void update(Job job);

    /**
     * 动态插入用户
     *
     * @param job
     */
    @InsertProvider(type = JobDynaSQLProvider.class, method = "insertjob")
    void insert(Job job);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    @Delete("delete from " + JOB_TABLE + " where id = #{id}")
    void deleteById(Integer id);

    /**
     * 根据id批量删除用户
     *
     * @param params
     */
    @DeleteProvider(type = JobDynaSQLProvider.class, method = "batchDeletejob")
    void batchDelete(Map<String, Object> params);
}
