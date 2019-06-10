package net.codejava.repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.codejava.model.Book;

@Api(value="API REST Livro")
@RestController
@RequestMapping("/livro")
@CrossOrigin(origins="*")
public class BookResource {

	@Autowired
	private BookRepository er;
	
	@ApiOperation(value="Lista todos os livros cadastrados: URL: http://localhost:8080/livro/list")
	@GetMapping(value = "/list",  produces="application/json")
	public @ResponseBody  String listaEventos(){
		System.out.println("DENTRO DO METODO");
		Gson g = new Gson();
		List<Book> list = er.findAll();
		Type listType = new TypeToken<ArrayList<Book>>() {}.getType();
		String data = g.toJson(list, listType);
		
		System.out.println("*****************DADOS: " + data);
		return data;
	}
	
	@PostMapping()
	@ApiOperation(value="Salva um nobo livros: URL: http://localhost:8080/livro/save")
	@RequestMapping(value = "/save" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	public String save(@RequestBody  String bookJson){
		
		Gson g = new Gson();
		System.out.println("2 - DENTRO DO METODO cadastraEvento: " + bookJson);
		Book newBook = g.fromJson(bookJson, Book.class);
		
		try {
		er.save(newBook); 
		}catch (Exception e) {
			e.printStackTrace();
			return "It is not no possible. Try again.";
		}
		long codigo = newBook.getId(); 
		System.out.println("3 - DENTRO DO METODO cadastraEvento: " + codigo);
		return "redirect:/list";
	}
	
	@ApiOperation(value="Salva a imagem de um livro: URL: http://localhost:8080/livro/upload")
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestParam(required = true, value = "file") MultipartFile file, 
                         @RequestParam(required = true, value = "jsondata") String jsondata) throws IOException {
		
		System.out.println("***************DENTRO DO METODO UPLOAD****************");
        File convertFile = new File("c://mydownloads//"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        
    }
	
	
	@DeleteMapping()
	@ApiOperation(value="Remove um livros: URL: http://localhost:8080/livro/delete")
	@RequestMapping(value = "/delete" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(@RequestBody String  bookJson){
		Gson g = new Gson();
		System.out.println("2 - DENTRO DO METODO cadastraEvento: " + bookJson);
		Book book = g.fromJson(bookJson, Book.class);
		book = er.findById(book.getId());
		er.delete(book);
		return "{\"return\":\"sucesso\"}";
	}
	
	@PostMapping()
	@ApiOperation(value="Atualiza um livros: URL: http://localhost:8080/livro/update")
	@RequestMapping(value = "/update" ,  produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(@RequestBody String  bookJson){
		Gson g = new Gson();
		System.out.println("2 - DENTRO DO METODO cadastraEvento: " + bookJson);
		Book book = g.fromJson(bookJson, Book.class);
		er.save(book);
		return "{\"return\":\"sucesso\"}";
	}

}
