package com.peng.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peng.common.pojo.DataGridResult;
import com.peng.common.pojo.E3Result;
import com.peng.common.utils.IDUtils;
import com.peng.manager.mapper.TbItemDescMapper;
import com.peng.manager.mapper.TbItemMapper;
import com.peng.manager.pojo.TbItem;
import com.peng.manager.pojo.TbItemDesc;
import com.peng.manager.pojo.TbItemExample;
import com.peng.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品管理 ServiceImpl
 *
 * @author renyapeng
 * @date 2018/05/06
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;

    /**
     * 根据商品 id 查询商品信息
     *
     * @author renyapeng
     * @date 2018/04/23
     */
    @Override
    public TbItem getItemById(Long id) {
        TbItem item = itemMapper.selectByPrimaryKey(id);
        return item;
    }

    /**
     * 分页查询所有商品列表
     *
     * @author renyapeng
     * @date 2018/05/12
     */
    @Override
    public DataGridResult getItemListDataGrid(int page, int rows) {
        // 设置分页信息
        PageHelper.startPage(page, rows);
        // 执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        // 从查询结果中取分页结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        // 把 total、list 封装到 DataGridResult 对象中
        DataGridResult result = new DataGridResult();
        result.setTotal(total);
        result.setRows(list);
        // 返回结果
        return result;
    }

    @Override
    public E3Result addItem(TbItem item, String desc) {
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        // 商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        itemMapper.insert(item);
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDescMapper.insert(itemDesc);
        return E3Result.ok();
    }
}
