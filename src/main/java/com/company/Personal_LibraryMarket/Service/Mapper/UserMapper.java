//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;


import com.company.Personal_LibraryMarket.Dto.UserDto;
import com.company.Personal_LibraryMarket.Model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract User toEntity(UserDto dto);

    public abstract UserDto toDto(User user);
}
