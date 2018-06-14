package com.entor.hrm.mapper.provider;

import com.entor.hrm.po.Job;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

import static com.entor.hrm.util.common.HrmConstants.JOB_TABLE;

/**
 * 用户表SQL构建器
 */
public class JobDynaSQLProvider {

    /**
     * 动态分页查询用户记录
     *
     * @param params
     * @return
     */
    public String selectWithParams(Map<String, Object> params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM(JOB_TABLE);

            // 1.处理检索条件
            if (params.get("job") != null) {
                Job job = (Job) params.get("job");
                if (!StringUtils.isEmpty(job.getName())) {
                    WHERE("name like concat('%',  #{job.name},'%')");
                }
                if (!StringUtils.isEmpty(job.getRemark())){
                    WHERE("remark like concat('%',  #{dept.remark},'%')");
                }
            }
        }}.toString();

        // 2.处理分页参数
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize}";
        }
        return sql;
    }

    /**
     * 动态分页查询用户总记录数
     *
     * @param params
     * @return
     */
    public String count(Map<String, Object> params) {
        String sql = new SQL() {{
            SELECT("count(*)");
            FROM(JOB_TABLE);

            // 1.处理检索条件
            if (params.get("job") != null) {
                Job job = (Job) params.get("job");
                if (!StringUtils.isEmpty(job.getName())) {
                    WHERE("name like concat('%', #{job.name},'%')");
                }
                if (!StringUtils.isEmpty(job.getRemark())){
                    WHERE("remark like concat('%',  #{dept.remark},'%')");
                }
            }
        }}.toString();
        return sql;
    }

    /**
     * 动态更新用户
     *
     * @param job
     * @return
     */
    public String updatejob(Job job) {
        return new SQL() {{
            UPDATE(JOB_TABLE);
            if (!StringUtils.isEmpty(job.getName())) {
                SET("name = #{name}");
            }
            if (!StringUtils.isEmpty(job.getRemark())){
                SET("remark = #{remark}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }

    /**
     * 动态插入用户
     *
     * @param job
     * @return
     */
    public String insertjob(Job job) {
        return new SQL() {{
            INSERT_INTO(JOB_TABLE);
            if (!StringUtils.isEmpty(job.getName())) {
                VALUES("name", "#{name}");
            }
            if (!StringUtils.isEmpty(job.getRemark())) {
                VALUES("remark", "#{remark}");
            }
        }}.toString();
    }

    /**
     * 根据id批量删除用户
     *
     * @param params
     * @return
     */
    public String batchDeletejob(Map<String, Object> params) {
        StringBuffer sqlBuffer = new StringBuffer("delete from ");
        sqlBuffer.append(JOB_TABLE).append(" where id in (");
        if (params.get("ids") != null) {
            Integer[] ids = (Integer[]) params.get("ids");
            if (ids.length > 0) {
                for (Integer id : ids) {
                    sqlBuffer.append(id).append(",");
                }
            } else {
                // 数组中不存在id
                sqlBuffer.append("null");
            }
        } else {
            // params中不存在id
            sqlBuffer.append("null");
        }
        sqlBuffer.append(")");
        return sqlBuffer.toString().replace(",)", ")");
    }
}
