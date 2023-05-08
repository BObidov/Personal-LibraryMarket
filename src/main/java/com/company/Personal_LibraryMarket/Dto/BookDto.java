//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;

import com.company.Personal_LibraryMarket.Model.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class BookDto {

    private Integer bookId;
    private String bookName;
    private Integer bookPrice;
    private LocalDateTime bookPublished;
    private Integer bookPage;
    private Integer bookAmount;
    private Integer authorId;
    private Author authors;
    private Integer imageId;
    private Image images;
    private Integer goalsId;
    private Goals goals;
    private Integer publisherId;
    private Publisher publishers;
    private Integer order_bookId;
    private Order_Book orderBooks;

}
