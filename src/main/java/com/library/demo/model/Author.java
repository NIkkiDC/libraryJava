package com.library.demo.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;

    @OneToMany(mappedBy = "author", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Book> bookList;


    public Author(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Author() {
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}






    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public List<Book> getBookList() {return bookList;}

    public void setBookList(List<Book> bookList) {this.bookList = bookList;}
}