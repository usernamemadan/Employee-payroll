package com.employeePayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}
	private List<EmployeePayrollData> employeePayrollList;

	public EmployeePayrollService() {}
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData();
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		consoleInputReader.close();
		employeePayrollService.printData();
	}

	private void readEmployeePayrollData() {
		Scanner consoleInputReader = new Scanner(System.in);
		System.out.println("Enter employee ID: ");
		int id = consoleInputReader.nextInt();
		consoleInputReader.nextLine();
		System.out.println("Enter employee name: ");
		String name = consoleInputReader.nextLine();
		System.out.println("Enter employee salary: ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO)) {
			System.out.println("\nWriting Employee Payroll roaster to console\n" + employeePayrollList);
		} else if (ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
		}
	}
	/**
	 * @return the no of entries in the file
	 */
	public long countEntries() {  
        return new EmployeePayrollFileIOService().countEntries();
    }
	/**
	 * prints the data in the file
	 */
	public void printData() {
		new EmployeePayrollFileIOService().printData();
	}
	/**
	 * method to read the data from the file
	 * @return count of the entries in the file
	 */
	public int readFromFile() {
		this.employeePayrollList = new EmployeePayrollFileIOService().readData();
		System.out.println(employeePayrollList.size());
		return this.employeePayrollList.size();
	}
}