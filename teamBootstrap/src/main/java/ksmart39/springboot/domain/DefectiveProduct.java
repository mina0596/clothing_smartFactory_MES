package ksmart39.springboot.domain;

public class DefectiveProduct {
	private String defectiveProductCode;
	private String qualityInspectionRequestCode;
	private String chargeEmployeeCode;
	private String qualityInspectionCode;
	private String inspectionResultCode;
	private String defectCause;
	private String defectiveProductMeasure;
	private String managementNote;
	private String defectiveProductRegDate;
	private String defectiveProductUpdateDate;
	
	public String getDefectiveProductCode() {
		return defectiveProductCode;
	}
	public void setDefectiveProductCode(String defectiveProductCode) {
		this.defectiveProductCode = defectiveProductCode;
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
	public String getInspectionResultCode() {
		return inspectionResultCode;
	}
	public void setInspectionResultCode(String inspectionResultCode) {
		this.inspectionResultCode = inspectionResultCode;
	}
	public String getDefectCause() {
		return defectCause;
	}
	public void setDefectCause(String defectCause) {
		this.defectCause = defectCause;
	}
	public String getDefectiveProductMeasure() {
		return defectiveProductMeasure;
	}
	public void setDefectiveProductMeasure(String defectiveProductMeasure) {
		this.defectiveProductMeasure = defectiveProductMeasure;
	}
	public String getManagementNote() {
		return managementNote;
	}
	public void setManagementNote(String managementNote) {
		this.managementNote = managementNote;
	}
	public String getDefectiveProductRegDate() {
		return defectiveProductRegDate;
	}
	public void setDefectiveProductRegDate(String defectiveProductRegDate) {
		this.defectiveProductRegDate = defectiveProductRegDate;
	}
	public String getDefectiveProductUpdateDate() {
		return defectiveProductUpdateDate;
	}
	public void setDefectiveProductUpdateDate(String defectiveProductUpdateDate) {
		this.defectiveProductUpdateDate = defectiveProductUpdateDate;
	}
	@Override
	public String toString() {
		return "DefectiveProductCategory [defectiveProductCode=" + defectiveProductCode
				+ ", qualityInspectionRequestCode=" + qualityInspectionRequestCode + ", chargeEmployeeCode="
				+ chargeEmployeeCode + ", qualityInspectionCode=" + qualityInspectionCode + ", inspectionResultCode="
				+ inspectionResultCode + ", defectCause=" + defectCause + ", defectiveProductMeasure="
				+ defectiveProductMeasure + ", managementNote=" + managementNote + ", defectiveProductRegDate="
				+ defectiveProductRegDate + ", defectiveProductUpdateDate=" + defectiveProductUpdateDate + "]";
	}
	
	
}
