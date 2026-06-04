package com.interviewmate.interview.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterviewSearchRequest {

    private Integer page = 1;

    private Integer size = 10;

    public int getOffset() {
        return (page - 1) * size;
    }
}