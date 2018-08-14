package com.peng.content.service;

import com.peng.common.pojo.DataGridResult;
import com.peng.common.pojo.E3Result;
import com.peng.manager.pojo.TbContent;

import java.util.List;

/**
 * 内容管理Service
 */
public interface ContentService {

    /**
     * 展示内容列表
     *
     * @author renyapeng
     * @date 2018/08/13
     */
    DataGridResult getContentListDataGrid(long categoryId, int page, int rows);

    /**
     * 新增内容信息
     *
     * @author renyapeng
     * @date 2018/08/14
     */
    E3Result addContent(TbContent tbContent);

    /**
     * 展示大广告位
     *
     * @author renyapeng
     * @date 2018/08/14
     */
    List<TbContent> getContentList(long cid);
}
