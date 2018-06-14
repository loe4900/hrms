package com.entor.hrm.mapper;

import com.entor.hrm.mapper.provider.NoticeDynaSQLProvider;
import com.entor.hrm.po.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.entor.hrm.util.common.HrmConstants.NOTICE_TABLE;
import static org.apache.ibatis.mapping.FetchType.EAGER;

public interface NoticeMapper {

    /**
     * 动态查询通知
     *
     * @param params
     * @return {@link List<Notice>}
     */
    @SelectProvider(type = NoticeDynaSQLProvider.class, method = "selectWithParams")
    @Results({
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", javaType = com.entor.hrm.po.User.class,
                    one = @One(select = "com.entor.hrm.mapper.UserMapper.selectById", fetchType = EAGER))
    })
    List<Notice> selectByPage(Map<String, Object> params);

    /**
     * 动态查询通知总记录数
     *
     * @param params
     * @return {@link Integer}
     */
    @SelectProvider(type = NoticeDynaSQLProvider.class, method = "count")
    Integer count(Map<String, Object> params);

    /**
     * 查询所有用户
     *
     * @return {@link List<Notice>}
     */
    @Select("select * from " + NOTICE_TABLE + " ")
    @Results({
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", javaType = com.entor.hrm.po.User.class,
                    one = @One(select = "com.entor.hrm.mapper.UserMapper.selectById", fetchType = EAGER))
    })
    List<Notice> getAllNotice();

    /**
     * 根据id查询通知
     *
     * @param id
     * @return {@link Notice}
     */
    @Select("select * from " + NOTICE_TABLE + " where id = #{id} ")
    @Results({
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", javaType = com.entor.hrm.po.User.class,
                    one = @One(select = "com.entor.hrm.mapper.UserMapper.selectById", fetchType = EAGER))
    })
    Notice selectById(Integer id);

    /**
     * 获取最新通知
     */
    @Results({
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", javaType = com.entor.hrm.po.User.class,
                    one = @One(select = "com.entor.hrm.mapper.UserMapper.selectById", fetchType = EAGER))
    })
    @Select("select * from " + NOTICE_TABLE + " order by create_date desc limit 0,1")
    Notice selectNewest();

    /**
     * 获取近期通知（近期最多五条记录）
     */
    @Results({
            @Result(column = "create_date", property = "createDate", javaType = java.util.Date.class),
            @Result(column = "user_id", property = "user", javaType = com.entor.hrm.po.User.class,
                    one = @One(select = "com.entor.hrm.mapper.UserMapper.selectById", fetchType = EAGER))
    })
    @Select("select * from " + NOTICE_TABLE + " order by create_date desc limit 0,5")
    List<Notice> selectRecent();

    /**
     * 根据id删除通知
     *
     * @param id
     */
    @Delete("delete from " + NOTICE_TABLE + " where id = #{id} ")
    void deleteById(Integer id);

    /**
     * 动态插入用户
     *
     * @param Notice
     */
    @SelectProvider(type = NoticeDynaSQLProvider.class, method = "insertNotice")
    void save(Notice Notice);

    /**
     * 动态修改用户
     *
     * @param Notice
     */
    @SelectProvider(type = NoticeDynaSQLProvider.class, method = "updateNotice")
    void update(Notice Notice);

    /**
     * 根据id批量删除通知
     *
     * @param params
     */
    @DeleteProvider(type = NoticeDynaSQLProvider.class, method = "batchDeleteNotice")
    void batchDelete(Map<String, Object> params);
}
