package ksmart39.springboot.domain;

public class QualityInspectionResult {

	private String inspectionResultCode;
	private String qualityInspectionRequestCode;
	private String chargeEmployeeCode;
	private String qualityInspectionCode;
	private String inspectionMeasurementNum;
	private int inspectionMeasurementValue;
	private int inspectionMeasurementLevelResult;
	private int minTolerance;
	private int maxTolerance;
	private int errorRange;
	private String inspectionPassCheck;
	private String inspectionStartDate;
	private int inspectionDuration;
	private String inspectionEndDate;
	private String inspectionResultRegDate;
	private String inspectionResult_updateDate;
	public String getInspectionResultCode() {
		return inspectionResultCode;
	}
	public void setInspectionResultCode(String inspectionResultCode) {
		this.inspectionResultCode = inspectionResultCode;
	}
	public String getQualityInspectionRequestCode() {
		return qualityInspectionRequestCode;
	}
	public void setQualityInspectionRequestCode(String qualityInspectionRequestCode) {
		this.qualityInspectionRequestCode = qualityInspectionRequestCode;
	}
	public String getChargeEmployeeCode() {
		return chargeEmployeeCode;
	}
	public void setChargeEmployeeCode(String chargeEmployeeCode) {
		this.chargeEmployeeCode = chargeEmployeeCode;
	}
	public String getQualityInspectionCode() {
		return qualityInspectionCode;
	}
	public void setQualityInspectionCode(String qualityInspectionCode) {
		this.qualityInspectionCode = qualityInspectionCode;
	}
	public String getInspectionMeasurementNum() {
		return inspectionMeasurementNum;
	}
	public void setInspectionMeasurementNum(String inspectionMeasurementNum) {
		this.inspectionMeasurementNum = inspectionMeasurementNum;
	}
	public int getInspectionMeasurementValue() {
		return inspectionMeasurementValue;
	}
	public void setInspectionMeasurementValue(int inspectionMeasurementValue) {
		this.inspectionMeasurementValue = inspectionMeasurementValue;
	}
	public int getInspectionMeasurementLevelResult() {
		return inspectionMeasurementLevelResult;
	}
	public void setInspectionMeasurementLevelResult(int inspectionMeasurementLevelResult) {
		this.inspectionMeasurementLevelResult = inspectionMeasurementLevelResult;
	}
	public int getMinTolerance() {
		return minTolerance;
	}
	public void setMinTolerance(int minTolerance) {
		this.minTolerance = minTolerance;
	}
	public int getMaxTolerance() {
		return maxTolerance;
	}
	public void setMaxTolerance(int maxTolerance) {
		this.maxTolerance = maxTolerance;
	}
	public int getErrorRange() {
		return errorRange;
	}
	public void setErrorRange(int errorRange) {
		this.errorRange = errorRange;
	}
	public String getInspectionPassCheck() {
		return inspectionPassCheck;
	}
	public void setInspectionPassCheck(String inspectionPassCheck) {
		this.inspectionPassCheck = inspectionPassCheck;
	}
	public String getInspectionStartDate() {
		return inspectionStartDate;
	}
	public void setInspectionStartDate(String inspectionStartDate) {
		this.inspectionStartDate = inspectionStartDate;
	}
	public int getInspectionDuration() {
		return inspectionDuration;
	}
	public void setInspectionDuration(int inspectionDuration) {
		this.inspectionDuration = inspectionDuration;
	}
	public String getInspectionEndDate() {
		return inspectionEndDate;
	}
	public void setInspectionEndDate(String inspectionEndDate) {
		this.inspectionEndDate = inspectionEndDate;
	}
	public String getInspectionResultRegDate() {
		return inspectionResultRegDate;
	}
	public void setInspectionResultRegDate(String inspectionResultRegDate) {
		this.inspectionResultRegDate = inspectionResultRegDate;
	}
	public String getInspectionResult_updateDate() {
		return inspectionResult_updateDate;
	}
	public void setInspectionResult_updateDate(String inspectionResult_updateDate) {
		this.inspectionResult_updateDate = inspectionResult_updateDate;
	}
	@Override
	public String toString() {
		return "QualityInspectionResult [inspectionResultCode=" + inspectionResultCode
				+ ", qualityInspectionRequestCode=" + qualityInspectionRequestCode + ", chargeEmployeeCode="
				+ chargeEmployeeCode + ", qualityInspectionCode=" + qualityInspectionCode
				+ ", inspectionMeasurementNum=" + inspectionMeasurementNum + ", inspectionMeasurementValue="
				+ inspectionMeasurementValue + ", inspectionMeasurementLevelResult=" + inspectionMeasurementLevelResult
				+ ", minTolerance=" + minTolerance + ", maxTolerance=" + maxTolerance + ", errorRange=" + errorRange
				+ ", inspectionPassCheck=" + inspectionPassCheck + ", inspectionStartDate=" + inspectionStartDate
				+ ", inspectionDuration=" + inspectionDuration + ", inspectionEndDate=" + inspectionEndDate
				+ ", inspectionResultRegDate=" + inspectionResultRegDate + ", inspectionResult_updateDate="
				+ inspectionResult_updateDate + "]";
	}
	
	
	
	
}
