package com.employeePayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	private List<EmployeePayrollData> employeePayrollList;

	EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData();
		employeePayrollService.writeEmployeePayrollData();
		consoleInputReader.close();
	}
	
	private void readEmployeePayrollData() {
		Scanner consoleInputReader = new Scanner(System.in);
		System.out.println("Enter employee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter employee name: ");
		String name = consoleInputReader.next();
		System.out.println("Enter employee salary: ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	private void writeEmployeePayrollData() {
		System.out.println("\nWriting Employee Payroll Roaster to Console \n" + employeePayrollList);
	}
}