//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.ImageDto;
import com.company.Personal_LibraryMarket.Model.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ImageMapper {
    public abstract Image toEntity(ImageDto dto);

    public abstract ImageDto toDto(Image image);
}
