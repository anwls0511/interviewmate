package com.interviewmate.admin.payment.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminPaymentSearchRequest {

    private String email;

    private String planType;

    private String status;

    @Min(value = 1, message = "페이지 번호는 1 이상이어야 합니다.")
    private Integer page = 1;

    @Min(value = 1, message = "페이지 크기는 1 이상이어야 합니다.")
    @Max(value = 100, message = "페이지 크기는 최대 100까지 가능합니다.")
    private Integer size = 10;

    public int getOffset() {
        return (page - 1) * size;
    }
}