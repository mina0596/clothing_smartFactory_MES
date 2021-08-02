package ksmart39.springboot.domain;

public class QualityInspectionRequest {
	private String qualityInspectionRequestCode;
	private String requestedProductCode;
	private String qualityInspectionRequestEmployeeCode;
	private String qualityInspectionRequestApprovedEmployeeCode;
	private String rawMaterialCode;
	private String qualityInspectionCode;
	private int samplingCheck;
	private String inspectioinSpecialRequest;
	private String inspectionRequestApproval;
	private String requestedInspectionCompleteDate;
	private String inspectionRequestDate;
	private String inspectionRequestApprovalDate;
	private String qualityInspectionRequestRegDate;
	private String qualityInspectionRequestUpdateDate;
	
	public String getQualityInspectionRequestCode() {
		return qualityInspectionRequestCode;
	}
	public void setQualityInspectionRequestCode(String qualityInspectionRequestCode) {
		this.qualityInspectionRequestCode = qualityInspectionRequestCode;
	}
	public String getRequestedProductCode() {
		return requestedProductCode;
	}
	public void setRequestedProductCode(String requestedProductCode) {
		this.requestedProductCode = requestedProductCode;
	}
	public String getQualityInspectionRequestEmployeeCode() {
		return qualityInspectionRequestEmployeeCode;
	}
	public void setQualityInspectionRequestEmployeeCode(String qualityInspectionRequestEmployeeCode) {
		this.qualityInspectionRequestEmployeeCode = qualityInspectionRequestEmployeeCode;
	}
	public String getQualityInspectionRequestApprovedEmployeeCode() {
		return qualityInspectionRequestApprovedEmployeeCode;
	}
	public void setQualityInspectionRequestApprovedEmployeeCode(String qualityInspectionRequestApprovedEmployeeCode) {
		this.qualityInspectionRequestApprovedEmployeeCode = qualityInspectionRequestApprovedEmployeeCode;
	}
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
	public int getSamplingCheck() {
		return samplingCheck;
	}
	public void setSamplingCheck(int samplingCheck) {
		this.samplingCheck = samplingCheck;
	}
	public String getInspectioinSpecialRequest() {
		return inspectioinSpecialRequest;
	}
	public void setInspectioinSpecialRequest(String inspectioinSpecialRequest) {
		this.inspectioinSpecialRequest = inspectioinSpecialRequest;
	}
	public String getInspectionRequestApproval() {
		return inspectionRequestApproval;
	}
	public void setInspectionRequestApproval(String inspectionRequestApproval) {
		this.inspectionRequestApproval = inspectionRequestApproval;
	}
	public String getRequestedInspectionCompleteDate() {
		return requestedInspectionCompleteDate;
	}
	public void setRequestedInspectionCompleteDate(String requestedInspectionCompleteDate) {
		this.requestedInspectionCompleteDate = requestedInspectionCompleteDate;
	}
	public String getInspectionRequestDate() {
		return inspectionRequestDate;
	}
	public void setInspectionRequestDate(String inspectionRequestDate) {
		this.inspectionRequestDate = inspectionRequestDate;
	}
	public String getInspectionRequestApprovalDate() {
		return inspectionRequestApprovalDate;
	}
	public void setInspectionRequestApprovalDate(String inspectionRequestApprovalDate) {
		this.inspectionRequestApprovalDate = inspectionRequestApprovalDate;
	}
	public String getQualityInspectionRequestRegDate() {
		return qualityInspectionRequestRegDate;
	}
	public void setQualityInspectionRequestRegDate(String qualityInspectionRequestRegDate) {
		this.qualityInspectionRequestRegDate = qualityInspectionRequestRegDate;
	}
	public String getQualityInspectionRequestUpdateDate() {
		return qualityInspectionRequestUpdateDate;
	}
	public void setQualityInspectionRequestUpdateDate(String qualityInspectionRequestUpdateDate) {
		this.qualityInspectionRequestUpdateDate = qualityInspectionRequestUpdateDate;
	}
	
	@Override
	public String toString() {
		return "QualityInspectionRequest [qualityInspectionRequestCode=" + qualityInspectionRequestCode
				+ ", requestedProductCode=" + requestedProductCode + ", qualityInspectionRequestEmployeeCode="
				+ qualityInspectionRequestEmployeeCode + ", qualityInspectionRequestApprovedEmployeeCode="
				+ qualityInspectionRequestApprovedEmployeeCode + ", rawMaterialCode=" + rawMaterialCode
				+ ", qualityInspectionCode=" + qualityInspectionCode + ", samplingCheck=" + samplingCheck
				+ ", inspectioinSpecialRequest=" + inspectioinSpecialRequest + ", inspectionRequestApproval="
				+ inspectionRequestApproval + ", requestedInspectionCompleteDate=" + requestedInspectionCompleteDate
				+ ", inspectionRequestDate=" + inspectionRequestDate + ", inspectionRequestApprovalDate="
				+ inspectionRequestApprovalDate + ", qualityInspectionRequestRegDate=" + qualityInspectionRequestRegDate
				+ ", qualityInspectionRequestUpdateDate=" + qualityInspectionRequestUpdateDate + "]";
	}
	
}
