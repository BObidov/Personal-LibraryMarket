//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Controller;

import com.company.Personal_LibraryMarket.Dto.Order_BookDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Service.Order_BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "order_books")
public class Order_BookController {

    private final Order_BookService orderBookService;


    @PostMapping(value = "/create")
    public ResponseDto<Order_BookDto> create(@RequestBody Order_BookDto dto){
        return this.orderBookService.createOrderBook(dto);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseDto<Order_BookDto> get(@PathVariable(value = "id") Integer orderBookId){
        return this.orderBookService.getOrderBook(orderBookId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<Order_BookDto> update(@RequestBody Order_BookDto dto,
                                        @PathVariable(value = "id") Integer orderBookId){
        return this.orderBookService.updateOrderBook(dto, orderBookId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<Order_BookDto> delete(@PathVariable(value = "id") Integer orderBookId){
        return this.orderBookService.deleteOrderBook(orderBookId);
    }

}
