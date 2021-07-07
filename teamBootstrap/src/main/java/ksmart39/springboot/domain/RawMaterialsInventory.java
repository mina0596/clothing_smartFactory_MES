package ksmart39.springboot.domain;

public class RawMaterialsInventory {
	private String materialCode;
	private String materialOrderCode;
	private String chargeEmployeeCode;
	private String transactionCate;
	private int transactionAmount;
	private String transactionDate;
	private String transactionRegDate;
	private String transactionUpdateDate;
	
	private RawMaterials materialsInfo;
	
	
	
	public RawMaterials getMaterialsInfo() {
		return materialsInfo;
	}
	public void setMaterialsInfo(RawMaterials materialsInfo) {
		this.materialsInfo = materialsInfo;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public String getMaterialOrderCode() {
		return materialOrderCode;
	}
	public void setMaterialOrderCode(String materialOrderCode) {
		this.materialOrderCode = materialOrderCode;
	}
	public String getChargeEmployeeCode() {
		return chargeEmployeeCode;
	}
	public void setChargeEmployeeCode(String chargeEmployeeCode) {
		this.chargeEmployeeCode = chargeEmployeeCode;
	}
	public String getTransactionCate() {
		return transactionCate;
	}
	public void setTransactionCate(String transactionCate) {
		this.transactionCate = transactionCate;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionRegDate() {
		return transactionRegDate;
	}
	public void setTransactionRegDate(String transactionRegDate) {
		this.transactionRegDate = transactionRegDate;
	}
	public String getTransactionUpdateDate() {
		return transactionUpdateDate;
	}
	public void setTransactionUpdateDate(String transactionUpdateDate) {
		this.transactionUpdateDate = transactionUpdateDate;
	}
	@Override
	public String toString() {
		return "RawMaterialsInventory [materialCode=" + materialCode + ", materialOrderCode=" + materialOrderCode
				+ ", chargeEmployeeCode=" + chargeEmployeeCode + ", transactionCate=" + transactionCate
				+ ", transactionAmount=" + transactionAmount + ", transactionDate=" + transactionDate
				+ ", transactionRegDate=" + transactionRegDate + ", transactionUpdateDate=" + transactionUpdateDate
				+ ", materialsInfo=" + materialsInfo + "]";
	}
	
	
	
}
