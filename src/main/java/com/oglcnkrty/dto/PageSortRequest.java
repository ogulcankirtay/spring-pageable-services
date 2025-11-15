package com.oglcnkrty.dto;

import lombok.Data;

//model attribute
@Data
public class PageSortRequest {

    private int PageSize;
    private int PageNumber;
    private String SortBy;
    private boolean asc;

}
