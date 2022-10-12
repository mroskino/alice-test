package com.mrosko.alicetest.controller;

import com.mrosko.alicetest.api.request.TaskRequest;
import com.mrosko.alicetest.api.response.CalculationResponse;
import com.mrosko.alicetest.mapper.TaskMapper;
import com.mrosko.alicetest.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mrosko.alicetest.mapper.CalculatedParametersMapper.mapToResponse;

@RestController
@RequestMapping("calculation")
@RequiredArgsConstructor
public class CalculationController {

    private final CalculationService calculationService;

    @PostMapping
    public CalculationResponse calculate(@RequestBody List<TaskRequest> tasks) {

        var calculatedParameters = calculationService.calculate(tasks.stream()
                .map(TaskMapper::mapToTask)
                .toList()
        );

        return mapToResponse(calculatedParameters);
    }


}
