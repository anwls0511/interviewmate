package com.interviewmate.global.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageResponse<T> {

    private int totalCount;

    private int page;

    private int size;

    private List<T> contents;
}