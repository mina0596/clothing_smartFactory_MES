package ksmart39.springboot.domain;

public class SubClassInspection {
	private String qualityInspectionCode;
	private String highClassCode;
	private String highMedClassCode;
	private String highMedLowClassCode;
	private String subClassCode;
	private String subClassName;
	private String subClassRegDate;
	private String subClassUpdateDate;
	
	private HighClassInspection highClassInspection;
	private MediumClassInspection mediumClassInspection;
	private LowClassInspection lowClassInspection;
	public String getQualityInspectionCode() {
		return qualityInspectionCode;
	}
	public void setQualityInspectionCode(String qualityInspectionCode) {
		this.qualityInspectionCode = qualityInspectionCode;
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
	public String getHighMedLowClassCode() {
		return highMedLowClassCode;
	}
	public void setHighMedLowClassCode(String highMedLowClassCode) {
		this.highMedLowClassCode = highMedLowClassCode;
	}
	public String getSubClassCode() {
		return subClassCode;
	}
	public void setSubClassCode(String subClassCode) {
		this.subClassCode = subClassCode;
	}
	public String getSubClassName() {
		return subClassName;
	}
	public void setSubClassName(String subClassName) {
		this.subClassName = subClassName;
	}
	public String getSubClassRegDate() {
		return subClassRegDate;
	}
	public void setSubClassRegDate(String subClassRegDate) {
		this.subClassRegDate = subClassRegDate;
	}
	public String getSubClassUpdateDate() {
		return subClassUpdateDate;
	}
	public void setSubClassUpdateDate(String subClassUpdateDate) {
		this.subClassUpdateDate = subClassUpdateDate;
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
	public LowClassInspection getLowClassInspection() {
		return lowClassInspection;
	}
	public void setLowClassInspection(LowClassInspection lowClassInspection) {
		this.lowClassInspection = lowClassInspection;
	}
	@Override
	public String toString() {
		return "SubClassInspection [qualityInspectionCode=" + qualityInspectionCode + ", highClassCode=" + highClassCode
				+ ", highMedClassCode=" + highMedClassCode + ", highMedLowClassCode=" + highMedLowClassCode
				+ ", subClassCode=" + subClassCode + ", subClassName=" + subClassName + ", subClassRegDate="
				+ subClassRegDate + ", subClassUpdateDate=" + subClassUpdateDate + ", highClassInspection="
				+ highClassInspection + ", mediumClassInspection=" + mediumClassInspection + ", lowClassInspection="
				+ lowClassInspection + "]";
	}
	
	


	
	
	
	
	

}
