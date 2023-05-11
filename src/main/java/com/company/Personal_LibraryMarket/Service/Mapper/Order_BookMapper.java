//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.Order_BookDto;
import com.company.Personal_LibraryMarket.Model.Order_Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class Order_BookMapper {
    public abstract Order_Book toEntity(Order_BookDto dto);

    public abstract Order_BookDto toDto(Order_Book orderBook);
}
