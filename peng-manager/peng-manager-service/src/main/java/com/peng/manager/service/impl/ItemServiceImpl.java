package com.peng.manager.service.impl;

import com.peng.manager.mapper.TbItemMapper;
import com.peng.manager.pojo.TbItem;
import com.peng.manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
