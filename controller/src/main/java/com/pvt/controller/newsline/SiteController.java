package com.pvt.controller.newsline;

import com.pvt.daoEntities.News;
import com.pvt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sasha
 * Date: 12.05.14
 * Time: 1:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SiteController {

    @Autowired
    protected ICategoryService categoryService;

    @Autowired
    protected INewsService newsService;

    @RequestMapping(value = "/site/", params = "operation=shownews")
    public String showContentHandler(@RequestParam("id") Integer id, Map<String, Object> model) {

        News news = newsService.getNewsById(id);
        model.put("news", news);
        return "content";

    }

    @RequestMapping(value = "/site/", params = "category")
    public String showNewsByCategoryHandler(@RequestParam("category") Integer id, Map<String, Object> model) {
        model.put("categories", categoryService.getCategoryList());
        model.put("newslist", newsService.getNewsByCategoryId(id));
        model.put("categoryid", id);
        return "index";
    }

    @RequestMapping(value = "/site/")
    public String showNewsHandler(Map<String, Object> model) {
        model.put("categories", categoryService.getCategoryList());
        return "index";
    }

    @RequestMapping(value = "/*")
    public String redirectOnSite() {
        return "redirect:/site/";
    }
}
