package com.springbatchtraining;

import org.springframework.batch.item.ItemProcessor;

import com.springbatchtraining.model.EmployeeReport;

public class CustomItemProcessor implements ItemProcessor<EmployeeReport,EmployeeReport> {

	public EmployeeReport process(EmployeeReport employeeReport) throws Exception {
		switch (employeeReport.getLocation()) {
		case 2:
			employeeReport.setDepartment("BngrIT");
			break;
case 1:
	employeeReport.setDepartment("chennaiBPO");
			break;
case 3:
	employeeReport.setDepartment("TNGovt");
	break;

		default:
			break;
		}
		System.out.println("processing :: " + employeeReport.getName());
	//	System.out.println("processing :: " + employeeReport.getName());
		return employeeReport;
	}



}
