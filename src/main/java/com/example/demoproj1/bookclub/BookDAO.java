package com.example.demoproj1.bookclub;


import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<Book> getAllBooks(){

        List<Book> bookList = new ArrayList<>();
        Book b1 = new Book();
        b1.setId(1);
        b1.setTitle("Jayne Eyre");
        b1.setAuthor("Charlotte Bronte");

        Book b2 = new Book();
        b2.setId(2);
        b2.setTitle( "Wuthering Heights");
        b2.setAuthor("Emily Bronte");

        Book b3 = new Book();
        b3.setId(3);
        b3.setTitle( "Crime and Punishment");
        b3.setAuthor("Fjodor Dostovjevsky");

        Book b4 = new Book();
        b4.setId(4);
        b4.setTitle("Madame Bovary");
        b4.setAuthor("Gustave Flaubert");

        Book b5 = new Book();
        b5.setId(5);
        b5.setTitle("Catcher in the Rye");
        b5.setAuthor("J.D. Salinger");

        Book b6 = new Book();
        b6.setId(6);
        b6.setTitle("Sandman, vol 1");
        b6.setAuthor("Neil Gaiman");

        Book b7 = new Book();
        b7.setId(7);
        b7.setTitle("Pale King");
        b7.setAuthor("David Foster Wallace");


        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
        bookList.add(b4);
        bookList.add(b5);
        bookList.add(b6);
        bookList.add(b7);

        return bookList;
    }

}
