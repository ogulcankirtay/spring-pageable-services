package com.oglcnkrty.service.impl;

import com.oglcnkrty.dto.DtoDepartment;
import com.oglcnkrty.dto.DtoEmployee;
import com.oglcnkrty.model.Employee;
import com.oglcnkrty.repository.EmployeeRepository;
import com.oglcnkrty.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);

    }

    @Override
    public List<DtoEmployee> toDtoEmployeeList(List<Employee> employees) {
        List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
        for (Employee employee : employees) {
            DtoEmployee dtoEmployee = new DtoEmployee();
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(employee, dtoDepartment);
            BeanUtils.copyProperties(employee.getDepartment(), dtoEmployee);
            dtoEmployee.setDepartment(dtoDepartment);
            dtoEmployeeList.add(dtoEmployee);
        }
        return dtoEmployeeList;
    }
}
