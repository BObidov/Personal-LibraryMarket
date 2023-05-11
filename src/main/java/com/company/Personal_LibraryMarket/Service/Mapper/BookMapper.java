//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.BookDto;
import com.company.Personal_LibraryMarket.Model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class BookMapper {


    //@Mapping(target = "bookId", ignore = true)
    public abstract Book toEntity(BookDto dto);

    public abstract BookDto toDto(Book book);


}
