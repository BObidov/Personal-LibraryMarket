//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service;

import com.company.Personal_LibraryMarket.Dto.CardDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Model.Card;
import com.company.Personal_LibraryMarket.Repository.CardRepository;
import com.company.Personal_LibraryMarket.Service.Mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {

    private final CardRepository cardRepository;

    private final CardMapper cardMapper;

    public ResponseDto<CardDto> createCard(CardDto dto) {
        try {
            Card card = this.cardMapper.toEntity(dto);
            card.setCreatedAt(LocalDateTime.now());
            this.cardRepository.save(card);
            return ResponseDto.<CardDto>builder()
                    .success(true)
                    .message("Card successful created and save in database")
                    .data(this.cardMapper.toDto(card))
                    .build();
        }catch (Exception c){
            return ResponseDto.<CardDto>builder()
                    .message("Card not save in Database")
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<CardDto> getCard(Integer cardId) {
        Optional<Card> optional = this.cardRepository.findByCardIdAndDeletedAtIsNull(cardId);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .message("Card is not found!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<CardDto>builder()
                .success(true)
                .message("Card maulomotlari database dan olib kelindi.")
                .data(this.cardMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<CardDto> updateCard(CardDto dto, Integer cardId) {
        Optional<Card> optional = this.cardRepository.findByCardIdAndDeletedAtIsNull(cardId);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .message("Card is not found!!")
                    .code(-3)
                    .build();
        }
        Card card = this.cardMapper.toEntity(dto);
        card.setCardId(optional.get().getCardId());
        card.setCreatedAt(optional.get().getCreatedAt());
        card.setUpdatedAt(LocalDateTime.now());
        card.setDeletedAt(optional.get().getDeletedAt());
        this.cardRepository.save(card);
        return ResponseDto.<CardDto>builder()
                .success(true)
                .message("Card successful updated and save in database!")
                .data(this.cardMapper.toDto(card))
                .build();

    }

    public ResponseDto<CardDto> deleteCard(Integer cardId) {
        Optional<Card> optional = this.cardRepository.findByCardIdAndDeletedAtIsNull(cardId);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .message("Card is not found!")
                    .code(-3)
                    .build();
        }
        this.cardRepository.delete(optional.get());
        optional.get().setDeletedAt(LocalDateTime.now());
        return ResponseDto.<CardDto>builder()
                .success(true)
                .message("Card malumotlari topildi va ochirildi!")
                .data(this.cardMapper.toDto(optional.get()))
                .build();

    }
}
