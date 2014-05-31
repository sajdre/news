package com.pvt.controller.admin;

import com.pvt.daoEntities.Category;
import com.pvt.daoEntities.News;
import com.pvt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    protected ICategoryService categoryService;

    @Autowired
    protected INewsService newsService;

	@RequestMapping(value = "/admin/", params = "operation=addcategory")
	public String addCategoryCommand() {
        return "addcategory";
	}

    @RequestMapping(value = "/admin/", params = "operation=addwritecategory")
    public String addWriteCategory(@RequestParam("category") String category) {
        categoryService.saveCategory(category);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/", params = "operation=editcategory")
    public String editCategory(@RequestParam("id") Integer id, Map<String, Object> model) {
        Category cat;
        cat = categoryService.getCategoryById(id);
        model.put("category", cat);
        return "editcategory";
    }

    @RequestMapping(value = "/admin/", params = "operation=deletecategory")
    public String deleteCategory(@RequestParam("id") Integer id) {

        categoryService.deleteCategory(id);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/", params = "operation=editwritecategory")
    public String editWriteCategory(@RequestParam("id") Integer categoryId, @RequestParam("category") String categoryName) {

        Category cat = new Category();
        cat.setId(categoryId);
        cat.setCategory(categoryName);
        categoryService.updateCategory(cat);
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/admin/", params = "operation=showonlythiscategory")
    public String showOnlyThisCategory(@RequestParam("id") Integer id, Map<String,Object> model) {
        // TODO Auto-generated method stub
        List<Category> list = new ArrayList<Category>();
        list.add(categoryService.getCategoryById(id));
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
