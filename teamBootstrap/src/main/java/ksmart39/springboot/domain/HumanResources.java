package ksmart39.springboot.domain;

public class HumanResources {
	private String employeeCode;
	private String levelNum;
	private String employeeId;
	private String employeePw;
	private String employeeName;
	private String employeeTel;
	private String employeeAddress;
	private String employeeEmail;
	private String employeeDepartment;
	private String employeePosition;
	private String employeeInfoRegDate;
	private String employeeInfoUpdateDate;
	
	private HumanResourcesLevel humanResourcesLevel;
	
	public HumanResourcesLevel getHumanResourcesLevel() {
		return humanResourcesLevel;
	}
	public void setHumanResourcesLevel(HumanResourcesLevel humanResourcesLevel) {
		this.humanResourcesLevel = humanResourcesLevel;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(String levelNum) {
		this.levelNum = levelNum;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeePw() {
		return employeePw;
	}
	public void setEmployeePw(String employeePw) {
		this.employeePw = employeePw;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeTel() {
		return employeeTel;
	}
	public void setEmployeeTel(String employeeTel) {
		this.employeeTel = employeeTel;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public String getEmployeePosition() {
		return employeePosition;
	}
	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}
	public String getEmployeeInfoRegDate() {
		return employeeInfoRegDate;
	}
	public void setEmployeeInfoRegDate(String employeeInfoRegDate) {
		this.employeeInfoRegDate = employeeInfoRegDate;
	}
	public String getEmployeeInfoUpdateDate() {
		return employeeInfoUpdateDate;
	}
	public void setEmployeeInfoUpdateDate(String employeeInfoUpdateDate) {
		this.employeeInfoUpdateDate = employeeInfoUpdateDate;
	}
	
	@Override
	public String toString() {
		return "HumanResources [employeeCode=" + employeeCode + ", levelNum=" + levelNum + ", employeeId=" + employeeId
				+ ", employeePw=" + employeePw + ", employeeName=" + employeeName + ", employeeTel=" + employeeTel
				+ ", employeeAddress=" + employeeAddress + ", employeeEmail=" + employeeEmail + ", employeeDepartment="
				+ employeeDepartment + ", employeePosition=" + employeePosition + ", employeeInfoRegDate="
				+ employeeInfoRegDate + ", employeeInfoUpdateDate=" + employeeInfoUpdateDate + ", humanResourcesLevel="
				+ humanResourcesLevel + "]";
	}
	
}
