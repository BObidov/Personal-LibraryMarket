//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service;

import com.company.Personal_LibraryMarket.Dto.AuthorDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Model.Author;
import com.company.Personal_LibraryMarket.Repository.AuthorRepository;
import com.company.Personal_LibraryMarket.Service.Mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public ResponseDto<AuthorDto> createAuthor(AuthorDto dto) {
        try {
            Author author = authorMapper.toEntity(dto);
            this.authorRepository.save(author);
            return ResponseDto.<AuthorDto>builder()
                    .success(true)
                    .message("Author successful created")
                    .data(this.authorMapper.toDto(author))
                    .build();
        }catch (Exception a){
            return ResponseDto.<AuthorDto>builder()
                    .message("Database ga malumotlar saqlanmadi.")
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<AuthorDto> getAuthor(Integer authorId) {
        Optional<Author> optional = this.authorRepository.findByAuthorId(authorId);
        if (optional.isEmpty()){
            return ResponseDto.<AuthorDto>builder()
                    .message("Malummotlar topilmadi!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<AuthorDto>builder()
                .success(true)
                .message("Author malumotlari topildi.")
                .data(this.authorMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<AuthorDto> updateAuthor(AuthorDto dto, Integer authorId) {
        Optional<Author> optional = this.authorRepository.findByAuthorId(authorId);
        if (optional.isEmpty()){
            return ResponseDto.<AuthorDto>builder()
                    .message("Author malumotlari topa olmadi")
                    .code(-2)
                    .build();
        }
        Author author = this.authorMapper.toEntity(dto);
        author.setAuthorId(optional.get().getAuthorId());
        this.authorRepository.save(author);
        return ResponseDto.<AuthorDto>builder()
                .success(true)
                .message("Author malumotlari toliq yangilandi!")
                .data(this.authorMapper.toDto(author))
                .build();
    }

    public ResponseDto<AuthorDto> deleteAuthor(Integer authorId) {
        Optional<Author> optional = this.authorRepository.findByAuthorId(authorId);
        if (optional.isEmpty()){
            return ResponseDto.<AuthorDto>builder()
                    .message("Malummotlar topilmadi!")
                    .code(-3)
                    .build();
        }
        this.authorRepository.delete(optional.get());
        return ResponseDto.<AuthorDto>builder()
                .success(true)
                .message("Author malumotlari topildi.")
                .data(this.authorMapper.toDto(optional.get()))
                .build();
    }


}
