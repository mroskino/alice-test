package com.mrosko.alicetest.api.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CalculationResponse {

    long time;
    long highestSum;

}
