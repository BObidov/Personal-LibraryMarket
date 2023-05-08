//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;


import com.company.Personal_LibraryMarket.Model.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GoalsDto {

    private Integer goalsId;
    private String language;
    private String goalsName;
    private Integer goals_bookId;
    private Book goalsBook;

}
