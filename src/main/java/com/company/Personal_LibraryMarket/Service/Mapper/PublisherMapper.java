//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.PublisherDto;
import com.company.Personal_LibraryMarket.Model.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PublisherMapper {
    public abstract Publisher toEntity(PublisherDto dto);

    public abstract PublisherDto toDto(Publisher publisher);
}
