package com.oglcnkrty.dto;

import lombok.Data;

import java.util.List;

@Data
public class PagedResponse<T> {

    private List<T> content;

    private int pageNumber;

    private int pageSize;

    private long totalElements;


}
