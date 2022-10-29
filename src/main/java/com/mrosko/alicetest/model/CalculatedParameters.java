package com.mrosko.alicetest.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CalculatedParameters {

    long time;
    long highestSum;
}
