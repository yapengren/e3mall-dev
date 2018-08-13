package com.peng.manager.controller;

import com.peng.common.pojo.TreeNode;
import com.peng.content.service.ContentCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类管理Controller
 *
 * @author renyapeng
 * @date 2018/08/03
 */
@Controller
public class ContentCatController {

    @Autowired
    private ContentCatService contentCatService;

    @RequestMapping(value = "/content/category/list")
    @ResponseBody
    public List<TreeNode> getContentCatList(@RequestParam(name = "id", defaultValue = "0") long parentId) {
        List<TreeNode> list = contentCatService.getContentCatList(parentId);
        return list;
    }
}
