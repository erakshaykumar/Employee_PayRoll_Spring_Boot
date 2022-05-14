package com.employeepayroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
Use Lombok Library for Logging i.e Slf4j
 */
@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll App !!!!!");
        ApplicationContext context = SpringApplication.run(EmployeePayrollApplication.class, args);
        log.info("Employee Payroll App Started in {} Environment",
                context.getEnvironment().getProperty("environment"));
    }

}