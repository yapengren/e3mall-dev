package com.peng.content.service.impl;

import com.peng.common.pojo.E3Result;
import com.peng.common.pojo.TreeNode;
import com.peng.content.service.ContentCatService;
import com.peng.manager.mapper.TbContentCategoryMapper;
import com.peng.manager.pojo.TbContentCategory;
import com.peng.manager.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.peng.manager.pojo.TbContentCategoryExample.Criteria;

import java.util.ArrayList;
import java.util.Date;
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

    /**
     * 新增内容分类
     *
     * @author renyapeng
     * @date 2018/08/13
     */
    @Override
    public E3Result addContentCategory(long parentId, String name) {
        // 1）创建一个TbContentCategory对象
        TbContentCategory contentCategory = new TbContentCategory();
        // 2）设置对象的属性
        contentCategory.setParentId(parentId);
        contentCategory.setName(name);
        // 状态。可选值:1(正常),2(删除)
        contentCategory.setStatus(1);
        // 排列序号
        contentCategory.setSortOrder(1);
        // 新增节点一定是叶子节点
        contentCategory.setIsParent(false);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        // 3）把数据插入到数据库中
        contentCategoryMapper.insert(contentCategory);
        // 4）取父节点的信息
        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
        // 5）判断父节点的 isParent 属性是否是true，如果不是应该改为 true
        if (!parent.getIsParent()) {
            parent.setIsParent(true);
            // 更新到数据库
            contentCategoryMapper.updateByPrimaryKey(parent);
        }
        // 6）返回 E3Result 其中包含 TbContentCategory 对象
        return E3Result.ok(contentCategory);
    }

    /**
     * 修改内容分类
     *
     * @author renyapeng
     * @date 2018/08/13
     */
    @Override
    public E3Result updateContentCategory(long id, String name) {
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setId(id);
        contentCategory.setName(name);
        contentCategory.setUpdated(new Date());
        contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
        return E3Result.ok(contentCategory);
    }
}
