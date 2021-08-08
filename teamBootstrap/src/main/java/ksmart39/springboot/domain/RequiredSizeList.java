package ksmart39.springboot.domain;

public class RequiredSizeList {
	private String requiredSizeCode;
	private String detailedCategorizedCode;
	private String qualityInspectionCode;
	private String measurementPart;
	private String unit;
	private String requiredSizeRegDate;
	private String requiredSizeUpdateDate;
	
	public String getRequiredSizeCode() {
		return requiredSizeCode;
	}
	public void setRequiredSizeCode(String requiredSizeCode) {
		this.requiredSizeCode = requiredSizeCode;
	}
	public String getDetailedCategorizedCode() {
		return detailedCategorizedCode;
	}
	public void setDetailedCategorizedCode(String detailedCategorizedCode) {
		this.detailedCategorizedCode = detailedCategorizedCode;
	}
	public String getQualityInspectionCode() {
		return qualityInspectionCode;
	}
	public void setQualityInspectionCode(String qualityInspectionCode) {
		this.qualityInspectionCode = qualityInspectionCode;
	}
	public String getMeasurementPart() {
		return measurementPart;
	}
	public void setMeasurementPart(String measurementPart) {
		this.measurementPart = measurementPart;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getRequiredSizeRegDate() {
		return requiredSizeRegDate;
	}
	public void setRequiredSizeRegDate(String requiredSizeRegDate) {
		this.requiredSizeRegDate = requiredSizeRegDate;
	}
	public String getRequiredSizeUpdateDate() {
		return requiredSizeUpdateDate;
	}
	public void setRequiredSizeUpdateDate(String requiredSizeUpdateDate) {
		this.requiredSizeUpdateDate = requiredSizeUpdateDate;
	}
	
	@Override
	public String toString() {
		return "RequiredSizeList [requiredSizeCode=" + requiredSizeCode + ", detailedCategorizedCode="
				+ detailedCategorizedCode + ", qualityInspectionCode=" + qualityInspectionCode + ", measurementPart="
				+ measurementPart + ", unit=" + unit + ", requiredSizeRegDate=" + requiredSizeRegDate
				+ ", requiredSizeUpdateDate=" + requiredSizeUpdateDate + "]";
	}
	
	
}
