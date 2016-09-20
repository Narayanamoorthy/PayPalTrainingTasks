package com.springbatchtraining;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;


import com.springbatchtraining.model.EmployeeReport;

public class ReportFieldSetMapper implements FieldSetMapper<EmployeeReport>{
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public EmployeeReport mapFieldSet(FieldSet fieldSet) throws BindException {

		
			
			EmployeeReport report = new EmployeeReport();
			/*report.setId(fieldSet.readInt(0));
			report.setSales(fieldSet.readBigDecimal(1));
			report.setQty(fieldSet.readInt(2));
			report.setStaffName(fieldSet.readString(3));*/
			
			
			report.setEmpid(fieldSet.readInt(0));
			report.setName(fieldSet.readString(1));
			report.setLocation(fieldSet.readInt(2));
			report.setDepartment(fieldSet.readString(3));
			
			//default format yyyy-MM-dd
			//fieldSet.readDate(4);
			String date = fieldSet.readString(4);
			try {
				report.setDoj(dateFormat.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			return report;
			
		}

	}

