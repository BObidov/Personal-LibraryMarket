//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.CardDto;
import com.company.Personal_LibraryMarket.Model.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CardMapper {
    public abstract Card toEntity(CardDto dto);

    public abstract CardDto toDto(Card card);
}
