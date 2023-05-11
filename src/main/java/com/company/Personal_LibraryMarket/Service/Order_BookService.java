//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service;

import com.company.Personal_LibraryMarket.Dto.Order_BookDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Model.Order_Book;
import com.company.Personal_LibraryMarket.Repository.Order_BookRepository;
import com.company.Personal_LibraryMarket.Service.Mapper.Order_BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class Order_BookService {

    private final Order_BookRepository orderBookRepository;
    private final Order_BookMapper orderBookMapper;

    public ResponseDto<Order_BookDto> createOrderBook(Order_BookDto dto) {
        try {
            Order_Book orderBook = this.orderBookMapper.toEntity(dto);
            this.orderBookRepository.save(orderBook);
            return ResponseDto.<Order_BookDto>builder()
                    .success(true)
                    .message("OrderBook successful created and save in database!")
                    .data(this.orderBookMapper.toDto(orderBook))
                    .build();
        }catch (Exception ob) {
            return ResponseDto.<Order_BookDto>builder()
                    .message("OrderBook database saqlamadi!")
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<Order_BookDto> getOrderBook(Integer orderBookId) {
        Optional<Order_Book> optional = this.orderBookRepository.findByOrderBookId(orderBookId);
        if (optional.isEmpty()) {
            return ResponseDto.<Order_BookDto>builder()
                    .message("OrderBook is not found!!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<Order_BookDto>builder()
                .success(true)
                .message("OrderBook malumotlari: ")
                .data(this.orderBookMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<Order_BookDto> updateOrderBook(Order_BookDto dto, Integer orderBookId) {
        Optional<Order_Book> optional = this.orderBookRepository.findByOrderBookId(orderBookId);
        if (optional.isEmpty()) {
            return ResponseDto.<Order_BookDto>builder()
                    .message("OrderBook malumotlari mavjud emas!")
                    .code(-3)
                    .build();
        }
        Order_Book orderBook = this.orderBookMapper.toEntity(dto);
        orderBook.setOrderBookId(optional.get().getOrderBookId());
        this.orderBookRepository.save(orderBook);
        return ResponseDto.<Order_BookDto>builder()
                .success(true)
                .message("OrderBook malumotlari toliq yangilandi va database ga saqlandi.")
                .data(this.orderBookMapper.toDto(orderBook))
                .build();
    }

    public ResponseDto<Order_BookDto> deleteOrderBook(Integer orderBookId) {
        Optional<Order_Book> optional = this.orderBookRepository.findByOrderBookId(orderBookId);
        if (optional.isEmpty()) {
            return ResponseDto.<Order_BookDto>builder()
                    .message("OrderBook is not found!!")
                    .code(-3)
                    .build();
        }
        this.orderBookRepository.delete(optional.get());
        return ResponseDto.<Order_BookDto>builder()
                .success(true)
                .message("OrderBook malumotlari ochirildi")
                .data(this.orderBookMapper.toDto(optional.get()))
                .build();
    }
}
