package com.oglcnkrty.controller;

import com.oglcnkrty.dto.BaseResponse;
import com.oglcnkrty.dto.DtoEmployee;
import com.oglcnkrty.dto.PageSortRequest;
import com.oglcnkrty.dto.PagedResponse;
import com.oglcnkrty.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRestEmployeeController {
    BaseResponse<PagedResponse<DtoEmployee>> findAll(PageSortRequest pageSortRequest);
}
