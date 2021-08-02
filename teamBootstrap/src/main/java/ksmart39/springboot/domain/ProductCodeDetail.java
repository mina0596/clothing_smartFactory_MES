package ksmart39.springboot.domain;

public class ProductCodeDetail {
	private String productCode;
	private String genderCategorizedCode;
	private String genderCategorizedName;
	private String detailedCategorizedCode;
	private String detailedCategorizedName;
	private String productCodeDetailRegDate;
	private String productCodedetailUpdateDate;
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getGenderCategorizedCode() {
		return genderCategorizedCode;
	}
	public void setGenderCategorizedCode(String genderCategorizedCode) {
		this.genderCategorizedCode = genderCategorizedCode;
	}
	public String getGenderCategorizedName() {
		return genderCategorizedName;
	}
	public void setGenderCategorizedName(String genderCategorizedName) {
		this.genderCategorizedName = genderCategorizedName;
	}
	public String getDetailedCategorizedCode() {
		return detailedCategorizedCode;
	}
	public void setDetailedCategorizedCode(String detailedCategorizedCode) {
		this.detailedCategorizedCode = detailedCategorizedCode;
	}
	public String getDetailedCategorizedName() {
		return detailedCategorizedName;
	}
	public void setDetailedCategorizedName(String detailedCategorizedName) {
		this.detailedCategorizedName = detailedCategorizedName;
	}
	public String getProductCodeDetailRegDate() {
		return productCodeDetailRegDate;
	}
	public void setProductCodeDetailRegDate(String productCodeDetailRegDate) {
		this.productCodeDetailRegDate = productCodeDetailRegDate;
	}
	public String getProductCodedetailUpdateDate() {
		return productCodedetailUpdateDate;
	}
	public void setProductCodedetailUpdateDate(String productCodedetailUpdateDate) {
		this.productCodedetailUpdateDate = productCodedetailUpdateDate;
	}
	@Override
	public String toString() {
		return "ProductCodeDetail [productCode=" + productCode + ", genderCategorizedCode=" + genderCategorizedCode
				+ ", genderCategorizedName=" + genderCategorizedName + ", detailedCategorizedCode="
				+ detailedCategorizedCode + ", detailedCategorizedName=" + detailedCategorizedName
				+ ", productCodeDetailRegDate=" + productCodeDetailRegDate + ", productCodedetailUpdateDate="
				+ productCodedetailUpdateDate + "]";
	}
	

}
