package com.oglcnkrty.controller;

import com.oglcnkrty.dto.BaseResponse;
import com.oglcnkrty.dto.PageSortRequest;
import com.oglcnkrty.dto.PagedResponse;
import com.oglcnkrty.util.PagerUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class RestBaseController {

    public PageRequest toPageable(PageSortRequest pageSortRequest) {
        return PagerUtil.toPageable(pageSortRequest);
    }

    public <T> PagedResponse<T> toPageableResponse(Page page, List<T> content) {
        return PagerUtil.toPageableResponse(page, content);
    }

    public <T> BaseResponse<T> ok(T data) {
        return BaseResponse.ok(data);
    }

    public BaseResponse error(String message) {
        return BaseResponse.error(message);
    }
}
