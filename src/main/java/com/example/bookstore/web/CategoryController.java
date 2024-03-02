package com.example.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.model.CategoryRepository;
import com.example.bookstore.model.Category;

@Controller
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Show categories
    @RequestMapping(value = "/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist";
    }

    // Add new category
    @RequestMapping(value = "/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    // Save category
    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:categorylist";
    }

     // Delete category
    @RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("id") Long categoryid, Model model) {
        categoryRepository.deleteById(categoryid);
        return "redirect:../categorylist";
    }

    // Edit category
    @RequestMapping(value = "/editcategory/{id}", method = RequestMethod.GET)
    public String editCategory(@PathVariable("id") Long categoryid, Model model) {
        model.addAttribute("category", categoryRepository.findById(categoryid));
        return "editcategory";
    }



}

