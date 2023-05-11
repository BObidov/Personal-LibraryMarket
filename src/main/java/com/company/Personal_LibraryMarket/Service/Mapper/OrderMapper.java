//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.OrderDto;
import com.company.Personal_LibraryMarket.Model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    public abstract Order toEntity(OrderDto dto);

    public abstract OrderDto toDto(Order order);
}
