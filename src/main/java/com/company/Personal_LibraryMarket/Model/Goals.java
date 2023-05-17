//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "goals")
public class Goals {

    @Id
    @Column(name = "goals_id")
    private Integer goalsId;
    private String language;
    @Column(name = "goals_name")
    private String goalsName;

    @Column(name = "goals_book_id")
    private Integer goals_bookId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = ("book_id"))
    private Book goalsBook;

}
