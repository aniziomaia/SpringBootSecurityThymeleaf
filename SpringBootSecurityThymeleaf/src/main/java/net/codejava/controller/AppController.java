package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.codejava.model.Book;
import net.codejava.repository.BookRepository;


@Controller
public class AppController {

//	@Autowired
//	private ProductService service; 
//	
	@Autowired
	private BookRepository er;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		System.out.println("*******DENTRO DO CONTROLER QUE LISTA OS LIVROS");
		
		List<Book> bookList = er.findAll();
		model.addAttribute("bookList", bookList);
		
		return "list_book";
	}
	
	@RequestMapping("/new")
	public String newBook(Model model) {
		System.out.println("==================AppController.showNewProductPage:  new===================");
		
		return "save_book";
	}
//	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String saveProduct(@ModelAttribute("product") Product product) {
//		service.save(product);
//		System.out.println("........product.name: " + product.getName());
//		System.out.println("==================AppController.saveProduct: map save===================");
//		
//		return "redirect:/";
//	}
//	
//	@RequestMapping("/edit/{id}")
//	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
//		ModelAndView mav = new ModelAndView("edit_product");
//		Product product = service.get(id);
//		mav.addObject("product", product);
//		
//		return mav;
//	}
//	
//	@RequestMapping("/delete/{id}")
//	public String deleteProduct(@PathVariable(name = "id") int id) {
//		service.delete(id);
//		return "redirect:/";		
//	}
}
