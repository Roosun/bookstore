package com.example.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class BookController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndex(Model model) {
	    System.out.println("Index endpoint");
		return "index";
	}
}
