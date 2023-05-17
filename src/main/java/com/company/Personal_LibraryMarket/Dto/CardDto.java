//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class CardDto {

    private Integer cardId;
    private String cardName;
    private String cardNumber;
    private Integer userId;
    private UserDto users;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
