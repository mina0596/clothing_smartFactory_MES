package ksmart39.springboot.domain;

public class CompletedProduct {
	private String requestedProductCode;
	private String productionStartDate;
	private String productionFinishDate;
	private String completedProductRegDate;
	private String completedProductUpdateDate;
	public String getRequestedProductCode() {
		return requestedProductCode;
	}
	public void setRequestedProductCode(String requestedProductCode) {
		this.requestedProductCode = requestedProductCode;
	}
	public String getProductionStartDate() {
		return productionStartDate;
	}
	public void setProductionStartDate(String productionStartDate) {
		this.productionStartDate = productionStartDate;
	}
	public String getProductionFinishDate() {
		return productionFinishDate;
	}
	public void setProductionFinishDate(String productionFinishDate) {
		this.productionFinishDate = productionFinishDate;
	}
	public String getCompletedProductRegDate() {
		return completedProductRegDate;
	}
	public void setCompletedProductRegDate(String completedProductRegDate) {
		this.completedProductRegDate = completedProductRegDate;
	}
	public String getCompletedProductUpdateDate() {
		return completedProductUpdateDate;
	}
	public void setCompletedProductUpdateDate(String completedProductUpdateDate) {
		this.completedProductUpdateDate = completedProductUpdateDate;
	}
	
	@Override
	public String toString() {
		return "CompletedProduct [requestedProductCode=" + requestedProductCode + ", productionStartDate="
				+ productionStartDate + ", productionFinishDate=" + productionFinishDate + ", completedProductRegDate="
				+ completedProductRegDate + ", completedProductUpdateDate=" + completedProductUpdateDate + "]";
	}
	
	
	
}
