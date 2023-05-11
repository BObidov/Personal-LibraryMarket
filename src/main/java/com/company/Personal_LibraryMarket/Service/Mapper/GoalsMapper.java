//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.GoalsDto;
import com.company.Personal_LibraryMarket.Model.Goals;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class GoalsMapper {
    public abstract Goals toEntity(GoalsDto dto);

    public abstract GoalsDto toDto(Goals goals);
}
