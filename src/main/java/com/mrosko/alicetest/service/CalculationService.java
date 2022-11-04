package com.mrosko.alicetest.service;

import com.mrosko.alicetest.model.CalculatedParameters;
import com.mrosko.alicetest.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CalculationService {

    public CalculatedParameters calculate(Map<String, Task> tasks) {

        log.info("Total tasks count: {}", tasks.size());
        log.info("Start tasks count: {}", tasks.values().stream()
                .filter(task -> task.getDependencies().isEmpty())
                .count());

        Set<String> tasksInDependencies = tasks.values().stream()
                .flatMap(task -> task.getDependencies().stream())
                .collect(Collectors.toSet());

        Set<Task> endTasks = tasks.values().stream()
                .filter(task -> !tasksInDependencies.contains(task.getTaskCode()))
                .collect(Collectors.toSet());

        endTasks.forEach(task -> {
            task.setMaxDurationCost(task.getDuration());
        });

        log.info("End tasks count: {}", endTasks.size());

        findMaxPrice(tasks, endTasks);

        return CalculatedParameters.builder()
                .highestSum(12)
                .time(20)
                .build();
    }

    private void findMaxPrice(Map<String, Task> tasks, Set<Task> tasksToExpand) {
        for (Task task : tasksToExpand) {
            log.info("Cost: " + tasks.get(task.getTaskCode()).getMaxDurationCost());
        }
    }
}
