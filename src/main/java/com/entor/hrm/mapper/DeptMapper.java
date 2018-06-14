package com.entor.hrm.mapper;

import com.entor.hrm.mapper.provider.DeptDynaSQLProvider;
import com.entor.hrm.po.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.entor.hrm.util.common.HrmConstants.DEPT_TABLE;

public interface DeptMapper {

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @Select("select * from " + DEPT_TABLE + " where id = #{id}")
    Dept selectById(Integer id);

    /**
     * 查询所有
     * @return
     */

    @Select("select * from " + DEPT_TABLE)
    List<Dept> selectAll();

    /**
     * 动态查询用户分页记录
     *
     * @param params ①检索的条件；②分页参数
     * @return {@link List<Dept>}
     */
    @SelectProvider(type = DeptDynaSQLProvider.class,method = "selectWithParams")
    List<Dept> selectByPage(Map<String, Object> params);

    /**
     * 动态查询用户记录总数
     *
     * @param params ①检索的条件
     * @return
     */
    @SelectProvider(type = DeptDynaSQLProvider.class, method = "count")
    int count(Map<String, Object> params);

    /**
     * 动态更新用户
     *
     * @param dept
     */
    @UpdateProvider(type = DeptDynaSQLProvider.class, method = "updateDept")
    void update(Dept dept);

    /**
     * 动态插入用户
     *
     * @param dept
     */
    @InsertProvider(type = DeptDynaSQLProvider.class, method = "insertDept")
    void insert(Dept dept);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    @Delete("delete from " + DEPT_TABLE + " where id = #{id}")
    void deleteById(Integer id);

    /**
     * 根据id批量删除用户
     *
     * @param params
     */
    @DeleteProvider(type = DeptDynaSQLProvider.class, method = "batchDeleteDept")
    void batchDelete(Map<String, Object> params);

}
