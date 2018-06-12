package com.peng.manager.service;

import com.peng.common.pojo.TreeNode;

import java.util.List;

/**
 * 商品分类管理 Service
 *
 * @author renyapeng
 * @date 2018/06/10
 */
public interface ItemCatService {

    /**
     * 商品分类选择
     *
     * @author renyapeng
     * @date 2018/06/10
     */
    List<TreeNode> getItemCatList(long parentId);
}
