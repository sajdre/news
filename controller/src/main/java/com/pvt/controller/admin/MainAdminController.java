package com.pvt.controller.admin;

import com.pvt.daoEntities.Category;
import com.pvt.daoEntities.News;
import com.pvt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class MainAdminController {

    @Autowired
    protected ICategoryService categoryService;

    @Autowired
    protected INewsService newsService;

	@RequestMapping(value = "/admin/")
	public String showCommand(Map<String, Object> model) {
		List<Category> list;
		list = categoryService.getCategoryList();
        Iterator<Category> itList = list.iterator();
        while(itList.hasNext()){
            Category cat = itList.next();
            List<News> news = newsService.getNewsByCategoryId(cat.getId());
            cat.setNews(news);
        }
		model.put("categories", list);
		return "mainadmin";
	}
}
