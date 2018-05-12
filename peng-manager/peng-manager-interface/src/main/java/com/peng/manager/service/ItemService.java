package com.peng.manager.service;

import com.peng.manager.pojo.TbItem;

/**
 * 商品管理 Service
 *
 * @author renyapeng
 * @date 2018/04/23
 */
public interface ItemService {

    TbItem getItemById(Long itemId);
}
