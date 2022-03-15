package com.example.demoproj1.bookclub;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;



@RestController
public class BookController {

    BookDAO bookDaoDB = new BookDAO();
    List<Book> bookList = bookDaoDB.getAllBooks();

    @RequestMapping("/books")
    public List<Book> index() {
        return bookList;
    }

    @RequestMapping("/book")
    public Book oneBook() {
        Book b = new Book();
        b.setId(7);
        b.setTitle("Pale King");
        b.setAuthor("David Foster Wallace");
        return b;
    }



    @RequestMapping("/booksHTML")
    public String getBooksHTML(){
        String res = "<HTML><HEAD><TITLE>Books</TITLE></HEAD><BODY><TABLE>";
        for (Book b : bookList){
            res += "<TR><TD>"+b.getId()+"</TD><TD>"+b.getAuthor()+"</TD><TD>"+b.getTitle()+"</TD></TR>";
        }
        res += "</TABLE></HTML>";
        return res;
    }

    @RequestMapping("/book/{id}")
    public Book getBookById(@PathVariable int id){
        Book res = new Book();
        for (Book b : bookList){
            if (b.getId() == id){
                res = b;
            }
        }
        return res;
    }

    @RequestMapping("/booksBetween/{idFrom}/{idTo}")
    public List<Book> getBooksBetween(@PathVariable int idFrom, @PathVariable int idTo){
        List<Book> res = new ArrayList();
        for (Book b : bookList){
            int id = b.getId();
            if (id >= idFrom && id <= idTo){
                res.add(b);
            }
        }
        return res;
    }

    @RequestMapping("/book/{id}/delete")
    public Response deleteBookById(@PathVariable("id") int id){
        Response res = new Response("Book deleted", Boolean.FALSE);

        int indexToRemove = -1;
        for (int i = 0; i < bookList.size(); i++){
            if (bookList.get(i).getId() == id){
                indexToRemove = i;
            }
        }

        if (indexToRemove != -1){
            bookList.remove(indexToRemove);
            res.setStatus(Boolean.TRUE);
        }

        return res;
    }


    @PostMapping("/book/add")
    public Response addBook(@RequestBody Book b){
        System.out.println(b.getId()+" "+b.getAuthor()+" "+b.getTitle());
        Response res = new Response("Book added", Boolean.FALSE);
        bookList.add(b);
        res.setStatus(Boolean.TRUE);
        return res;
    }

    @PostMapping("/book/update")
    public Response upsertBook(@RequestBody Book b){
        Response res = new Response("Book updated", Boolean.FALSE);

        int indexToUpdate = -1;
        for (int i = 0; i < bookList.size(); i++){
            if (bookList.get(i).getId() == b.getId()){
                indexToUpdate = i;
            }
        }

        if (indexToUpdate == -1){
            bookList.add(b);
            res.setMessage("Book inserted");
            res.setStatus(Boolean.TRUE);
        }
        else{
            bookList.set(indexToUpdate, b);
            res.setStatus(Boolean.TRUE);
        }
        return res;
    }

}
