package ksmart39.springboot.domain;

public class ShipmentOrder {
	private String shipmentOrderCode;
	private String requestProductCode;
	private String chargeEmployeeCode;
	private String shipmentOrderGroupCode;
	private String shipmentOrderDate;
	private String shipmentOrderContractState;
	private String shipmentOderRegDate;
	private String shimpentOrderUpdateDate;
	
//private requestProductCode 클래스생성되면가지고오기
	private HumanResources humanResources;

	public String getShipmentOrderCode() {
		return shipmentOrderCode;
	}

	public void setShipmentOrderCode(String shipmentOrderCode) {
		this.shipmentOrderCode = shipmentOrderCode;
	}

	public String getRequestProductCode() {
		return requestProductCode;
	}

	public void setRequestProductCode(String requestProductCode) {
		this.requestProductCode = requestProductCode;
	}

	public String getChargeEmployeeCode() {
		return chargeEmployeeCode;
	}

	public void setChargeEmployeeCode(String chargeEmployeeCode) {
		this.chargeEmployeeCode = chargeEmployeeCode;
	}

	public String getShipmentOrderGroupCode() {
		return shipmentOrderGroupCode;
	}

	public void setShipmentOrderGroupCode(String shipmentOrderGroupCode) {
		this.shipmentOrderGroupCode = shipmentOrderGroupCode;
	}

	public String getShipmentOrderDate() {
		return shipmentOrderDate;
	}

	public void setShipmentOrderDate(String shipmentOrderDate) {
		this.shipmentOrderDate = shipmentOrderDate;
	}

	public String getShipmentOrderContractState() {
		return shipmentOrderContractState;
	}

	public void setShipmentOrderContractState(String shipmentOrderContractState) {
		this.shipmentOrderContractState = shipmentOrderContractState;
	}

	public String getShipmentOderRegDate() {
		return shipmentOderRegDate;
	}

	public void setShipmentOderRegDate(String shipmentOderRegDate) {
		this.shipmentOderRegDate = shipmentOderRegDate;
	}

	public String getShimpentOrderUpdateDate() {
		return shimpentOrderUpdateDate;
	}

	public void setShimpentOrderUpdateDate(String shimpentOrderUpdateDate) {
		this.shimpentOrderUpdateDate = shimpentOrderUpdateDate;
	}

	public HumanResources getHumanResources() {
		return humanResources;
	}

	public void setHumanResources(HumanResources humanResources) {
		this.humanResources = humanResources;
	}

	@Override
	public String toString() {
		return "ShipmentOrder [shipmentOrderCode=" + shipmentOrderCode + ", requestProductCode=" + requestProductCode
				+ ", chargeEmployeeCode=" + chargeEmployeeCode + ", shipmentOrderGroupCode=" + shipmentOrderGroupCode
				+ ", shipmentOrderDate=" + shipmentOrderDate + ", shipmentOrderContractState="
				+ shipmentOrderContractState + ", shipmentOderRegDate=" + shipmentOderRegDate
				+ ", shimpentOrderUpdateDate=" + shimpentOrderUpdateDate + ", humanResources=" + humanResources + "]";
	}
	

}
