package ksmart39.springboot.domain;

public class QualityInspectionFinalResult {
	private String finalResultCode;
	private String qualityInspectionResquestCode;
	private String chargeEmployeeCode;
	private String qualityInspectionCode;
	private String lowCateFinalPassCheck;
	private String inspectionStratDate;
	private int inspectiondDuration;
	private String inspectionEnddate;
	private String finalResutlRegDate;
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
	public String getQualityInspectionResquestCode() {
		return qualityInspectionResquestCode;
	}
	public void setQualityInspectionResquestCode(String qualityInspectionResquestCode) {
		this.qualityInspectionResquestCode = qualityInspectionResquestCode;
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
	public String getInspectionStratDate() {
		return inspectionStratDate;
	}
	public void setInspectionStratDate(String inspectionStratDate) {
		this.inspectionStratDate = inspectionStratDate;
	}
	public int getInspectiondDuration() {
		return inspectiondDuration;
	}
	public void setInspectiondDuration(int inspectiondDuration) {
		this.inspectiondDuration = inspectiondDuration;
	}
	public String getInspectionEnddate() {
		return inspectionEnddate;
	}
	public void setInspectionEnddate(String inspectionEnddate) {
		this.inspectionEnddate = inspectionEnddate;
	}
	public String getFinalResutlRegDate() {
		return finalResutlRegDate;
	}
	public void setFinalResutlRegDate(String finalResutlRegDate) {
		this.finalResutlRegDate = finalResutlRegDate;
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
		return "InspectionFinalResult [finalResultCode=" + finalResultCode + ", qualityInspectionResquestCode="
				+ qualityInspectionResquestCode + ", chargeEmployeeCode=" + chargeEmployeeCode
				+ ", qualityInspectionCode=" + qualityInspectionCode + ", lowCateFinalPassCheck="
				+ lowCateFinalPassCheck + ", inspectionStratDate=" + inspectionStratDate + ", inspectiondDuration="
				+ inspectiondDuration + ", inspectionEnddate=" + inspectionEnddate + ", finalResutlRegDate="
				+ finalResutlRegDate + ", finalResultUpdateDate=" + finalResultUpdateDate + ", requestedProduct="
				+ requestedProduct + ", qualityInspectionResult=" + qualityInspectionResult + ", mediumClassInspection="
				+ mediumClassInspection + ", lowClassInspection=" + lowClassInspection + ", subClassInspection="
				+ subClassInspection + ", humanResources=" + humanResources + "]";
	}
	
	
	

}
