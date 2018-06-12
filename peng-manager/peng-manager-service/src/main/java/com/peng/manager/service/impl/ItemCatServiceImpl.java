package com.peng.manager.service.impl;

import com.peng.common.pojo.TreeNode;
import com.peng.manager.mapper.TbItemCatMapper;
import com.peng.manager.pojo.TbItemCat;
import com.peng.manager.pojo.TbItemCatExample;
import com.peng.manager.pojo.TbItemCatExample.Criteria;
import com.peng.manager.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理 Service
 *
 * @author renyapeng
 * @date 2018/06/10
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    /**
     * 商品分类选择
     *
     * @param parentId
     * @author renyapeng
     * @date 2018/06/10
     */
    @Override
    public List<TreeNode> getItemCatList(long parentId) {
        // 1) 根据 parentId 查询子节点列表
        // 创建一个查询条件
        TbItemCatExample example = new TbItemCatExample();
        Criteria criteria = example.createCriteria();
        // 设置查询条件
        criteria.andParentIdEqualTo(parentId);
        // 执行查询
        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        // 2) 把 TbItemCat 的 list 转换成 TreeNode 的列表
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(tbItemCat.getId());
            treeNode.setText(tbItemCat.getName());
            treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
            // 把节点添加到 list
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }
}
