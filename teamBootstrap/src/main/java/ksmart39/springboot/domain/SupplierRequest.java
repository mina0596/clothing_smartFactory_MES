package ksmart39.springboot.domain;

public class SupplierRequest {
	private String rawMeterialOrderCode;
	private String rawMeterialCode;
	private String clientCode;
	private String chargeEmployeeCode;
	private String supplierContractCode;
	private int rawMeterialOrderAmount;
	private String rawMeterialOrderApproval;
	private String rawMeterialOrderDate;
	private String rawMeterialExpectedDate;
	private String rawMeterialOrderRegDate;
	private String rawMeterialOrderUpdateDate;
	
	private RawMaterials rawMaterials;
	private Client client;
	private HumanResources humanResources;
	
	public String getRawMeterialOrderCode() {
		return rawMeterialOrderCode;
	}
	public void setRawMeterialOrderCode(String rawMeterialOrderCode) {
		this.rawMeterialOrderCode = rawMeterialOrderCode;
	}
	public String getRawMeterialCode() {
		return rawMeterialCode;
	}
	public void setRawMeterialCode(String rawMeterialCode) {
		this.rawMeterialCode = rawMeterialCode;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getChargeEmployeeCode() {
		return chargeEmployeeCode;
	}
	public void setChargeEmployeeCode(String chargeEmployeeCode) {
		this.chargeEmployeeCode = chargeEmployeeCode;
	}
	public String getSupplierContractCode() {
		return supplierContractCode;
	}
	public void setSupplierContractCode(String supplierContractCode) {
		this.supplierContractCode = supplierContractCode;
	}
	public int getRawMeterialOrderAmount() {
		return rawMeterialOrderAmount;
	}
	public void setRawMeterialOrderAmount(int rawMeterialOrderAmount) {
		this.rawMeterialOrderAmount = rawMeterialOrderAmount;
	}
	public String getRawMeterialOrderApproval() {
		return rawMeterialOrderApproval;
	}
	public void setRawMeterialOrderApproval(String rawMeterialOrderApproval) {
		this.rawMeterialOrderApproval = rawMeterialOrderApproval;
	}
	public String getRawMeterialOrderDate() {
		return rawMeterialOrderDate;
	}
	public void setRawMeterialOrderDate(String rawMeterialOrderDate) {
		this.rawMeterialOrderDate = rawMeterialOrderDate;
	}
	public String getRawMeterialExpectedDate() {
		return rawMeterialExpectedDate;
	}
	public void setRawMeterialExpectedDate(String rawMeterialExpectedDate) {
		this.rawMeterialExpectedDate = rawMeterialExpectedDate;
	}
	public String getRawMeterialOrderRegDate() {
		return rawMeterialOrderRegDate;
	}
	public void setRawMeterialOrderRegDate(String rawMeterialOrderRegDate) {
		this.rawMeterialOrderRegDate = rawMeterialOrderRegDate;
	}
	public String getRawMeterialOrderUpdateDate() {
		return rawMeterialOrderUpdateDate;
	}
	public void setRawMeterialOrderUpdateDate(String rawMeterialOrderUpdateDate) {
		this.rawMeterialOrderUpdateDate = rawMeterialOrderUpdateDate;
	}
	public RawMaterials getRawMaterials() {
		return rawMaterials;
	}
	public void setRawMaterials(RawMaterials rawMaterials) {
		this.rawMaterials = rawMaterials;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public HumanResources getHumanResources() {
		return humanResources;
	}
	public void setHumanResources(HumanResources humanResources) {
		this.humanResources = humanResources;
	}
	@Override
	public String toString() {
		return "SupplierRequest [rawMeterialOrderCode=" + rawMeterialOrderCode + ", rawMeterialCode=" + rawMeterialCode
				+ ", clientCode=" + clientCode + ", chargeEmployeeCode=" + chargeEmployeeCode
				+ ", supplierContractCode=" + supplierContractCode + ", rawMeterialOrderAmount="
				+ rawMeterialOrderAmount + ", rawMeterialOrderApproval=" + rawMeterialOrderApproval
				+ ", rawMeterialOrderDate=" + rawMeterialOrderDate + ", rawMeterialExpectedDate="
				+ rawMeterialExpectedDate + ", rawMeterialOrderRegDate=" + rawMeterialOrderRegDate
				+ ", rawMeterialOrderUpdateDate=" + rawMeterialOrderUpdateDate + ", rawMaterials=" + rawMaterials
				+ ", client=" + client + ", humanResources=" + humanResources + "]";
	}
	
	
	

}
