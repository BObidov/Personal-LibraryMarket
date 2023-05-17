//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "author_id")
    private Integer authorId;
    private String name;
    private String surname;
    private Integer age;

    private Integer bookId;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "author")
    private Book authorBook;

}
