package com.mrosko.alicetest.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CalculatedParameteres {

    long time;
    long highestSum;
}
