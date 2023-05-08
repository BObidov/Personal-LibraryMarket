//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;

import com.company.Personal_LibraryMarket.Model.Order_Book;
import com.company.Personal_LibraryMarket.Model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class OrderDto {

    private Integer orderId;
    private Integer total;
    private String description;
    private Integer userId;
    private User users;
    private Integer order_booksId;
    private Order_Book orderBooks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
