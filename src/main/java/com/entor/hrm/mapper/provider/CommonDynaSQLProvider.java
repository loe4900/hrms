package com.entor.hrm.mapper.provider;

import java.util.Map;

/**
 * 通用SQL构建器
 */
public class CommonDynaSQLProvider {

    /**
     * 批量删除
     *
     * @param table
     * @param params
     * @return
     */
    public static String batchDelete(String table, Map<String, Object> params) {
        System.out.println("调用公共批量删除！！");
        StringBuffer sqlBuffer = new StringBuffer("delete from ");
        sqlBuffer.append(table).append(" where id in (");
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

    /**
     * 批量查找记录
     *
     * @param table
     * @param params
     * @return
     */
    public static String selectByIds(String table, Map<String, Object> params) {
        System.out.println("调用公共批量查找");
        StringBuffer sqlBuffer = new StringBuffer("select * from ");
        sqlBuffer.append(table).append(" where id in (");
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
