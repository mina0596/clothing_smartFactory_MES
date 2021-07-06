package ksmart39.springboot.domain;

public class ContractInfo {
	private String  contractNum;
	private String chargeEmployeeCode;
	private String  contractedUnit;
	private int  contractedAmount;
	private String contractedPaymentTerm;
	private String contractDate;
	private int 	contractTotalPayment;
	private String contractStartDate;
	private String contractEndDate;
	private String contractInfoRegDate;
	private String contractInfoUpdateDate;
	
	private HumanResources humanResources;

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getChargeEmployeeCode() {
		return chargeEmployeeCode;
	}

	public void setChargeEmployeeCode(String chargeEmployeeCode) {
		this.chargeEmployeeCode = chargeEmployeeCode;
	}

	public String getContractedUnit() {
		return contractedUnit;
	}

	public void setContractedUnit(String contractedUnit) {
		this.contractedUnit = contractedUnit;
	}

	public int getContractedAmount() {
		return contractedAmount;
	}

	public void setContractedAmount(int contractedAmount) {
		this.contractedAmount = contractedAmount;
	}

	public String getContractedPaymentTerm() {
		return contractedPaymentTerm;
	}

	public void setContractedPaymentTerm(String contractedPaymentTerm) {
		this.contractedPaymentTerm = contractedPaymentTerm;
	}

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public int getContractTotalPayment() {
		return contractTotalPayment;
	}

	public void setContractTotalPayment(int contractTotalPayment) {
		this.contractTotalPayment = contractTotalPayment;
	}

	public String getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public String getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getContractInfoRegDate() {
		return contractInfoRegDate;
	}

	public void setContractInfoRegDate(String contractInfoRegDate) {
		this.contractInfoRegDate = contractInfoRegDate;
	}

	public String getContractInfoUpdateDate() {
		return contractInfoUpdateDate;
	}

	public void setContractInfoUpdateDate(String contractInfoUpdateDate) {
		this.contractInfoUpdateDate = contractInfoUpdateDate;
	}

	public HumanResources getHumanResources() {
		return humanResources;
	}

	public void setHumanResources(HumanResources humanResources) {
		this.humanResources = humanResources;
	}

	@Override
	public String toString() {
		return "ContractInfo [contractNum=" + contractNum + ", chargeEmployeeCode=" + chargeEmployeeCode
				+ ", contractedUnit=" + contractedUnit + ", contractedAmount=" + contractedAmount
				+ ", contractedPaymentTerm=" + contractedPaymentTerm + ", contractDate=" + contractDate
				+ ", contractTotalPayment=" + contractTotalPayment + ", contractStartDate=" + contractStartDate
				+ ", contractEndDate=" + contractEndDate + ", contractInfoRegDate=" + contractInfoRegDate
				+ ", contractInfoUpdateDate=" + contractInfoUpdateDate + ", humanResources=" + humanResources + "]";
	}


	
	
	
	
	

}
