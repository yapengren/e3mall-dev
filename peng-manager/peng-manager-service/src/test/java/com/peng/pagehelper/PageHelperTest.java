package com.peng.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.peng.manager.mapper.TbItemMapper;
import com.peng.manager.pojo.TbItem;
import com.peng.manager.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * pageHelper 测试类
 *
 * @author renyapeng
 * @date 2018/05/12
 */
public class PageHelperTest {

    /**
     * pageHelper 测试类
     */
    @Test
    public void pageHelperTest() {
        // 初始化 META-INF.META-INF.spring 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF.spring/applicationContext-dao.xml");
        // 从容器中获取 Mapper 代理对象
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
        // 设置分页信息
        // pageNum:当前页 pageSize:每页显示个数
        PageHelper.startPage(1, 30);
        // 执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        // 取分页结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        System.out.println("总记录数    " + pageInfo.getTotal());
        System.out.println("总页数     " + pageInfo.getPages());
        System.out.println("当前页     " + pageInfo.getPageNum());
        System.out.println("每页显示条数 " + pageInfo.getPageSize());
    }
}
