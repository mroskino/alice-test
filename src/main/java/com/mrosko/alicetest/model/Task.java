package com.mrosko.alicetest.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@Builder
public class Task {

    String taskCode;
    int duration;
    int crewMembersCount;
    List<String> dependencies;
    Integer earlyStart;
    Integer earlyFinish;
    Integer latestStart;
    Integer latestFinish;
    Integer maxDurationCost;
    String maxDurationCostPreviousTaskCode;
}