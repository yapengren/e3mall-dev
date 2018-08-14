package com.peng.portal.controller;

import com.peng.content.service.ContentService;
import com.peng.manager.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 首页处理Controller
 * 
 * @author renyapeng
 * @date 2018/07/29
 */
@Controller
public class IndexController {

    @Autowired
    private ContentService contentService;

    @Value("${index.ad1.cid}")
    private Long indexAd1Cid;

    @RequestMapping("/index")
    public String showIndex(Model model) {
        // 查询内容列表
        List<TbContent> ad1List = contentService.getContentList(indexAd1Cid);
        // 把数据传递给jsp
        model.addAttribute("ad1List", ad1List);
        // 返回逻辑视图
        return "index";
    }
}
