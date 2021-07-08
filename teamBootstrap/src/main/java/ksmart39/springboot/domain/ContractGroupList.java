package ksmart39.springboot.domain;

public class ContractGroupList {
	private int contractNum;
	private String orderGroup;
	public int getContractNum() {
		return contractNum;
	}
	public void setContractNum(int contractNum) {
		this.contractNum = contractNum;
	}
	public String getOrderGroup() {
		return orderGroup;
	}
	public void setOrderGroup(String orderGroup) {
		this.orderGroup = orderGroup;
	}
	@Override
	public String toString() {
		return "ContractGroupList [contractNum=" + contractNum + ", orderGroup=" + orderGroup + "]";
	}
	
	

}
