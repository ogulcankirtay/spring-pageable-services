package com.oglcnkrty.util;

import com.oglcnkrty.dto.PageSortRequest;
import com.oglcnkrty.dto.PagedResponse;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@UtilityClass
public class PagerUtil {

    public Boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public PageRequest toPageable(PageSortRequest pageRequest) {
        if (!isNullOrEmpty(pageRequest.getSortBy())) {
            Sort sort = pageRequest.isAsc() ?
                    Sort.by(Sort.Direction.ASC, pageRequest.getSortBy())
                    : Sort.by(Sort.Direction.DESC, pageRequest.getSortBy());
            return PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), sort);
        }
        return PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
    }

    public <T> PagedResponse<T> toPageableResponse(Page page, List<T> content) {
        PagedResponse<T> pagedResponse = new PagedResponse<>();
        pagedResponse.setContent(content);
        pagedResponse.setPageSize(page.getPageable().getPageSize());
        pagedResponse.setPageNumber(page.getPageable().getPageNumber());
        pagedResponse.setTotalElements(page.getTotalElements());
        return pagedResponse;
    }
}