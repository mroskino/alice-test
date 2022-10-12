package com.mrosko.alicetest.mapper;

import com.mrosko.alicetest.api.response.CalculationResponse;
import com.mrosko.alicetest.model.CalculatedParameteres;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CalculatedParametersMapper {

    public static CalculationResponse mapToResponse(CalculatedParameteres model) {
        return CalculationResponse.builder()
                .time(model.getTime())
                .highestSum(model.getHighestSum())
                .build();
    }
}
