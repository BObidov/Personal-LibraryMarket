//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service;

import com.company.Personal_LibraryMarket.Dto.GoalsDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Model.Goals;
import com.company.Personal_LibraryMarket.Repository.GoalsRepository;
import com.company.Personal_LibraryMarket.Service.Mapper.GoalsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoalsService {


    private final GoalsRepository goalsRepository;

    private final GoalsMapper goalsMapper;

    public ResponseDto<GoalsDto> createGoals(GoalsDto dto) {
        try {
            Goals goals = this.goalsMapper.toEntity(dto);
            this.goalsRepository.save(goals);
            return ResponseDto.<GoalsDto>builder()
                    .success(true)
                    .message("goals successful created and save in database")
                    .data(this.goalsMapper.toDto(goals))
                    .build();
        } catch (Exception g){
            return ResponseDto.<GoalsDto>builder()
                    .message("Database ga malumotlar saqlanmadi!")
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<GoalsDto> getGoals(Integer goalsId) {
        Optional<Goals> optional = this.goalsRepository.findByGoalsId(goalsId);
        if (optional.isEmpty()) {
            return ResponseDto.<GoalsDto>builder()
                    .message("Goals is not found!")
                    .code(-3)
                    .build();
        }
        return ResponseDto.<GoalsDto>builder()
                .success(true)
                .message("Goals malumotlar: ")
                .data(this.goalsMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<GoalsDto> updateGoals(GoalsDto dto, Integer goalsId) {
        Optional<Goals> optional = this.goalsRepository.findByGoalsId(goalsId);
        if (optional.isEmpty()) {
            return ResponseDto.<GoalsDto>builder()
                    .message("Goals is not found!")
                    .code(-3)
                    .build();
        }
        Goals goals = this.goalsMapper.toEntity(dto);
        goals.setGoalsId(optional.get().getGoalsId());
        this.goalsRepository.save(goals);
        return ResponseDto.<GoalsDto>builder()
                .success(true)
                .message("Goals successful update and save in database")
                .data(this.goalsMapper.toDto(goals))
                .build();
    }

    public ResponseDto<GoalsDto> deleteGoals(Integer goalsId) {
        Optional<Goals> optional = this.goalsRepository.findByGoalsId(goalsId);
        if (optional.isEmpty()) {
            return ResponseDto.<GoalsDto>builder()
                    .message("Goals is not found!")
                    .code(-3)
                    .build();
        }
        this.goalsRepository.delete(optional.get());
        return ResponseDto.<GoalsDto>builder()
                .success(true)
                .message("Goals malumotlar ochirildi")
                .data(this.goalsMapper.toDto(optional.get()))
                .build();
    }
}
