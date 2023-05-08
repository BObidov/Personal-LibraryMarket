//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = ("goals"))
public class Goals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("goals_id"))
    private Integer goalsId;
    private String language;
    @Column(name = ("goals_name"))
    private String goalsName;

    @Column(name = ("goals_book_id"))
    private Integer goals_bookId;
    @ManyToOne
    @JoinColumn(name = ("goals_book_id"), insertable = false, updatable = false)
    private Book goalsBook;

}
