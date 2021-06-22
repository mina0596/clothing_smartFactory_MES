package ksmart39.springboot.domain;

public class AccountingCategory {
	private String categoryCode;
	private String categoryName;
	private String categoryContent;
	private String categoryRegDate;
	private String categoryUpdateDate;
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryContent() {
		return categoryContent;
	}
	public void setCategoryContent(String categoryContent) {
		this.categoryContent = categoryContent;
	}
	public String getCategoryRegDate() {
		return categoryRegDate;
	}
	public void setCategoryRegDate(String categoryRegDate) {
		this.categoryRegDate = categoryRegDate;
	}
	public String getCategoryUpdateDate() {
		return categoryUpdateDate;
	}
	public void setCategoryUpdateDate(String categoryUpdateDate) {
		this.categoryUpdateDate = categoryUpdateDate;
	}
	
	@Override
	public String toString() {
		return "AccountingCategory [categoryCode=" + categoryCode + ", categoryName=" + categoryName
				+ ", categoryContent=" + categoryContent + ", categoryRegDate=" + categoryRegDate
				+ ", categoryUpdateDate=" + categoryUpdateDate + "]";
	}
	
	
}
