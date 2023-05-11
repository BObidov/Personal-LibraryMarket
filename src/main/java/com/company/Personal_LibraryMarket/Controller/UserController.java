//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Controller;

import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Dto.UserDto;
import com.company.Personal_LibraryMarket.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class UserController{

    private final UserService userService;

    @PostMapping(value = "/create")
    public ResponseDto<UserDto> create(@RequestBody UserDto dto){
        return this.userService.createUser(dto);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseDto<UserDto> get(@PathVariable(value = "id") Integer userId){
        return this.userService.getUser(userId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<UserDto> update(@RequestBody UserDto dto,
                                       @PathVariable(value = "id") Integer userId){
        return this.userService.updateUser(dto, userId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<UserDto> delete(@PathVariable(value = "id") Integer userId){
        return this.userService.deleteUser(userId);
    }

}
