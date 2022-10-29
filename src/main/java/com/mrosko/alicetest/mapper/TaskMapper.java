package com.mrosko.alicetest.mapper;

import com.mrosko.alicetest.api.request.TaskRequest;
import com.mrosko.alicetest.model.Task;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

@NoArgsConstructor
public class TaskMapper {

    public static Task mapToTask(TaskRequest request) {
        return Task.builder()
                .taskCode(request.getTaskCode())
                .crewMembersCount(isNull(request.getCrew())
                        ? 0
                        : request.getCrew().getAssignment())
                .duration(request.getDuration())
                .dependencies(request.getDependencies())
                .build();
    }
}
