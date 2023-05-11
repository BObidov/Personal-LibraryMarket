//Allohim ilmimni ziyida qilgin!!

package com.company.Personal_LibraryMarket.Controller;

import com.company.Personal_LibraryMarket.Dto.PublisherDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "publishers")
public class PublisherController {

    private  final PublisherService publisherService;


    @PostMapping(value = "/create")
    public ResponseDto<PublisherDto> create(@RequestBody PublisherDto dto){
        return this.publisherService.createPublisher(dto);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseDto<PublisherDto> get(@PathVariable(value = "id") Integer publisherId){
        return this.publisherService.getPublisher(publisherId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<PublisherDto> update(@RequestBody PublisherDto dto,
                                            @PathVariable(value = "id") Integer publisherId){
        return this.publisherService.updatePublisher(dto, publisherId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<PublisherDto> delete(@PathVariable(value = "id") Integer publisherId){
        return this.publisherService.deletePublisher(publisherId);
    }

}
