package com.mrosko.alicetest.mapper;

import com.mrosko.alicetest.api.response.CalculationResponse;
import com.mrosko.alicetest.model.CalculatedParameters;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CalculatedParametersMapper {

    public static CalculationResponse mapToResponse(CalculatedParameters model) {
        return CalculationResponse.builder()
                .time(model.getTime())
                .highestSum(model.getHighestSum())
                .build();
    }
}
