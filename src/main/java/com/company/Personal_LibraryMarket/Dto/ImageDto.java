//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;


import com.company.Personal_LibraryMarket.Model.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {

    private Integer imageId;
    private Integer size;
    private String path;
    private String type;
    private String token;
    private Integer image_bookId;
    private Book imageBooks;
}
