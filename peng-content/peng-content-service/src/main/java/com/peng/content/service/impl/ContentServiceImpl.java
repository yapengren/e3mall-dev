package com.peng.content.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peng.common.pojo.DataGridResult;
import com.peng.common.pojo.E3Result;
import com.peng.content.service.ContentService;
import com.peng.manager.mapper.TbContentMapper;
import com.peng.manager.pojo.TbContent;
import com.peng.manager.pojo.TbContentExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.peng.manager.pojo.TbContentExample.Criteria;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 内容管理Service
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;
    
    /**
     * 展示内容列表
     * 
     * @author renyapeng
     * @date 2018/08/13
     */
    @Override
    public DataGridResult getContentListDataGrid(long categoryId, int page, int rows) {
        // 1）创建一个查询条件，设置查询条件，根据内容分类id查询
        TbContentExample example = new TbContentExample();
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        // 2）设置分页条件，使用 PageHelper
        PageHelper.startPage(page, rows);
        // 3）执行查询
        List<TbContent> list = contentMapper.selectByExample(example);
        // 4）从查询结果中取分页信息
        PageInfo<TbContent> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        // 5）创建一个 DataGridResult 对象
        DataGridResult result = new DataGridResult();
        // 6）设置属性
        result.setTotal(total);
        result.setRows(list);
        // 7）返回结果
        return result;
    }

    /**
     * 新增内容信息
     *
     * @author renyapeng
     * @date 2018/08/14
     */
    @Override
    public E3Result addContent(TbContent content) {
        // 1）补全 pojo 对象的属性
        content.setCreated(new Date());
        content.setUpdated(new Date());
        // 2）插入数据
        contentMapper.insert(content);
        // 3）返回成功
        return E3Result.ok();
    }
}
