//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Controller;


import com.company.Personal_LibraryMarket.Dto.GoalsDto;
import com.company.Personal_LibraryMarket.Dto.ResponseDto;
import com.company.Personal_LibraryMarket.Service.GoalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "goals")
public class GoalsController {

    private final GoalsService goalsService;

    @PostMapping(value = "/create")
    public ResponseDto<GoalsDto> create(@RequestBody GoalsDto dto){
        return this.goalsService.createGoals(dto);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseDto<GoalsDto> get(@PathVariable(value = "id") Integer goalsId){
        return this.goalsService.getGoals(goalsId);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseDto<GoalsDto> update(@RequestBody GoalsDto dto,
                                        @PathVariable(value = "id") Integer goalsId){
        return this.goalsService.updateGoals(dto, goalsId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<GoalsDto> delete(@PathVariable(value = "id") Integer goalsId){
        return this.goalsService.deleteGoals(goalsId);
    }


}
