package ksmart39.springboot.domain;

public class RequestedProductSize {
	private String requestedProductCode;
	private String requiredSizeCode;
	private String chargedEmployeeCode;
	private int measuredValue;
	private String requiredSizeRegDate;
	private String requiredSizeUpdateDate;
	public String getRequestedProductCode() {
		return requestedProductCode;
	}
	public void setRequestedProductCode(String requestedProductCode) {
		this.requestedProductCode = requestedProductCode;
	}
	public String getRequiredSizeCode() {
		return requiredSizeCode;
	}
	public void setRequiredSizeCode(String requiredSizeCode) {
		this.requiredSizeCode = requiredSizeCode;
	}
	public String getChargedEmployeeCode() {
		return chargedEmployeeCode;
	}
	public void setChargedEmployeeCode(String chargedEmployeeCode) {
		this.chargedEmployeeCode = chargedEmployeeCode;
	}
	public int getMeasuredValue() {
		return measuredValue;
	}
	public void setMeasuredValue(int measuredValue) {
		this.measuredValue = measuredValue;
	}
	public String getRequiredSizeRegDate() {
		return requiredSizeRegDate;
	}
	public void setRequiredSizeRegDate(String requiredSizeRegDate) {
		this.requiredSizeRegDate = requiredSizeRegDate;
	}
	public String getRequiredSizeUpdateDate() {
		return requiredSizeUpdateDate;
	}
	public void setRequiredSizeUpdateDate(String requiredSizeUpdateDate) {
		this.requiredSizeUpdateDate = requiredSizeUpdateDate;
	}
	@Override
	public String toString() {
		return "RequestedProductSize [requestedProductCode=" + requestedProductCode + ", requiredSizeCode="
				+ requiredSizeCode + ", chargedEmployeeCode=" + chargedEmployeeCode + ", measuredValue=" + measuredValue
				+ ", requiredSizeRegDate=" + requiredSizeRegDate + ", requiredSizeUpdateDate=" + requiredSizeUpdateDate
				+ "]";
	}
	
	
}
