package com.mrosko.alicetest.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Task {

    String taskCode;
    int duration;
    int crewMembersCount;
    List<String> dependencies;

}