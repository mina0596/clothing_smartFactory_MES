package ksmart39.springboot.domain;

public class LowClassInspection {
	private String highMedLowclassCode;
	private String highClassCode;
	private String highMedClassCode;
	private String lowClassCode;
	private String lowClassName;
	private String lowClassRegDate;
	private String lowClassUpdateDate;
	
	private HighClassInspection highClassInspection;
	private MediumClassInspection mediumClassInspection;
	
	
	public String getHighMedLowclassCode() {
		return highMedLowclassCode;
	}
	public void setHighMedLowclassCode(String highMedLowclassCode) {
		this.highMedLowclassCode = highMedLowclassCode;
	}
	public String getHighClassCode() {
		return highClassCode;
	}
	public void setHighClassCode(String highClassCode) {
		this.highClassCode = highClassCode;
	}
	public String getHighMedClassCode() {
		return highMedClassCode;
	}
	public void setHighMedClassCode(String highMedClassCode) {
		this.highMedClassCode = highMedClassCode;
	}
	public String getLowClassCode() {
		return lowClassCode;
	}
	public void setLowClassCode(String lowClassCode) {
		this.lowClassCode = lowClassCode;
	}
	public String getLowClassName() {
		return lowClassName;
	}
	public void setLowClassName(String lowClassName) {
		this.lowClassName = lowClassName;
	}
	public String getLowClassRegDate() {
		return lowClassRegDate;
	}
	public void setLowClassRegDate(String lowClassRegDate) {
		this.lowClassRegDate = lowClassRegDate;
	}
	public String getLowClassUpdateDate() {
		return lowClassUpdateDate;
	}
	public void setLowClassUpdateDate(String lowClassUpdateDate) {
		this.lowClassUpdateDate = lowClassUpdateDate;
	}
	public HighClassInspection getHighClassInspection() {
		return highClassInspection;
	}
	public void setHighClassInspection(HighClassInspection highClassInspection) {
		this.highClassInspection = highClassInspection;
	}
	public MediumClassInspection getMediumClassInspection() {
		return mediumClassInspection;
	}
	public void setMediumClassInspection(MediumClassInspection mediumClassInspection) {
		this.mediumClassInspection = mediumClassInspection;
	}
	
	@Override
	public String toString() {
		return "LowClassInspection [highMedLowclassCode=" + highMedLowclassCode + ", highClassCode=" + highClassCode
				+ ", highMedClassCode=" + highMedClassCode + ", lowClassCode=" + lowClassCode + ", lowClassName="
				+ lowClassName + ", lowClassRegDate=" + lowClassRegDate + ", lowClassUpdateDate=" + lowClassUpdateDate
				+ ", highClassInspection=" + highClassInspection + ", mediumClassInspection=" + mediumClassInspection
				+ "]";
	}
	

}
