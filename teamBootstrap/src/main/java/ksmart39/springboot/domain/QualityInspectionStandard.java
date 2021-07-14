package ksmart39.springboot.domain;

public class QualityInspectionStandard {
	
	private String qualityInspectionCode;
	private String category;
	private int minValue;
	private int maxValue;
	private String method;
	private String standardMeasurementUnit;
	private String standardTolerance;
	private String requiredInspectionCheck;
	private String inspectionStandardRegDate;
	private String inspectionStandardUpdateDate;
	
	public String getQualityInspectionCode() {
		return qualityInspectionCode;
	}
	public void setQualityInspectionCode(String qualityInspectionCode) {
		this.qualityInspectionCode = qualityInspectionCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getMinValue() {
		return minValue;
	}
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getStandardMeasurementUnit() {
		return standardMeasurementUnit;
	}
	public void setStandardMeasurementUnit(String standardMeasurementUnit) {
		this.standardMeasurementUnit = standardMeasurementUnit;
	}
	public String getStandardTolerance() {
		return standardTolerance;
	}
	public void setStandardTolerance(String standardTolerance) {
		this.standardTolerance = standardTolerance;
	}
	public String getRequiredInspectionCheck() {
		return requiredInspectionCheck;
	}
	public void setRequiredInspectionCheck(String requiredInspectionCheck) {
		this.requiredInspectionCheck = requiredInspectionCheck;
	}
	public String getInspectionStandardRegDate() {
		return inspectionStandardRegDate;
	}
	public void setInspectionStandardRegDate(String inspectionStandardRegDate) {
		this.inspectionStandardRegDate = inspectionStandardRegDate;
	}
	public String getInspectionStandardUpdateDate() {
		return inspectionStandardUpdateDate;
	}
	public void setInspectionStandardUpdateDate(String inspectionStandardUpdateDate) {
		this.inspectionStandardUpdateDate = inspectionStandardUpdateDate;
	}
	
	
	@Override
	public String toString() {
		return "QualityInspectionStandard [qualityInspectionCode=" + qualityInspectionCode + ", category=" + category
				+ ", minValue=" + minValue + ", maxValue=" + maxValue + ", method=" + method
				+ ", standardMeasurementUnit=" + standardMeasurementUnit + ", standardTolerance=" + standardTolerance
				+ ", requiredInspectionCheck=" + requiredInspectionCheck + ", inspectionStandardRegDate="
				+ inspectionStandardRegDate + ", inspectionStandardUpdateDate=" + inspectionStandardUpdateDate + "]";
	}
	
	
}
