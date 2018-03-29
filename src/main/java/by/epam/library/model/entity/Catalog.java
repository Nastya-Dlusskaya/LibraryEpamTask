package by.epam.library.model.entity;

import java.util.ArrayList;

public class Catalog {
    private ArrayList catalog;

    public Catalog() {
        catalog = new ArrayList();
    }

    public void add(Book book){
        catalog.add(book);
    }

    public Book get(int index){
        return (Book)catalog.get(index);
    }

}
