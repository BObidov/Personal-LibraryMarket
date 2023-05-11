//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Controller;

import com.company.Personal_LibraryMarket.Dto.GoalsDto;
import com.company.Personal_LibraryMarket.Dto.ImageDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "images")
public class ImageController {

    private final ImageService imageService;


    @PostMapping(value = "/create")
    public ResponseDto<ImageDto> create(@RequestBody ImageDto dto){
        return this.imageService.createImage(dto);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseDto<ImageDto> get(@PathVariable(value = "id") Integer imageId){
        return this.imageService.getImage(imageId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<ImageDto> update(@RequestBody ImageDto dto,
                                        @PathVariable(value = "id") Integer imageId){
        return this.imageService.updateImage(dto, imageId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<ImageDto> delete(@PathVariable(value = "id") Integer imageId){
        return this.imageService.deleteImage(imageId);
    }


}
