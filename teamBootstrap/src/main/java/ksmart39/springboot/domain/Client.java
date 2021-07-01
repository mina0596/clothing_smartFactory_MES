package ksmart39.springboot.domain;

public class Client {
	private String clientCode;
	private String clientCategory;
	private String clientName;
	private String clientTel;
	private String clientEmployee;
	private String clientCeo;
	private String clientBusinessNum;
	private String clientAddress;
	private String clientInfoRegDate;
	private String clientInfoUpdateDate;
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getClientCategory() {
		return clientCategory;
	}
	public void setClientCategory(String clientCategory) {
		this.clientCategory = clientCategory;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientTel() {
		return clientTel;
	}
	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
	}
	public String getClientEmployee() {
		return clientEmployee;
	}
	public void setClientEmployee(String clientEmployee) {
		this.clientEmployee = clientEmployee;
	}
	public String getClientCeo() {
		return clientCeo;
	}
	public void setClientCeo(String clientCeo) {
		this.clientCeo = clientCeo;
	}
	public String getClientBusinessNum() {
		return clientBusinessNum;
	}
	public void setClientBusinessNum(String clientBusinessNum) {
		this.clientBusinessNum = clientBusinessNum;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientInfoRegDate() {
		return clientInfoRegDate;
	}
	public void setClientInfoRegDate(String clientInfoRegDate) {
		this.clientInfoRegDate = clientInfoRegDate;
	}
	public String getClientInfoUpdateDate() {
		return clientInfoUpdateDate;
	}
	public void setClientInfoUpdateDate(String clientInfoUpdateDate) {
		this.clientInfoUpdateDate = clientInfoUpdateDate;
	}
	@Override
	public String toString() {
		return "Client [clientCode=" + clientCode + ", clientCategory=" + clientCategory + ", clientName=" + clientName
				+ ", clientTel=" + clientTel + ", clientEmployee=" + clientEmployee + ", clientCeo=" + clientCeo
				+ ", clientBusinessNum=" + clientBusinessNum + ", clientAddress=" + clientAddress
				+ ", clientInfoRegDate=" + clientInfoRegDate + ", clientInfoUpdateDate=" + clientInfoUpdateDate + "]";
	}
	
}
