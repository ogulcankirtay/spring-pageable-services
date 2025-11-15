package com.oglcnkrty.service;

import com.oglcnkrty.dto.DtoEmployee;
import com.oglcnkrty.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    public List<DtoEmployee> toDtoEmployeeList(List<Employee> employees);
}
