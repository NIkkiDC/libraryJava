package com.library.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="books")
    public class Book {
        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String name;
        @Column
        private String description;
        @Column
        private String isbn;

        @JsonIgnore
        @ManyToOne //many books to one author
        @JoinColumn(name = "Author id")
        private Author author;



        public Book(Long id, String name, String description, String isbn) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.isbn = isbn;
        }

        public Book(){

        }

        public Long getId() {return id;}

        public void setId(Long id) {this.id = id;}

        public String getName() {return name;}

        public void setName(String name) {this.name = name;}

        public String getDescription() {return description;}

        public void setDescription(String description) {this.description = description;}

        public String getIsbn() {return isbn;}

        public void setIsbn(String isbn) {this.isbn = isbn;}



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}



