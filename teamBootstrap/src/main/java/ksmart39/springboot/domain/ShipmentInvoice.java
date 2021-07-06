package ksmart39.springboot.domain;

public class ShipmentInvoice {
	private  int shipmentInvoiceCode;
	private String shipmentOrderGroupCode;
	private String clientCode;
	private String chargeEmployeeCode;
	private String shippingDate;
	private String shipmentInvoiceRegDate;
	private String shipmentInvoiceUpdateDate;
	
	private ShipmentOrder shipmentOrder;
	private Client client;
	private HumanResources humanResources;
	public int getShipmentInvoiceCode() {
		return shipmentInvoiceCode;
	}
	public void setShipmentInvoiceCode(int shipmentInvoiceCode) {
		this.shipmentInvoiceCode = shipmentInvoiceCode;
	}
	public String getShipmentOrderGroupCode() {
		return shipmentOrderGroupCode;
	}
	public void setShipmentOrderGroupCode(String shipmentOrderGroupCode) {
		this.shipmentOrderGroupCode = shipmentOrderGroupCode;
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
	public String getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(String shippingDate) {
		this.shippingDate = shippingDate;
	}
	public String getShipmentInvoiceRegDate() {
		return shipmentInvoiceRegDate;
	}
	public void setShipmentInvoiceRegDate(String shipmentInvoiceRegDate) {
		this.shipmentInvoiceRegDate = shipmentInvoiceRegDate;
	}
	public String getShipmentInvoiceUpdateDate() {
		return shipmentInvoiceUpdateDate;
	}
	public void setShipmentInvoiceUpdateDate(String shipmentInvoiceUpdateDate) {
		this.shipmentInvoiceUpdateDate = shipmentInvoiceUpdateDate;
	}
	public ShipmentOrder getShipmentOrder() {
		return shipmentOrder;
	}
	public void setShipmentOrder(ShipmentOrder shipmentOrder) {
		this.shipmentOrder = shipmentOrder;
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
		return "ShipmentInvoice [shipmentInvoiceCode=" + shipmentInvoiceCode + ", shipmentOrderGroupCode="
				+ shipmentOrderGroupCode + ", clientCode=" + clientCode + ", chargeEmployeeCode=" + chargeEmployeeCode
				+ ", shippingDate=" + shippingDate + ", shipmentInvoiceRegDate=" + shipmentInvoiceRegDate
				+ ", shipmentInvoiceUpdateDate=" + shipmentInvoiceUpdateDate + ", shipmentOrder=" + shipmentOrder
				+ ", client=" + client + ", humanResources=" + humanResources + "]";
	}
	
}
