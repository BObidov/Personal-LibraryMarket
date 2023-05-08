//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = ("authors"))
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("author_id"))
    private Integer authorId;
    private String Name;
    private String Surname;
    private Integer age;

    @Column(name = ("author_book_id"))
    private Integer author_bookId;
    @OneToOne(mappedBy = "author")
    private Book authorBook;

}
