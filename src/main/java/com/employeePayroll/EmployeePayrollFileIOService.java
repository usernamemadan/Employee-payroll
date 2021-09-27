package com.employeePayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollFileIOService {
	public static final String PAYROLL_FILE_NAME = "/Users/madanar/eclipse-workspace/YML training/employee.java/EmployeePayroll/data/payroll-file.txt";

	/**
	 * writes the output of the file to the given path
	 */
	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String emloyeeDataString = employee.toString().concat("\n");
			empBuffer.append(emloyeeDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the number of entries in the file
	 */
	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
	
	/**
	 * @return read the data from the file
	 */
	public List<EmployeePayrollData> readData() {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(line -> {
				String[] s = line.split(" ");
				EmployeePayrollData emp = new EmployeePayrollData(Integer.valueOf(s[1]), s[3], Double.valueOf(s[5]));
				employeePayrollList.add(emp);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		      
		System.out.println(employeePayrollList);
		return employeePayrollList;
	}

	/**
	 * read the file the print the data
	 */
	public void printData() {
		try {
			Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
