package ksmart39.springboot.domain;

public class WorkOrder {
	private String workOrderCode;
	private String requestedProductCode;
	private String chargeEmployeeCode;
	private String expectedProductionStartDate;
	private String expectedProductionEndDate;
	private String workOrderRegDate;
	private String workOrderUpdateDate;
	
	private RequestedProduct requestedProductInfo;
	
	private Client client;
	
	private  HumanResources humanResources;
	/*private  품목자바도 가지고와야됨**/

	
	
	public String getWorkOrderCode() {
		return workOrderCode;
	}

	public RequestedProduct getRequestedProductInfo() {
		return requestedProductInfo;
	}

	public void setRequestedProductInfo(RequestedProduct requestedProductInfo) {
		this.requestedProductInfo = requestedProductInfo;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setWorkOrderCode(String workOrderCode) {
		this.workOrderCode = workOrderCode;
	}

	public String getRequestedProductCode() {
		return requestedProductCode;
	}

	public void setRequestedProductCode(String requestedProductCode) {
		this.requestedProductCode = requestedProductCode;
	}

	public String getChargeEmployeeCode() {
		return chargeEmployeeCode;
	}

	public void setChargeEmployeeCode(String chargeEmployeeCode) {
		this.chargeEmployeeCode = chargeEmployeeCode;
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

	public String getWorkOrderRegDate() {
		return workOrderRegDate;
	}

	public void setWorkOrderRegDate(String workOrderRegDate) {
		this.workOrderRegDate = workOrderRegDate;
	}

	public String getWorkOrderUpdateDate() {
		return workOrderUpdateDate;
	}

	public void setWorkOrderUpdateDate(String workOrderUpdateDate) {
		this.workOrderUpdateDate = workOrderUpdateDate;
	}

	public HumanResources getHumanResources() {
		return humanResources;
	}

	public void setHumanResources(HumanResources humanResources) {
		this.humanResources = humanResources;
	}

	@Override
	public String toString() {
		return "WorkOrder [workOrderCode=" + workOrderCode + ", requestedProductCode=" + requestedProductCode
				+ ", chargeEmployeeCode=" + chargeEmployeeCode + ", expectedProductionStartDate="
				+ expectedProductionStartDate + ", expectedProductionEndDate=" + expectedProductionEndDate
				+ ", workOrderRegDate=" + workOrderRegDate + ", workOrderUpdateDate=" + workOrderUpdateDate
				+ ", requestedProductInfo=" + requestedProductInfo + ", client=" + client + ", humanResources="
				+ humanResources + "]";
	}

	

}
