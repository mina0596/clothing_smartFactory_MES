package ksmart39.springboot.domain;

public class MediumClassInspection {
	private String highMedClassCode;
	private String highClassCode;
	private String medClassCode;
	private String medClassName;
	private String medClassRegDate;
	private String mediClassUpdateDate;
	
	@Override
	public String toString() {
		return "MediumClassInspection [highMedClassCode=" + highMedClassCode + ", highClassCode=" + highClassCode
				+ ", medClassCode=" + medClassCode + ", medClassName=" + medClassName + ", medClassRegDate="
				+ medClassRegDate + ", mediClassUpdateDate=" + mediClassUpdateDate + "]";
	}
	public String getHighMedClassCode() {
		return highMedClassCode;
	}
	public void setHighMedClassCode(String highMedClassCode) {
		this.highMedClassCode = highMedClassCode;
	}
	public String getHighClassCode() {
		return highClassCode;
	}
	public void setHighClassCode(String highClassCode) {
		this.highClassCode = highClassCode;
	}
	public String getMedClassCode() {
		return medClassCode;
	}
	public void setMedClassCode(String medClassCode) {
		this.medClassCode = medClassCode;
	}
	public String getMedClassName() {
		return medClassName;
	}
	public void setMedClassName(String medClassName) {
		this.medClassName = medClassName;
	}
	public String getMedClassRegDate() {
		return medClassRegDate;
	}
	public void setMedClassRegDate(String medClassRegDate) {
		this.medClassRegDate = medClassRegDate;
	}
	public String getMediClassUpdateDate() {
		return mediClassUpdateDate;
	}
	public void setMediClassUpdateDate(String mediClassUpdateDate) {
		this.mediClassUpdateDate = mediClassUpdateDate;
	}
	
	

}
