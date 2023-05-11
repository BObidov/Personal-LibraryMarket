//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Controller;

import com.company.Personal_LibraryMarket.Dto.BookDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "books")
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/create")
    public ResponseDto<BookDto> create(@RequestBody BookDto dto){
        return this.bookService.createBook(dto);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseDto<BookDto> get(@PathVariable(value = "id") Integer bookId){
        return this.bookService.getBook(bookId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<BookDto> update(@RequestBody BookDto dto,
                                       @PathVariable(value = "id") Integer bookId){
        return this.bookService.updateBook(dto, bookId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<BookDto> delete(@PathVariable(value = "id") Integer bookId){
        return this.bookService.deleteBook(bookId);
    }


}
