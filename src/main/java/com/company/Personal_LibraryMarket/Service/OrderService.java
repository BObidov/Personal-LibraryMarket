//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service;

import com.company.Personal_LibraryMarket.Dto.OrderDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Model.Order;
import com.company.Personal_LibraryMarket.Repository.OrderRepository;
import com.company.Personal_LibraryMarket.Service.Mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {


    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public ResponseDto<OrderDto> createOrder(OrderDto dto) {
        try {
            Order order = this.orderMapper.toEntity(dto);
            order.setCreatedAt(LocalDateTime.now());
            this.orderRepository.save(order);
            return ResponseDto.<OrderDto>builder()
                    .success(true)
                    .message("Order successful created and save in database")
                    .data(this.orderMapper.toDto(order))
                    .build();
        }catch (Exception o) {
            return ResponseDto.<OrderDto>builder()
                    .message("Order not save database")
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<OrderDto> getOrder(Integer orderId) {
        Optional<Order> optional = this.orderRepository.findByOrderIdAndDeletedAtIsNull(orderId);
        if (optional.isEmpty()) {
            return ResponseDto.<OrderDto>builder()
                    .message("Order is not found!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<OrderDto>builder()
                .success(true)
                .message("Order malumotlari: ")
                .data(this.orderMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<OrderDto> updateOrder(OrderDto dto, Integer orderId) {
        Optional<Order> optional = this.orderRepository.findByOrderIdAndDeletedAtIsNull(orderId);
        if (optional.isEmpty()) {
            return ResponseDto.<OrderDto>builder()
                    .message("Order is not found!")
                    .code(-3)
                    .build();
        }
        Order order = this.orderMapper.toEntity(dto);
        order.setOrderId(optional.get().getOrderId());
        order.setCreatedAt(optional.get().getCreatedAt());
        order.setUpdatedAt(LocalDateTime.now());
        order.setDeletedAt(optional.get().getDeletedAt());
        this.orderRepository.save(order);
        return ResponseDto.<OrderDto>builder()
                .success(true)
                .message("Order malumotlari yangilandi va database ga saqlandi.")
                .data(this.orderMapper.toDto(order))
                .build();
    }

    public ResponseDto<OrderDto> deleteOrder(Integer orderId) {
        Optional<Order> optional = this.orderRepository.findByOrderIdAndDeletedAtIsNull(orderId);
        if (optional.isEmpty()) {
            return ResponseDto.<OrderDto>builder()
                    .message("Order is not found!")
                    .code(-3)
                    .build();
        }
        this.orderRepository.delete(optional.get());
        optional.get().setDeletedAt(LocalDateTime.now());
        return ResponseDto.<OrderDto>builder()
                .success(true)
                .message("Order malumotlari ochirildi!")
                .data(this.orderMapper.toDto(optional.get()))
                .build();
    }


}
