//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;


import com.company.Personal_LibraryMarket.Model.Book;
import com.company.Personal_LibraryMarket.Model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Order_BookDto {

    private Integer order_bookId;
    private Integer orderId;
    private Order orders;
    private Integer bookId;
    private Book books;

}
