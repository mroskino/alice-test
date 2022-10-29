package com.mrosko.alicetest.controller;

import com.mrosko.alicetest.api.request.TaskRequest;
import com.mrosko.alicetest.api.response.CalculationResponse;
import com.mrosko.alicetest.mapper.TaskMapper;
import com.mrosko.alicetest.model.Task;
import com.mrosko.alicetest.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
                .collect(Collectors.toMap(Task::getTaskCode, Function.identity()))
        );

        return mapToResponse(calculatedParameters);
    }


}
