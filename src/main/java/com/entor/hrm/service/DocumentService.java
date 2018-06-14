package com.entor.hrm.service;


import com.entor.hrm.po.Document;
import com.entor.hrm.service.impl.PageModel;

import java.util.List;

public interface DocumentService {

    /**
     * 根据id查询通知
     *
     * @param id
     * @return
     */
    Document getById(Integer id);

    /**
     * 分页查询通知
     *
     * @param document
     * @param pageIndex
     * @param pageSize
     * @return {@link List<Document>}
     */
    PageModel<Document> getByPage(Document document, Integer pageIndex, Integer pageSize);

    /**
     * 根据id删除通知
     *
     * @param id
     */
    void removeById(Integer id);

    /**
     * 修改通知
     *
     * @param document
     */
    void modifyDocument(Document document);

    /**
     * 添加通知
     *
     * @param document
     */
    void save(Document document);

    /**
     * 根据id批量移除通知
     *
     * @param ids
     */
    void batchRemoveDocument(Integer[] ids);
}
