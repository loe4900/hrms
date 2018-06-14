package com.entor.hrm.mapper;

import com.entor.hrm.mapper.provider.EmployeeDynaSQLProvider;
import com.entor.hrm.po.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.entor.hrm.util.common.HrmConstants.EMPLOYEE_TABLE;
import static org.apache.ibatis.mapping.FetchType.EAGER;

public interface EmployeeMapper {
    /**
     * 动态查询通知
     *
     * @param params
     * @return {@link List<Employee>}
     */
    @SelectProvider(type = EmployeeDynaSQLProvider.class, method = "selectWithParams")
    @Results({
            @Result(column = "dept_id",property = "dept",javaType = com.entor.hrm.po.Dept.class,
                    one = @One(select = "com.entor.hrm.mapper.DeptMapper.selectById", fetchType = EAGER)),
            @Result(column = "job_id",property = "job",javaType = com.entor.hrm.po.Job.class,
                    one = @One(select = "com.entor.hrm.mapper.JobMapper.selectById", fetchType = EAGER)),
            @Result(column = "card_id",property = "cardId",javaType = java.lang.String.class),
            @Result(column = "post_code",property = "postcode",javaType = java.lang.String.class),
            @Result(column = "qq_num",property = "qqNum",javaType = java.lang.String.class),
            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class)
    })
    List<Employee> selectByPage(Map<String, Object> params);

    /**
     * 动态查询通知总记录数
     *
     * @param params
     * @return {@link Integer}
     */
    @SelectProvider(type = EmployeeDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    /**
     * 查询所有用户
     *
     * @return {@link List<Employee>}
     */
    @Select("select * from " + EMPLOYEE_TABLE + " ")
    @Results({
            @Result(column = "dept_id",property = "dept",javaType = com.entor.hrm.po.Dept.class,
                    one = @One(select = "com.entor.hrm.mapper.DeptMapper.selectById", fetchType = EAGER)),
            @Result(column = "job_id",property = "job",javaType = com.entor.hrm.po.Job.class,
                    one = @One(select = "com.entor.hrm.mapper.JobMapper.selectById", fetchType = EAGER)),
            @Result(column = "card_id",property = "cardId",javaType = java.lang.String.class),
            @Result(column = "post_code",property = "postcode",javaType = java.lang.String.class),
            @Result(column = "qq_num",property = "qqNum",javaType = java.lang.String.class),
            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class)
    })
    List<Employee> getAllEmployee();

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @Select("select * from " + EMPLOYEE_TABLE + " where id = #{id} ")
    @Results({
            @Result(column = "dept_id",property = "dept",javaType = com.entor.hrm.po.Dept.class,
                    one = @One(select = "com.entor.hrm.mapper.DeptMapper.selectById", fetchType = EAGER)),
            @Result(column = "job_id",property = "job",javaType = com.entor.hrm.po.Job.class,
                    one = @One(select = "com.entor.hrm.mapper.JobMapper.selectById", fetchType = EAGER)),
            @Result(column = "card_id",property = "cardId",javaType = java.lang.String.class),
            @Result(column = "post_code",property = "postcode",javaType = java.lang.String.class),
            @Result(column = "qq_num",property = "qqNum",javaType = java.lang.String.class),
            @Result(column = "create_date",property = "createDate",javaType = java.util.Date.class)
    })
    Employee selectById(Integer id);

    /**
     * 动态修改用户
     *
     * @param employee
     *
     */
    @SelectProvider(type = EmployeeDynaSQLProvider.class, method = "updateEmployee")
    void update(Employee employee);

    /**
     * 根据id删除通知
     *
     * @param id
     */
    @Delete("delete from " + EMPLOYEE_TABLE + " where id = #{id} ")
    void deleteById(Integer id);

    /**
     * 根据id批量删除通知
     *
     * @param params
     */
    @DeleteProvider(type = EmployeeDynaSQLProvider.class, method = "batchDeleteEmployee")
    void batchDelete(Map<String, Object> params);

    /**
     * 动态插入用户
     *
     * @param employee
     */
    @SelectProvider(type = EmployeeDynaSQLProvider.class, method = "insertEmployee")
    void save(Employee employee);

}
