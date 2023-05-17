//Alllohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;

import com.company.Personal_LibraryMarket.Model.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter

public class UserDto {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Integer cardId;
    private Set<CardDto> cards;
    private Integer orderId;
    private Set<Order> orders;
    private String gender;
    private Integer price;
    private LocalDateTime birthdate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
