//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.AuthorDto;
import com.company.Personal_LibraryMarket.Model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AuthorMapper {

    @Mapping(target = "authorBook", source = "authorBooks")
    public abstract Author toEntity(AuthorDto dto);


    @Mapping(target = "authorBooks", source = "authorBook")
    public abstract AuthorDto toDto(Author author);
}