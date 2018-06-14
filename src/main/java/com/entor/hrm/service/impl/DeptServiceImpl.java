package com.entor.hrm.service.impl;

import com.entor.hrm.mapper.DeptMapper;
import com.entor.hrm.po.Dept;
import com.entor.hrm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.transaction.annotation.Isolation.DEFAULT;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service("deptSerivce")
@Transactional(propagation = REQUIRED, isolation = DEFAULT, readOnly = false)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Transactional(readOnly = true)
    @Override
    public Dept getById(Integer id) {
       return deptMapper.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dept> getAll() {
        return deptMapper.selectAll();
    }

    @Transactional(readOnly = true)
    @Override
    public PageModel<Dept> getByPage(Dept dept, Integer pageIndex, Integer pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("dept", dept);
        // 根据检索条件查询记录总数
        int recordCount = deptMapper.count(params);
        // 整理分页参数
        PageModel<Dept> pageModel = new PageModel<>();
        pageModel.setPageIndex(pageIndex);
        pageModel.setPageSize(pageSize);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            // 根据检索和分页条件查询用户记录，保存到分页对象中
            params.put("pageModel", pageModel);
            pageModel.setPageList(deptMapper.selectByPage(params));
        }
        return pageModel;
    }

    @Override
    public void modifyUser(Dept dept) {
        deptMapper.update(dept);
    }

    @Override
    public void save(Dept dept) {
        deptMapper.insert(dept);
    }

    @Override
    public void removeById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void batchRemoveDept(Integer[] ids) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        deptMapper.batchDelete(params);
    }

}
