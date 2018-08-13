package com.peng.content.service;

import com.peng.common.pojo.E3Result;
import com.peng.common.pojo.TreeNode;

import java.util.List;

/**
 * 内容分类管理Service
 */
public interface ContentCatService {

    /**
     * 展示内容分类
     *
     * @author renyapeng
     * @date 2018/08/02
     */
    List<TreeNode> getContentCatList(long parentId);

    /**
     * 新增内容分类
     *
     * @author renyapeng
     * @date 2018/08/13
     */
    E3Result addContentCategory(long parentId, String name);
}