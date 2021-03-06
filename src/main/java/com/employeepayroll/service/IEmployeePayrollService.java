package com.employeepayroll.service;

import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();


    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empId);

    List<EmployeePayrollData> getEmployeesByDepartment(String department);

}