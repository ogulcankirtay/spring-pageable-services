package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestEmployeeController;
import com.oglcnkrty.controller.RestBaseController;
import com.oglcnkrty.dto.BaseResponse;
import com.oglcnkrty.dto.DtoEmployee;
import com.oglcnkrty.dto.PageSortRequest;
import com.oglcnkrty.dto.PagedResponse;
import com.oglcnkrty.model.Employee;
import com.oglcnkrty.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employee")
@RestController
public class RestEmployeeControllerImpl extends RestBaseController implements IRestEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list/pageable")
    @Override
    public BaseResponse<PagedResponse<DtoEmployee>> findAll(PageSortRequest pageSortRequest) {
        Page<Employee> page = employeeService.findAll(toPageable(pageSortRequest));
        return ok(toPageableResponse(page, employeeService.toDtoEmployeeList(page.getContent())));


    }
}
