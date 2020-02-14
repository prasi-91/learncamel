/*
 * This Class is similar to the CSV Input and used to Map CSV to java
 */

package com.learncamel.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", skipFirstLine = true)
public class CSVModel {
	
	@DataField(pos = 1)
	private Integer SINo;
	
	@DataField(pos = 2)
	private String name;
	
	@DataField(pos = 3)
	private String country;
	
	
	public Integer getSINo() {
		return SINo;
	}
	public void setSINo(Integer sINo) {
		SINo = sINo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
