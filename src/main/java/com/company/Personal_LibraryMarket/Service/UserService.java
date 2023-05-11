//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service;

import com.company.Personal_LibraryMarket.Dto.OrderDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Dto.UserDto;
import com.company.Personal_LibraryMarket.Model.Order;
import com.company.Personal_LibraryMarket.Model.User;
import com.company.Personal_LibraryMarket.Repository.UserRepository;
import com.company.Personal_LibraryMarket.Service.Mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public ResponseDto<UserDto> createUser(UserDto dto) {
        try {
            User user = this.userMapper.toEntity(dto);
            user.setCreatedAt(LocalDateTime.now());
            this.userRepository.save(user);
            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("User successful created and save in database")
                    .data(this.userMapper.toDto(user))
                    .build();
        }catch (Exception o) {
            return ResponseDto.<UserDto>builder()
                    .message("User not save database")
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<UserDto> getUser(Integer userId) {
        Optional<User> optional = this.userRepository.findByUserIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<UserDto>builder()
                .success(true)
                .message("User malumotlari: ")
                .data(this.userMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<UserDto> updateUser(UserDto dto, Integer userId) {
        Optional<User> optional = this.userRepository.findByUserIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .build();
        }
        User user = this.userMapper.toEntity(dto);
        user.setUserId(optional.get().getUserId());
        user.setCreatedAt(optional.get().getCreatedAt());
        user.setUpdatedAt(LocalDateTime.now());
        user.setDeletedAt(optional.get().getDeletedAt());
        this.userRepository.save(user);
        return ResponseDto.<UserDto>builder()
                .success(true)
                .message("User successful update and save in database!")
                .data(this.userMapper.toDto(user))
                .build();
    }

    public ResponseDto<UserDto> deleteUser(Integer userId) {
        Optional<User> optional = this.userRepository.findByUserIdAndDeletedAtIsNull(userId);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .build();
        }
        this.userRepository.save(optional.get());
        optional.get().setDeletedAt(LocalDateTime.now());
        return ResponseDto.<UserDto>builder()
                .success(true)
                .message("User malumotlari ochirildi")
                .data(this.userMapper.toDto(optional.get()))
                .build();
    }
}
