package ksmart39.springboot.domain;

public class ProductProductionProcessStatus {
	private String productProductionProcessStatusCode;
	private String productionProcessCode;
	private String requestedProductCode;
	private String processStartDate;
	private String completedProductUpdateDate;
	private String processStatus;
	private String productionProcessStatusRegDate;
	private String productionProcessStatusUpdateDate;
	
	private RequestedProduct requestedProduct;
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getProductProductionProcessStatusCode() {
		return productProductionProcessStatusCode;
	}

	public void setProductProductionProcessStatusCode(String productProductionProcessStatusCode) {
		this.productProductionProcessStatusCode = productProductionProcessStatusCode;
	}

	public String getProductionProcessCode() {
		return productionProcessCode;
	}

	public void setProductionProcessCode(String productionProcessCode) {
		this.productionProcessCode = productionProcessCode;
	}

	public String getRequestedProductCode() {
		return requestedProductCode;
	}

	public void setRequestedProductCode(String requestedProductCode) {
		this.requestedProductCode = requestedProductCode;
	}

	public String getProcessStartDate() {
		return processStartDate;
	}

	public void setProcessStartDate(String processStartDate) {
		this.processStartDate = processStartDate;
	}

	public String getCompletedProductUpdateDate() {
		return completedProductUpdateDate;
	}

	public void setCompletedProductUpdateDate(String completedProductUpdateDate) {
		this.completedProductUpdateDate = completedProductUpdateDate;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public String getProductionProcessStatusRegDate() {
		return productionProcessStatusRegDate;
	}

	public void setProductionProcessStatusRegDate(String productionProcessStatusRegDate) {
		this.productionProcessStatusRegDate = productionProcessStatusRegDate;
	}

	public String getProductionProcessStatusUpdateDate() {
		return productionProcessStatusUpdateDate;
	}

	public void setProductionProcessStatusUpdateDate(String productionProcessStatusUpdateDate) {
		this.productionProcessStatusUpdateDate = productionProcessStatusUpdateDate;
	}

	public RequestedProduct getRequestedProduct() {
		return requestedProduct;
	}

	public void setRequestedProduct(RequestedProduct requestedProduct) {
		this.requestedProduct = requestedProduct;
	}

	@Override
	public String toString() {
		return "ProductProductionProcessStatus [productProductionProcessStatusCode="
				+ productProductionProcessStatusCode + ", productionProcessCode=" + productionProcessCode
				+ ", requestedProductCode=" + requestedProductCode + ", processStartDate=" + processStartDate
				+ ", completedProductUpdateDate=" + completedProductUpdateDate + ", processStatus=" + processStatus
				+ ", productionProcessStatusRegDate=" + productionProcessStatusRegDate
				+ ", productionProcessStatusUpdateDate=" + productionProcessStatusUpdateDate + ", requestedProduct="
				+ requestedProduct + ", client=" + client + "]";
	}

	
	
	
}
