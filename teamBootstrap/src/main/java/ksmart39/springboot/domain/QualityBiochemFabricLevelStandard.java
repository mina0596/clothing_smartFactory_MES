package ksmart39.springboot.domain;

public class QualityBiochemFabricLevelStandard {
	private String rawMaterialCode;
	private String qualityInspectionCode;
	private int minValue;
	private int maxValue;
	private int measuredLevel;
	private String biochemInspectionStandardRegDate;
	private String biochemInspectionStandardUpdateDate;
	
	
	public String getRawMaterialCode() {
		return rawMaterialCode;
	}
	public void setRawMaterialCode(String rawMaterialCode) {
		this.rawMaterialCode = rawMaterialCode;
	}
	public String getQualityInspectionCode() {
		return qualityInspectionCode;
	}
	public void setQualityInspectionCode(String qualityInspectionCode) {
		this.qualityInspectionCode = qualityInspectionCode;
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
	public int getMeasuredLevel() {
		return measuredLevel;
	}
	public void setMeasuredLevel(int measuredLevel) {
		this.measuredLevel = measuredLevel;
	}
	public String getBiochemInspectionStandardRegDate() {
		return biochemInspectionStandardRegDate;
	}
	public void setBiochemInspectionStandardRegDate(String biochemInspectionStandardRegDate) {
		this.biochemInspectionStandardRegDate = biochemInspectionStandardRegDate;
	}
	public String getBiochemInspectionStandardUpdateDate() {
		return biochemInspectionStandardUpdateDate;
	}
	public void setBiochemInspectionStandardUpdateDate(String biochemInspectionStandardUpdateDate) {
		this.biochemInspectionStandardUpdateDate = biochemInspectionStandardUpdateDate;
	}
	
	@Override
	public String toString() {
		return "QualityBiochemFabricLevelStandard [rawMaterialCode=" + rawMaterialCode + ", qualityInspectionCode="
				+ qualityInspectionCode + ", minValue=" + minValue + ", maxValue=" + maxValue + ", measuredLevel="
				+ measuredLevel + ", biochemInspectionStandardRegDate=" + biochemInspectionStandardRegDate
				+ ", biochemInspectionStandardUpdateDate=" + biochemInspectionStandardUpdateDate + "]";
	}
	
	
}
