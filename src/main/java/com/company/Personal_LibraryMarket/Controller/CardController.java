//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Controller;

import com.company.Personal_LibraryMarket.Dto.CardDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "cards")
public class CardController {

    private final CardService cardService;

    @PostMapping(value = "/create")
    public ResponseDto<CardDto> create(@RequestBody CardDto dto){
        return this.cardService.createCard(dto);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseDto<CardDto> get(@PathVariable(value = "id") Integer cardId){
        return this.cardService.getCard(cardId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<CardDto> update(@RequestBody CardDto dto,
                                       @PathVariable(value = "id") Integer cardId){
        return this.cardService.updateCard(dto, cardId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<CardDto> delete(@PathVariable(value = "id") Integer cardId){
        return this.cardService.deleteCard(cardId);
    }
}
