//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.CardDto;
import com.company.Personal_LibraryMarket.Model.Card;
import com.company.Personal_LibraryMarket.Service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CardMapper {

    @Autowired
    protected UserService userService;

    @Autowired
    protected UserMapper userMapper;

    //target -> return type
    //source -> param

    @Mapping(target = "user", source = "users")
    public abstract Card toEntity(CardDto dto);

    @Mapping(target = "users", expression = "java(userMapper.toDtoNotCard(card.getUser()))")
    public abstract CardDto toDtoForGetMethod(Card card);

    @Mapping(target = "users", expression = "java(userMapper.toDtoNotCard(userMapper.toEntity(userService.getUser(card.getUserId()).getData())))")
    public abstract CardDto toDtoForPostMethod(Card card);

    public void viewMethod(){

    }
}
