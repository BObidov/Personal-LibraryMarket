//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;

import com.company.Personal_LibraryMarket.Model.Book;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class AuthorDto {

    private Integer authorId;
    private String Name;
    private String Surname;
    private Integer age;
    private Integer authorBooksId;
    private Book authorBooks;

}
