package com.peng.manager.controller;

import com.peng.common.pojo.TreeNode;
import com.peng.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类管理 Controller
 * 
 * @author renyapeng
 * @date 2018/06/10
 */
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/item/cat/list")
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(name = "id", defaultValue = "0") long parentId) {
        List<TreeNode> list = itemCatService.getItemCatList(parentId);
        return list;
    }
}
