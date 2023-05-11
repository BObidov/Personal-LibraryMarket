package com.company.Personal_LibraryMarket.Service;

import com.company.Personal_LibraryMarket.Dto.PublisherDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Model.Publisher;
import com.company.Personal_LibraryMarket.Repository.PublisherRepository;
import com.company.Personal_LibraryMarket.Service.Mapper.PublisherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherService {


    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public ResponseDto<PublisherDto> createPublisher(PublisherDto dto) {
        try {
            Publisher publisher = this.publisherMapper.toEntity(dto);
            this.publisherRepository.save(publisher);
            return ResponseDto.<PublisherDto>builder()
                    .success(true)
                    .message("Publisher successful created and save in database")
                    .data(this.publisherMapper.toDto(publisher))
                    .build();
        }catch (Exception p) {
            return ResponseDto.<PublisherDto>builder()
                    .message("Publisher not save in database!")
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<PublisherDto> getPublisher(Integer publisherId) {
        Optional<Publisher> optional = this.publisherRepository.findByPublisherId(publisherId);
        if (optional.isEmpty()) {
            return ResponseDto.<PublisherDto>builder()
                    .message("Publisher is not found!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<PublisherDto>builder()
                .success(true)
                .message("Publisher malumotlari: ")
                .data(this.publisherMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<PublisherDto> updatePublisher(PublisherDto dto, Integer publisherId) {
        Optional<Publisher> optional = this.publisherRepository.findByPublisherId(publisherId);
        if (optional.isEmpty()) {
            return ResponseDto.<PublisherDto>builder()
                    .message("Publisher is not found!")
                    .code(-3)
                    .build();
        }
        Publisher publisher = this.publisherMapper.toEntity(dto);
        publisher.setPublisherId(optional.get().getPublisherId());
        this.publisherRepository.save(publisher);
        return ResponseDto.<PublisherDto>builder()
                .success(true)
                .message("publisher malumotlaari yangilanib database ga saqlandi.")
                .data(this.publisherMapper.toDto(publisher))
                .build();
    }

    public ResponseDto<PublisherDto> deletePublisher(Integer publisherId) {
        Optional<Publisher> optional = this.publisherRepository.findByPublisherId(publisherId);
        if (optional.isEmpty()) {
            return ResponseDto.<PublisherDto>builder()
                    .message("Publisher is not found!")
                    .code(-3)
                    .build();
        }
        this.publisherRepository.delete(optional.get());
        return ResponseDto.<PublisherDto>builder()
                .success(true)
                .message("Publisher malumotlari ochirildi!")
                .data(this.publisherMapper.toDto(optional.get()))
                .build();
    }
}
