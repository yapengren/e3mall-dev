package com.peng.manager.controller;

import com.peng.common.pojo.DataGridResult;
import com.peng.manager.pojo.TbItem;
import com.peng.manager.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品管理 Controller
 *
 * @author renyapeng
 * @date 2018/05/06
 */
@Controller
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    /**
     * 商品管理 Service
     *
     * @author renyapeng
     * @date 2018/05/14
     */
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}")
    @ResponseBody
    private TbItem getItemById(@PathVariable Long itemId) {
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }

    /**
     * 商品列表查询
     *
     * @author renyapeng
     * @date 2018/05/14
     */
    @RequestMapping(value = "/item/list")
    @ResponseBody
    public DataGridResult getItemList(int page, int rows) {
        DataGridResult result = itemService.getItemListDataGrid(page, rows);
        return result;
    }
}
