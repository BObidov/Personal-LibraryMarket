//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Controller;


import com.company.Personal_LibraryMarket.Dto.AuthorDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "authors")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping(value = "/create")
    public ResponseDto<AuthorDto> create(@RequestBody AuthorDto dto){
        return this.authorService.createAuthor(dto);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseDto<AuthorDto> get(@PathVariable (value = "id") Integer authorId){
        return this.authorService.getAuthor(authorId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<AuthorDto> update(@RequestBody AuthorDto dto,
                                         @PathVariable(value = "id") Integer authorId){
        return this.authorService.updateAuthor(dto, authorId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<AuthorDto> delete(@PathVariable(value = "id") Integer authorId){
        return this.authorService.deleteAuthor(authorId);
    }

}
