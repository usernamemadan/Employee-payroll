package com.employeePayrollTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.employeePayroll.EmployeePayrollData;
import com.employeePayroll.EmployeePayrollFileIOService;
import com.employeePayroll.EmployeePayrollService;
import com.employeePayroll.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {
	
	/**
	 * test case to write and count the number of lines from the file
	 */
	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, " Jeff Bezos", 100000.0),
				new EmployeePayrollData(2, "Bill Gates", 200000.0),
				new EmployeePayrollData(3, "Mark Zuckerberg", 300000.0)
		};

		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries();
		assertEquals(3, entries);
	}
	
	/**
	 * test case to read and count the number of lines from the file
	 */
	@Test
	public void given3EmployeesWhenReadFromFileShouldMatchEmployeeEntries() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		long entries = employeePayrollService.readFromFile();
		assertEquals(3, entries);
	}
	
	
}
