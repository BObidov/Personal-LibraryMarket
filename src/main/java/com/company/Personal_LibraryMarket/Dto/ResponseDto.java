//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto<T> {

    private boolean success;

    private String message;
    /*
     * 0  - it is ok
     * -1 - database error
     *-2  - validation error
     *-3  - not found
     * */

    private int code;

    private T data;
}
