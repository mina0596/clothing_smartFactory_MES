package ksmart39.springboot.domain;

public class ProductionPlan {
	private String productionPlanCode;
	private String productCode;
	private String chargeEmployeeCode;
	private int productionPlanQuantity;
	private String productionPlanQantityUnit;
	private String expectedProductionStartDate;
	private String expectedProductionEndDate;
	private String productionPlanPeriod;
	private String productionPlanNote;
	private String productionPlanRegDate;
	private String productionPlanUpdateDate;
	
	
	public String getProductionPlanCode() {
		return productionPlanCode;
	}
	public void setProductionPlanCode(String productionPlanCode) {
		this.productionPlanCode = productionPlanCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getChargeEmployeeCode() {
		return chargeEmployeeCode;
	}
	public void setChargeEmployeeCode(String chargeEmployeeCode) {
		this.chargeEmployeeCode = chargeEmployeeCode;
	}
	public int getProductionPlanQuantity() {
		return productionPlanQuantity;
	}
	public void setProductionPlanQuantity(int productionPlanQuantity) {
		this.productionPlanQuantity = productionPlanQuantity;
	}
	public String getProductionPlanQantityUnit() {
		return productionPlanQantityUnit;
	}
	public void setProductionPlanQantityUnit(String productionPlanQantityUnit) {
		this.productionPlanQantityUnit = productionPlanQantityUnit;
	}
	public String getExpectedProductionStartDate() {
		return expectedProductionStartDate;
	}
	public void setExpectedProductionStartDate(String expectedProductionStartDate) {
		this.expectedProductionStartDate = expectedProductionStartDate;
	}
	public String getExpectedProductionEndDate() {
		return expectedProductionEndDate;
	}
	public void setExpectedProductionEndDate(String expectedProductionEndDate) {
		this.expectedProductionEndDate = expectedProductionEndDate;
	}
	public String getProductionPlanPeriod() {
		return productionPlanPeriod;
	}
	public void setProductionPlanPeriod(String productionPlanPeriod) {
		this.productionPlanPeriod = productionPlanPeriod;
	}
	public String getProductionPlanNote() {
		return productionPlanNote;
	}
	public void setProductionPlanNote(String productionPlanNote) {
		this.productionPlanNote = productionPlanNote;
	}
	public String getProductionPlanRegDate() {
		return productionPlanRegDate;
	}
	public void setProductionPlanRegDate(String productionPlanRegDate) {
		this.productionPlanRegDate = productionPlanRegDate;
	}
	public String getProductionPlanUpdateDate() {
		return productionPlanUpdateDate;
	}
	public void setProductionPlanUpdateDate(String productionPlanUpdateDate) {
		this.productionPlanUpdateDate = productionPlanUpdateDate;
	}
	
	
	@Override
	public String toString() {
		return "ProductionPlan [productionPlanCode=" + productionPlanCode + ", productCode=" + productCode
				+ ", chargeEmployeeCode=" + chargeEmployeeCode + ", productionPlanQuantity=" + productionPlanQuantity
				+ ", productionPlanQantityUnit=" + productionPlanQantityUnit + ", expectedProductionStartDate="
				+ expectedProductionStartDate + ", expectedProductionEndDate=" + expectedProductionEndDate
				+ ", productionPlanPeriod=" + productionPlanPeriod + ", productionPlanNote=" + productionPlanNote
				+ ", productionPlanRegDate=" + productionPlanRegDate + ", productionPlanUpdateDate="
				+ productionPlanUpdateDate + "]";
	}
	
	
	
}
