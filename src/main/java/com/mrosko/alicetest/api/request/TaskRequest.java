package com.mrosko.alicetest.api.request;

import lombok.Value;
import org.springframework.lang.NonNull;
import java.util.List;

@Value
public class TaskRequest {

    @NonNull
    String taskCode;
    String operationName;
    String elementName;
    @NonNull
    Integer duration;
    Crew crew;
    List<Equipment> equipment;
    List<String> dependencies;

    @Value
    public static class Crew {

        String name;
        @NonNull
        Integer assignment;

    }

    @Value
    public static class Equipment {

        String name;
        Integer quantity;

    }

}