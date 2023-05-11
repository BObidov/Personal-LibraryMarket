//Alllohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;

import com.company.Personal_LibraryMarket.Model.Card;
import com.company.Personal_LibraryMarket.Model.Gender;
import com.company.Personal_LibraryMarket.Model.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter

public class UserDto {

    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String phoneNumber;
    private Gender genders;
    private Integer cardId;
    private Set<Card> cards;
    private Integer user_orderId;
    private Set<Order> userOrders;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
