package com.pvt.admin;

import com.pvt.daoEntities.News;
import com.pvt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class NewsController {

    @Autowired
    protected INewsService newsService;

    @RequestMapping(value = "/admin/", params = "operation=addnews")
	public String addNews(@RequestParam("categoryid") Integer categoryId, Map<String, Object> model) {

		model.put("categoryId", categoryId);
        return "addnews";
	}

    @RequestMapping(value = "/admin/", params = "operation=addwritenews")
    public String addWriteNews(@RequestParam("categoryid") Integer categoryid ,@RequestParam("author") String author, @RequestParam("title") String title,
                               @RequestParam("annotation") String annotation, @RequestParam("content") String content) {

        News news = new News();

        Date today;
        String dateOut;
        DateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat("yyyy.MM.dd");
        today = new Date();
        dateOut = dateFormatter.format(today);
        news.setCreationdate(dateOut);

        news.setCategory_id(categoryid);
        news.setAuthor(author);
        news.setTitle(title);
        news.setAnnotation(annotation);
        news.setContent(content);

        newsService.save(news);

        return "redirect:/site/?category="+categoryid;

    }

    @RequestMapping(value = "/admin/", params = "operation=editnews")
    public String editNews(@RequestParam("id") Integer newsId, Map<String, Object> model) {
        // TODO Auto-generated method stub
        model.put("news", newsService.getNewsById(newsId));
        return "editnews";
    }

    @RequestMapping(value = "/admin/", params = "operation=editwritenews")
    public String editWriteNews(@RequestParam("creationdate") String creationdate, @RequestParam("categoryid") Integer categoryid ,@RequestParam("author") String author, @RequestParam("title") String title,
                              @RequestParam("annotation") String annotation, @RequestParam("content") String content, @RequestParam("id") Integer newsId) {
        // TODO Auto-generated method stub

        News news = new News();

        news.setAnnotation(annotation);
        news.setAuthor(author);
        news.setCategory_id(categoryid);
        news.setCreationdate(creationdate);
        news.setTitle(title);
        news.setContent(content);
        news.setId(newsId);

        newsService.updateNews(news);

        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/", params = "operation=deletenews")
    public String deleteNews(@RequestParam("id") Integer newsId) {

        newsService.deleteNews(newsId);
        return "redirect:/admin/";
    }

}
