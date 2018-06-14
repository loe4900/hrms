package com.entor.hrm.service.impl;

import com.entor.hrm.mapper.JobMapper;
import com.entor.hrm.po.Job;
import com.entor.hrm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.transaction.annotation.Isolation.DEFAULT;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Service("jobSerivce")
@Transactional(propagation = REQUIRED, isolation = DEFAULT, readOnly = false)
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Job getById(Integer id) {
        return jobMapper.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Job> getAll() {
        return jobMapper.selectAll();
    }

    @Transactional(readOnly = true)
    @Override
    public PageModel<Job> getByPage(Job job, Integer pageIndex, Integer pageSize) {
        // 1.整理参数
        Map<String, Object> params = new HashMap<>();
        params.put("job", job);
        // 根据检索条件查询记录总数
        int recordCount = jobMapper.count(params);
        // 整理分页参数
        PageModel<Job> pageModel = new PageModel<>();
        pageModel.setPageIndex(pageIndex);
        pageModel.setPageSize(pageSize);
        pageModel.setRecordCount(recordCount);
        if (recordCount > 0) {
            // 根据检索和分页条件查询用户记录，保存到分页对象中
            params.put("pageModel", pageModel);
            pageModel.setPageList(jobMapper.selectByPage(params));
        }
        return pageModel;
    }


    @Override
    public void modifyJob(Job job) {
        jobMapper.update(job);
    }

    @Override
    public void save(Job job) {
        jobMapper.insert(job);
    }

    @Override
    public void removeById(Integer id) {
        jobMapper.deleteById(id);
    }

    @Override
    public void batchRemoveJob(Integer[] ids) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        jobMapper.batchDelete(params);
    }
}
