//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service;

import com.company.Personal_LibraryMarket.Dto.GoalsDto;
import com.company.Personal_LibraryMarket.Dto.ImageDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Model.Image;
import com.company.Personal_LibraryMarket.Repository.ImageRepository;
import com.company.Personal_LibraryMarket.Service.Mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public ResponseDto<ImageDto> createImage(ImageDto dto) {
        try {
            Image image = this.imageMapper.toEntity(dto);
            this.imageRepository.save(image);
            return ResponseDto.<ImageDto>builder()
                    .success(true)
                    .message("Image successful created and save in database")
                    .data(this.imageMapper.toDto(image))
                    .build();
        }catch (Exception i) {
            return ResponseDto.<ImageDto>builder()
                    .message("Image malumotlari database ga saqlanmadi!")
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<ImageDto> getImage(Integer imageId) {
        Optional<Image> optional = this.imageRepository.findByImageId(imageId);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .message("Image is not found!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<ImageDto>builder()
                .success(true)
                .message("Image malumotlari: ")
                .data(this.imageMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<ImageDto> updateImage(ImageDto dto, Integer imageId) {
        Optional<Image> optional = this.imageRepository.findByImageId(imageId);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .message("Image is not found!")
                    .code(-3)
                    .build();
        }
        Image image = this.imageMapper.toEntity(dto);
        image.setImageId(optional.get().getImageId());
        this.imageRepository.save(image);
        return ResponseDto.<ImageDto>builder()
                .success(true)
                .message("Image successful updated and save in database!")
                .data(this.imageMapper.toDto(image))
                .build();
    }

    public ResponseDto<ImageDto> deleteImage(Integer imageId) {
        Optional<Image> optional = this.imageRepository.findByImageId(imageId);
        if (optional.isEmpty()) {
            return ResponseDto.<ImageDto>builder()
                    .message("Image is not found!")
                    .code(-3)
                    .build();
        }
        this.imageRepository.delete(optional.get());
        return ResponseDto.<ImageDto>builder()
                .success(true)
                .message("Image malumotlari: ")
                .data(this.imageMapper.toDto(optional.get()))
                .build();
    }
}
