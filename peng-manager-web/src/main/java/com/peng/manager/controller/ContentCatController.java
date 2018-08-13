package com.peng.manager.controller;

import com.peng.common.pojo.E3Result;
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

    /**
     * 展示内容分类
     *
     * @author renyapeng
     * @date 2018/08/13
     */
    @RequestMapping(value = "/content/category/list")
    @ResponseBody
    public List<TreeNode> getContentCatList(@RequestParam(name = "id", defaultValue = "0") long parentId) {
        List<TreeNode> list = contentCatService.getContentCatList(parentId);
        return list;
    }

    /**
     * 新增内容分类
     *
     * @author renyapeng
     * @date 2018/08/13
     */
    @RequestMapping(value = "/content/category/create")
    @ResponseBody
    public E3Result addContentCategory(long parentId, String name) {
        E3Result e3Result = contentCatService.addContentCategory(parentId, name);
        return e3Result;
    }

    /**
     * 修改内容分类
     *
     * @author renyapeng
     * @date 2018/08/13
     */
    @RequestMapping(value = "/content/category/update")
    @ResponseBody
    public E3Result updateContentCategory(long id, String name) {
        E3Result e3Result = contentCatService.updateContentCategory(id, name);
        return e3Result;
    }
}
