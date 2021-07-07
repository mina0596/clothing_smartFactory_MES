package ksmart39.springboot.domain;

public class HighClassInspection {
	private String highClassCode;
	private String highClassName;
	private String highClassRegDate;
	private String highClassUpdateDate;
	
	public String getHighClassCode() {
		return highClassCode;
	}
	public void setHighClassCode(String highClassCode) {
		this.highClassCode = highClassCode;
	}
	public String getHighClassName() {
		return highClassName;
	}
	public void setHighClassName(String highClassName) {
		this.highClassName = highClassName;
	}
	public String getHighClassRegDate() {
		return highClassRegDate;
	}
	public void setHighClassRegDate(String highClassRegDate) {
		this.highClassRegDate = highClassRegDate;
	}
	public String getHighClassUpdateDate() {
		return highClassUpdateDate;
	}
	public void setHighClassUpdateDate(String highClassUpdateDate) {
		this.highClassUpdateDate = highClassUpdateDate;
	}
	
	@Override
	public String toString() {
		return "HighClassInspection [highClassCode=" + highClassCode + ", highClassName=" + highClassName
				+ ", highClassRegDate=" + highClassRegDate + ", highClassUpdateDate=" + highClassUpdateDate + "]";
	}

}
