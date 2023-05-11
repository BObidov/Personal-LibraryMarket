//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;

import com.company.Personal_LibraryMarket.Model.Book;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class PublisherDto {

    private Integer publisherId;
    private LocalDateTime publisher;
    private String location;
    private Integer publisherBookId;
    private Book publisherBooks;

}
