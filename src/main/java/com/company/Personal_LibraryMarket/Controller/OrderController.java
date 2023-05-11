//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Controller;

import com.company.Personal_LibraryMarket.Dto.OrderDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "orders")
public class OrderController {

    private final OrderService orderService;


    @PostMapping(value = "/create")
    public ResponseDto<OrderDto> create(@RequestBody OrderDto dto){
        return this.orderService.createOrder(dto);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseDto<OrderDto> get(@PathVariable(value = "id") Integer orderId){
        return this.orderService.getOrder(orderId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<OrderDto> update(@RequestBody OrderDto dto,
                                        @PathVariable(value = "id") Integer orderId){
        return this.orderService.updateOrder(dto, orderId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<OrderDto> delete(@PathVariable(value = "id") Integer orderId){
        return this.orderService.deleteOrder(orderId);
    }
}
