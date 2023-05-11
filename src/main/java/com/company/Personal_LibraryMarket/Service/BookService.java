//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service;

import com.company.Personal_LibraryMarket.Dto.BookDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Model.Book;
import com.company.Personal_LibraryMarket.Repository.BookRepository;
import com.company.Personal_LibraryMarket.Service.Mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;


    public ResponseDto<BookDto> createBook(BookDto dto) {
        try {
            Book book = this.bookMapper.toEntity(dto);
            this.bookRepository.save(book);
            return ResponseDto.<BookDto>builder()
                    .success(true)
                    .message("Book successful created and save database")
                    .data(this.bookMapper.toDto(book))
                    .build();
        }catch (Exception b) {
            return ResponseDto.<BookDto>builder()
                    .message("Database ga mallumotlar saqlanmadi.")
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<BookDto> getBook(Integer bookId) {
        Optional<Book> optional = this.bookRepository.findByBookId(bookId);
        if (optional.isEmpty()){
            return ResponseDto.<BookDto>builder()
                    .message("Book is not found!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<BookDto>builder()
                .success(true)
                .message("Book malumotlari olib kelindi!")
                .data(this.bookMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<BookDto> updateBook(BookDto dto, Integer bookId) {
        Optional<Book> optional = this.bookRepository.findByBookId(bookId);
        if (optional.isEmpty()) {
            return ResponseDto.<BookDto>builder()
                    .message("Bu id ga tegishli malumotlar mavjud emas!")
                    .code(-3)
                    .build();
        }
        Book book = this.bookMapper.toEntity(dto);
        book.setBookId(optional.get().getBookId());
        this.bookRepository.save(book);
        return ResponseDto.<BookDto>builder()
                .success(true)
                .message("Book successful updated and save in database")
                .data(this.bookMapper.toDto(book))
                .build();
    }

    public ResponseDto<BookDto> deleteBook(Integer bookId) {
        Optional<Book> optional = this.bookRepository.findByBookId(bookId);
        if (optional.isEmpty()) {
            return ResponseDto.<BookDto>builder()
                    .message("Ochirladigan malumotlar topilmadi.")
                    .code(-3)
                    .build();
        }
        this.bookRepository.delete(optional.get());
        return ResponseDto.<BookDto>builder()
                .success(true)
                .message("Book malumotlari ochirildi!")
                .data(this.bookMapper.toDto(optional.get()))
                .build();
    }

}
