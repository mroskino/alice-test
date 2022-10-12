package com.mrosko.alicetest.service;

import com.mrosko.alicetest.model.CalculatedParameteres;
import com.mrosko.alicetest.model.Task;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CalculationService {


    public CalculatedParameteres calculate(List<Task> tasks) {

        log.info("Total tasks count: {}", tasks.size());
        log.info("Start tasks count: {}", tasks.stream().filter(task -> task.getDependencies().isEmpty()).count());
        Set<String> tasksInDependencies = tasks.stream().flatMap(task -> task.getDependencies().stream()).collect(Collectors.toSet());
        Set<String> endTasks = tasks.stream().map(Task::getTaskCode).filter(taskCode -> !tasksInDependencies.contains(taskCode)).collect(Collectors.toSet());
        log.info("End tasks count: {}", endTasks.size());

        Set<String> workingTasks = new HashSet<>(tasks.size());

        for (Task task : tasks) {
            WorkingTask.builder()
                    .taskId(task.getTaskCode())
                    .previousTasks(task.getDependencies())
                    .build();


        }





        return CalculatedParameteres.builder()
                .highestSum(12)
                .time(20)
                .build();
    }


    @Data
    @Builder
    @EqualsAndHashCode(of = "taskId")
    private static class WorkingTask {
        String taskId;
        List<String> nextTasks;
        List<String> previousTasks;
    }


}
