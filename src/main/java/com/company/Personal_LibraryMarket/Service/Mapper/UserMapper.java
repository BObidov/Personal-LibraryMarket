//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;


import com.company.Personal_LibraryMarket.Dto.UserDto;
import com.company.Personal_LibraryMarket.Model.User;
import com.company.Personal_LibraryMarket.Service.CardService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Lazy
    @Autowired
    protected CardMapper cardMapper;

    @Lazy
    @Autowired
    protected CardService cardService;

    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "cards", ignore = true)
    public abstract User toEntity(UserDto dto);


    public abstract UserDto toDto(User user);

    @Mapping(target = "cards", ignore = true)
    public abstract UserDto toDtoNotCard(User user);

    @Mapping(target = "orders", ignore = true)
    public abstract User toDtoNotOrder(User user);
}
