package ksmart39.springboot.domain;

public class QualityInspection {
	private String qualityInspectionCode;
	private String highClassificationCode;
	private String  highClassificationName;
	private String mediumClassificationCode	;
	private String mediumClassificationName;
	private String lowClassificationCode;
	private String lowClassificationName;	
	private String subClassificationCode;	
	private String subClassificationName;	
	private String qualityInspectionRegDate;	
	private String qualityInspectionUpdateDate;
	
	
	public String getQualityInspectionCode() {
		return qualityInspectionCode;
	}
	public void setQualityInspectionCode(String qualityInspectionCode) {
		this.qualityInspectionCode = qualityInspectionCode;
	}
	public String getHighClassificationCode() {
		return highClassificationCode;
	}
	public void setHighClassificationCode(String highClassificationCode) {
		this.highClassificationCode = highClassificationCode;
	}
	public String getHighClassificationName() {
		return highClassificationName;
	}
	public void setHighClassificationName(String highClassificationName) {
		this.highClassificationName = highClassificationName;
	}
	public String getMediumClassificationCode() {
		return mediumClassificationCode;
	}
	public void setMediumClassificationCode(String mediumClassificationCode) {
		this.mediumClassificationCode = mediumClassificationCode;
	}
	public String getMediumClassificationName() {
		return mediumClassificationName;
	}
	public void setMediumClassificationName(String mediumClassificationName) {
		this.mediumClassificationName = mediumClassificationName;
	}
	public String getLowClassificationCode() {
		return lowClassificationCode;
	}
	public void setLowClassificationCode(String lowClassificationCode) {
		this.lowClassificationCode = lowClassificationCode;
	}
	public String getLowClassificationName() {
		return lowClassificationName;
	}
	public void setLowClassificationName(String lowClassificationName) {
		this.lowClassificationName = lowClassificationName;
	}
	public String getSubClassificationCode() {
		return subClassificationCode;
	}
	public void setSubClassificationCode(String subClassificationCode) {
		this.subClassificationCode = subClassificationCode;
	}
	public String getSubClassificationName() {
		return subClassificationName;
	}
	public void setSubClassificationName(String subClassificationName) {
		this.subClassificationName = subClassificationName;
	}
	public String getQualityInspectionRegDate() {
		return qualityInspectionRegDate;
	}
	public void setQualityInspectionRegDate(String qualityInspectionRegDate) {
		this.qualityInspectionRegDate = qualityInspectionRegDate;
	}
	public String getQualityInspectionUpdateDate() {
		return qualityInspectionUpdateDate;
	}
	public void setQualityInspectionUpdateDate(String qualityInspectionUpdateDate) {
		this.qualityInspectionUpdateDate = qualityInspectionUpdateDate;
	}
	@Override
	public String toString() {
		return "QualityInspection [qualityInspectionCode=" + qualityInspectionCode + ", highClassificationCode="
				+ highClassificationCode + ", highClassificationName=" + highClassificationName
				+ ", mediumClassificationCode=" + mediumClassificationCode + ", mediumClassificationName="
				+ mediumClassificationName + ", lowClassificationCode=" + lowClassificationCode
				+ ", lowClassificationName=" + lowClassificationName + ", subClassificationCode="
				+ subClassificationCode + ", subClassificationName=" + subClassificationName
				+ ", qualityInspectionRegDate=" + qualityInspectionRegDate + ", qualityInspectionUpdateDate="
				+ qualityInspectionUpdateDate + "]";
	}

}
