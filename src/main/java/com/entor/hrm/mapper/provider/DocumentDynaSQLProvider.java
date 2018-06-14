package com.entor.hrm.mapper.provider;

import com.entor.hrm.po.Document;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

import static com.entor.hrm.util.common.HrmConstants.DOCUMENT_TABLE;

public class DocumentDynaSQLProvider {
    /**
     * 分页动态查询文档
     *
     * @param params
     * @return
     */
    public String selectWithParams(Map<String, Object> params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM(DOCUMENT_TABLE);
            if (params.get("document") != null) {
                Document document = (Document) params.get("document");
                if (!StringUtils.isEmpty(document.getTitle())) {
                    WHERE(" title like concat ('%',#{document.title},'%') ");
                }
            }
        }}.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
        }
        return sql;
    }

    /**
     * 动态查询文档总记录数
     *
     * @param params
     * @return
     */
    public String count(Map<String, Object> params) {
        String sql = new SQL() {{
            SELECT("count(*)");
            FROM(DOCUMENT_TABLE);
            if (params.get("document") != null) {
                Document document = (Document) params.get("document");
                if (!StringUtils.isEmpty(document.getTitle())) {
                    WHERE(" title like concat ('%',#{document.title},'%') ");
                }
            }
        }}.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam}, #{pageModel.pageSize} ";
        }
        return sql;
    }

    /**
     * 动态插入文档
     *
     * @param document
     * @return
     */
    public String insertDocument(Document document) {
        return new SQL() {{
            INSERT_INTO(DOCUMENT_TABLE);
            if (!StringUtils.isEmpty(document.getTitle())) {
                VALUES("title", "#{title}");
            }
            if (!StringUtils.isEmpty(document.getFilename())) {
                VALUES("filename", "#{filename}");
            }
            if (!StringUtils.isEmpty(document.getRemark())) {
                VALUES("remark", "#{remark}");
            }
            if (document.getUser() != null && document.getUser().getId() != null) {
                VALUES("user_id", "#{user.id}");
            }
        }}.toString();
    }

    /**
     * 动态插入文档
     *
     * @param document
     * @return
     */
    public String updateDocument(Document document) {
        return new SQL() {{
            UPDATE(DOCUMENT_TABLE);
            if (!StringUtils.isEmpty(document.getTitle())) {
                SET("title = #{title}");
            }
            if (!StringUtils.isEmpty(document.getFilename())) {
                SET("filename=#{filename}");
            }
            if (!StringUtils.isEmpty(document.getRemark())) {
                SET("remark=#{remark}");
            }
            if (document.getUser() != null && document.getUser().getId() != null) {
                SET("user_id=#{user.id}");
            }
            WHERE(" id=#{id} ");
        }}.toString();
    }

    /**
     * 根据id批量删除通知
     *
     * @param params
     * @return
     */
    public String batchDeleteDocument(Map<String, Object> params) {
        return CommonDynaSQLProvider.batchDelete(DOCUMENT_TABLE, params);
    }

    /**
     * 根据id集合查询多条记录
     *
     * @param params
     * @return
     */
    public String selectByIds(Map<String, Object> params) {
        return CommonDynaSQLProvider.selectByIds(DOCUMENT_TABLE, params);
    }
}
