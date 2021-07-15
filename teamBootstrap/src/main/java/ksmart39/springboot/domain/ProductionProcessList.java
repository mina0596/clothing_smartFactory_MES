package ksmart39.springboot.domain;

public class ProductionProcessList {
	private String productionProcessCode;
	private String productionProcessHighClassification;
	private String productionProcessLowClassification;
	private String processOrderNum;
	private String productionProcessRegDate;
	private String productionProcessUpdateDate;
	
	private ProductProductionProcessStatus productProductionProcessStatus;

	public String getProductionProcessCode() {
		return productionProcessCode;
	}

	public void setProductionProcessCode(String productionProcessCode) {
		this.productionProcessCode = productionProcessCode;
	}

	public String getProductionProcessHighClassification() {
		return productionProcessHighClassification;
	}

	public void setProductionProcessHighClassification(String productionProcessHighClassification) {
		this.productionProcessHighClassification = productionProcessHighClassification;
	}

	public String getProductionProcessLowClassification() {
		return productionProcessLowClassification;
	}

	public void setProductionProcessLowClassification(String productionProcessLowClassification) {
		this.productionProcessLowClassification = productionProcessLowClassification;
	}

	public String getProcessOrderNum() {
		return processOrderNum;
	}

	public void setProcessOrderNum(String processOrderNum) {
		this.processOrderNum = processOrderNum;
	}

	public String getProductionProcessRegDate() {
		return productionProcessRegDate;
	}

	public void setProductionProcessRegDate(String productionProcessRegDate) {
		this.productionProcessRegDate = productionProcessRegDate;
	}

	public String getProductionProcessUpdateDate() {
		return productionProcessUpdateDate;
	}

	public void setProductionProcessUpdateDate(String productionProcessUpdateDate) {
		this.productionProcessUpdateDate = productionProcessUpdateDate;
	}

	public ProductProductionProcessStatus getProductProductionProcessStatus() {
		return productProductionProcessStatus;
	}

	public void setProductProductionProcessStatus(ProductProductionProcessStatus productProductionProcessStatus) {
		this.productProductionProcessStatus = productProductionProcessStatus;
	}

	@Override
	public String toString() {
		return "ProductionProcessList [productionProcessCode=" + productionProcessCode
				+ ", productionProcessHighClassification=" + productionProcessHighClassification
				+ ", productionProcessLowClassification=" + productionProcessLowClassification + ", processOrderNum="
				+ processOrderNum + ", productionProcessRegDate=" + productionProcessRegDate
				+ ", productionProcessUpdateDate=" + productionProcessUpdateDate + ", productProductionProcessStatus="
				+ productProductionProcessStatus + "]";
	}
	
	
	
}
