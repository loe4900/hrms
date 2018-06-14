package com.entor.hrm.mapper;

import com.entor.hrm.mapper.provider.DocumentDynaSQLProvider;
import com.entor.hrm.po.Document;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.entor.hrm.util.common.HrmConstants.DOCUMENT_TABLE;
import static org.apache.ibatis.mapping.FetchType.EAGER;

public interface DocumentMapper {

    /**
     * 动态查询文档
     *
     * @param params
     * @return {@link List<Document>}
     */
    @SelectProvider(type = DocumentDynaSQLProvider.class, method = "selectWithParams")
    @Results({
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", javaType = com.entor.hrm.po.User.class,
                    one = @One(select = "com.entor.hrm.mapper.UserMapper.selectById", fetchType = EAGER))
    })
    List<Document> selectByPage(Map<String, Object> params);

    /**
     * 动态查询文档总记录数
     *
     * @param params
     * @return {@link Integer}
     */
    @SelectProvider(type = DocumentDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    /**
     * 查询所有文档
     *
     * @return {@link List<Document>}
     */
    @Select("select * from " + DOCUMENT_TABLE)
    @Results({
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", javaType = com.entor.hrm.po.User.class,
                    one = @One(select = "com.entor.hrm.mapper.UserMapper.selectById", fetchType = EAGER))
    })
    List<Document> selectAll();

    /**
     * 根据id查询文档
     *
     * @param id
     * @return {@link Document}
     */
    @Select("select * from " + DOCUMENT_TABLE + " where id = #{id} ")
    @Results({
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", javaType = com.entor.hrm.po.User.class,
                    one = @One(select = "com.entor.hrm.mapper.UserMapper.selectById", fetchType = EAGER))
    })
    Document selectById(Integer id);

    /**
     * 根据id结合查询多条记录
     *
     * @param params
     * @return {@link List<Document>}
     */
    @SelectProvider(type = DocumentDynaSQLProvider.class, method = "selectByIds")
    List<Document> selectByIds(Map<String, Object> params);

    /**
     * 根据id删除文档
     *
     * @param id
     */
    @Delete("delete from " + DOCUMENT_TABLE + " where id = #{id} ")
    void deleteById(Integer id);

    /**
     * 动态插入文档
     *
     * @param Document
     */
    @InsertProvider(type = DocumentDynaSQLProvider.class, method = "insertDocument")
    void save(Document Document);

    /**
     * 动态修改文档
     *
     * @param Document
     */
    @UpdateProvider(type = DocumentDynaSQLProvider.class, method = "updateDocument")
    void update(Document Document);

    /**
     * 根据id批量删除文档
     *
     * @param params
     */
    @DeleteProvider(type = DocumentDynaSQLProvider.class, method = "batchDeleteDocument")
    void batchDelete(Map<String, Object> params);
}
