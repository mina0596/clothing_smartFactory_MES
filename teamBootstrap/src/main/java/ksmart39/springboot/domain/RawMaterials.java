package ksmart39.springboot.domain;

public class RawMaterials {
	private String rawMaterialCode;
	private String highClass;
	private String medClass;
	private String medCode;
	private String rawMaterialName;
	private String subCode;
	private String colorCode;
	private String feature;
	private String unit;
	private String rawMaterialRegDate;
	private String rawMaterialUpdateDate;

	private HumanResources employeeInfo;
	
	
	
	
	public HumanResources getEmployeeInfo() {
		return employeeInfo;
	}
	public void setEmployeeInfo(HumanResources employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
	public String getRawMaterialCode() {
		return rawMaterialCode;
	}
	public void setRawMaterialCode(String rawMaterialCode) {
		this.rawMaterialCode = rawMaterialCode;
	}
	public String getHighClass() {
		return highClass;
	}
	public void setHighClass(String highClass) {
		this.highClass = highClass;
	}
	public String getMedClass() {
		return medClass;
	}
	public void setMedClass(String medClass) {
		this.medClass = medClass;
	}
	public String getMedCode() {
		return medCode;
	}
	public void setMedCode(String medCode) {
		this.medCode = medCode;
	}
	public String getRawMaterialName() {
		return rawMaterialName;
	}
	public void setRawMaterialName(String rawMaterialName) {
		this.rawMaterialName = rawMaterialName;
	}
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRawMaterialRegDate() {
		return rawMaterialRegDate;
	}
	public void setRawMaterialRegDate(String rawMaterialRegDate) {
		this.rawMaterialRegDate = rawMaterialRegDate;
	}
	public String getRawMaterialUpdateDate() {
		return rawMaterialUpdateDate;
	}
	public void setRawMaterialUpdateDate(String rawMaterialUpdateDate) {
		this.rawMaterialUpdateDate = rawMaterialUpdateDate;
	}
	@Override
	public String toString() {
		return "RawMaterials [rawMaterialCode=" + rawMaterialCode + ", highClass=" + highClass + ", medClass="
				+ medClass + ", medCode=" + medCode + ", rawMaterialName=" + rawMaterialName + ", subCode=" + subCode
				+ ", colorCode=" + colorCode + ", feature=" + feature + ", unit=" + unit + ", rawMaterialRegDate="
				+ rawMaterialRegDate + ", rawMaterialUpdateDate=" + rawMaterialUpdateDate + ", employeeInfo="
				+ employeeInfo + "]";
	}
	


	
	
}
