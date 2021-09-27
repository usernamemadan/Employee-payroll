package com.employeePayrollTest;

import java.io.File;

public class FileUtils {

	public static void deleteFiles(File filePath) {
		// TODO Auto-generated method stub
		File[] allContents = filePath.listFiles();
		if (allContents != null) {
			for (File file : allContents) {
				deleteFiles(file);
			}
		}
	}
}
