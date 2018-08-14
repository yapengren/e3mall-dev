package com.peng.manager.controller;

import com.peng.common.pojo.DataGridResult;
import com.peng.common.pojo.E3Result;
import com.peng.content.service.ContentService;
import com.peng.manager.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理Controller
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 展示内容列表
     * 
     * @author renyapeng
     * @date 2018/08/13
     */
    @RequestMapping(value = "/content/query/list")
    @ResponseBody
    public DataGridResult getContentList(long categoryId, int page, int rows) {
        DataGridResult gridResult = contentService.getContentListDataGrid(categoryId, page, rows);
        return gridResult;
    }

    /**
     * 新增内容信息
     *
     * @author renyapeng
     * @date 2018/08/14
     */
    @RequestMapping(value = "/content/save", method = RequestMethod.POST)
    @ResponseBody
    public E3Result addContent(TbContent content) {
        E3Result result = contentService.addContent(content);
        return result;
    }
}
