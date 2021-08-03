package ksmart39.springboot.domain;

public class RequestedProduct {
	private String requestedProductCode;
	private String productCode;
	private String chargeEmployeeCode;
	private String clientCode;
	private String contractCode;
	private String productRequestCode;
	private String designDrawingAttachment;
	private String requestedDueDate;
	private String requestedDeliveryAddress;
	private String requestedDeliveryTel;
	private String requestedSpecialNote;
	private String approvalStatus;
	private String requestedProductDetailRegDate;
	private String requestedProductDetailUpdateDate;
	
	private RequestedProductSize requestedProductSize;
	
	private Client client;
	
	public String getRequestedProductCode() {
		return requestedProductCode;
	}
	public void setRequestedProductCode(String requestedProductCode) {
		this.requestedProductCode = requestedProductCode;
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
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getProductRequestCode() {
		return productRequestCode;
	}
	public void setProductRequestCode(String productRequestCode) {
		this.productRequestCode = productRequestCode;
	}
	public String getDesignDrawingAttachment() {
		return designDrawingAttachment;
	}
	public void setDesignDrawingAttachment(String designDrawingAttachment) {
		this.designDrawingAttachment = designDrawingAttachment;
	}
	public String getRequestedDueDate() {
		return requestedDueDate;
	}
	public void setRequestedDueDate(String requestedDueDate) {
		this.requestedDueDate = requestedDueDate;
	}
	public String getRequestedDeliveryAddress() {
		return requestedDeliveryAddress;
	}
	public void setRequestedDeliveryAddress(String requestedDeliveryAddress) {
		this.requestedDeliveryAddress = requestedDeliveryAddress;
	}
	public String getRequestedDeliveryTel() {
		return requestedDeliveryTel;
	}
	public void setRequestedDeliveryTel(String requestedDeliveryTel) {
		this.requestedDeliveryTel = requestedDeliveryTel;
	}
	public String getRequestedSpecialNote() {
		return requestedSpecialNote;
	}
	public void setRequestedSpecialNote(String requestedSpecialNote) {
		this.requestedSpecialNote = requestedSpecialNote;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getRequestedProductDetailRegDate() {
		return requestedProductDetailRegDate;
	}
	public void setRequestedProductDetailRegDate(String requestedProductDetailRegDate) {
		this.requestedProductDetailRegDate = requestedProductDetailRegDate;
	}
	public String getRequestedProductDetailUpdateDate() {
		return requestedProductDetailUpdateDate;
	}
	public void setRequestedProductDetailUpdateDate(String requestedProductDetailUpdateDate) {
		this.requestedProductDetailUpdateDate = requestedProductDetailUpdateDate;
	}
	public RequestedProductSize getRequestedProductSize() {
		return requestedProductSize;
	}
	public void setRequestedProductSize(RequestedProductSize requestedProductSize) {
		this.requestedProductSize = requestedProductSize;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "RequestedProduct [requestedProductCode=" + requestedProductCode + ", productCode=" + productCode
				+ ", chargeEmployeeCode=" + chargeEmployeeCode + ", clientCode=" + clientCode + ", contractCode="
				+ contractCode + ", productRequestCode=" + productRequestCode + ", designDrawingAttachment="
				+ designDrawingAttachment + ", requestedDueDate=" + requestedDueDate + ", requestedDeliveryAddress="
				+ requestedDeliveryAddress + ", requestedDeliveryTel=" + requestedDeliveryTel
				+ ", requestedSpecialNote=" + requestedSpecialNote + ", approvalStatus=" + approvalStatus
				+ ", requestedProductDetailRegDate=" + requestedProductDetailRegDate
				+ ", requestedProductDetailUpdateDate=" + requestedProductDetailUpdateDate + ", requestedProductSize="
				+ requestedProductSize + ", client=" + client + "]";
	}
	
	
	
}
