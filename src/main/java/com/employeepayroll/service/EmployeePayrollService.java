package com.employeepayroll.service;
import com.employeepayroll.dto.EmployeePayrollDTO;
import com.employeepayroll.exceptions.EmployeePayrollException;
import com.employeepayroll.model.EmployeePayrollData;
import com.employeepayroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;



    @Override
    public List<EmployeePayrollData> getEmployeePayrollData(){
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(()->new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData=null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Emp Data: "+empData.toString());
        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }
    @Override
    public void deleteEmployeePayrollData(int empId){
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
}