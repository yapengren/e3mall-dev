package com.peng.content.service.impl;

import com.peng.common.pojo.TreeNode;
import com.peng.content.service.ContentCatService;
import com.peng.manager.mapper.TbContentCategoryMapper;
import com.peng.manager.pojo.TbContentCategory;
import com.peng.manager.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.peng.manager.pojo.TbContentCategoryExample.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容分类管理Service
 */
@Service
public class ContentCatServiceImpl implements ContentCatService {

    /**
     *
     */
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    /**
     * 展示内容分类
     *
     * @author renyapeng
     * @date 2018/08/02
     */
    @Override
    public List<TreeNode> getContentCatList(long parentId) {
        // 1）创建一个查询条件，根据parentId查询子节点列表
        TbContentCategoryExample example = new TbContentCategoryExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        // 2）执行查询
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        // 3）把ContentCategoryList转换成TreeNode的列表
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            TreeNode node = new TreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            // 如果节点下有子节点应该是"closed"
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            // 添加到节点列表
            treeNodes.add(node);
        }
        // 4）返回TreeNode列表
        return treeNodes;
    }
}
