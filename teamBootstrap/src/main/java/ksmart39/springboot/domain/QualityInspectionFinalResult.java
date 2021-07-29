package ksmart39.springboot.domain;

public class QualityInspectionFinalResult {
	private String finalResultCode;
	private String qualityInspectionRequestCode;
	private String chargeEmployeeCode;
	private String qualityInspectionCode;
	private String lowCateFinalPassCheck;
	private String inspectionStartDate;
	private int inspectionDuration;
	private String inspectionEndDate;
	private String finalResultRegDate;
	private String finalResultUpdateDate;
	
	
	private RequestedProduct requestedProduct;
	private QualityInspectionResult qualityInspectionResult;
	private MediumClassInspection mediumClassInspection;
	private LowClassInspection lowClassInspection;
	private SubClassInspection subClassInspection;
	private HumanResources humanResources;
	public String getFinalResultCode() {
		return finalResultCode;
	}
	public void setFinalResultCode(String finalResultCode) {
		this.finalResultCode = finalResultCode;
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
	public String getLowCateFinalPassCheck() {
		return lowCateFinalPassCheck;
	}
	public void setLowCateFinalPassCheck(String lowCateFinalPassCheck) {
		this.lowCateFinalPassCheck = lowCateFinalPassCheck;
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
	public String getFinalResultRegDate() {
		return finalResultRegDate;
	}
	public void setFinalResultRegDate(String finalResultRegDate) {
		this.finalResultRegDate = finalResultRegDate;
	}
	public String getFinalResultUpdateDate() {
		return finalResultUpdateDate;
	}
	public void setFinalResultUpdateDate(String finalResultUpdateDate) {
		this.finalResultUpdateDate = finalResultUpdateDate;
	}
	public RequestedProduct getRequestedProduct() {
		return requestedProduct;
	}
	public void setRequestedProduct(RequestedProduct requestedProduct) {
		this.requestedProduct = requestedProduct;
	}
	public QualityInspectionResult getQualityInspectionResult() {
		return qualityInspectionResult;
	}
	public void setQualityInspectionResult(QualityInspectionResult qualityInspectionResult) {
		this.qualityInspectionResult = qualityInspectionResult;
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
	public SubClassInspection getSubClassInspection() {
		return subClassInspection;
	}
	public void setSubClassInspection(SubClassInspection subClassInspection) {
		this.subClassInspection = subClassInspection;
	}
	public HumanResources getHumanResources() {
		return humanResources;
	}
	public void setHumanResources(HumanResources humanResources) {
		this.humanResources = humanResources;
	}
	@Override
	public String toString() {
		return "QualityInspectionFinalResult [finalResultCode=" + finalResultCode + ", qualityInspectionRequestCode="
				+ qualityInspectionRequestCode + ", chargeEmployeeCode=" + chargeEmployeeCode
				+ ", qualityInspectionCode=" + qualityInspectionCode + ", lowCateFinalPassCheck="
				+ lowCateFinalPassCheck + ", inspectionStartDate=" + inspectionStartDate + ", inspectionDuration="
				+ inspectionDuration + ", inspectionEndDate=" + inspectionEndDate + ", finalResultRegDate="
				+ finalResultRegDate + ", finalResultUpdateDate=" + finalResultUpdateDate + ", requestedProduct="
				+ requestedProduct + ", qualityInspectionResult=" + qualityInspectionResult + ", mediumClassInspection="
				+ mediumClassInspection + ", lowClassInspection=" + lowClassInspection + ", subClassInspection="
				+ subClassInspection + ", humanResources=" + humanResources + "]";
	}
	
	

}
