package ksmart39.springboot.domain;

public class ProductionPlan {
	private String production_plan_code;
	private String gender_categorized_name;
	private String detailed_categorized_name;
	private String charge_employee_code;
	private String charge_employee_name;
	private String production_plan_quantity;
	private String production_plan_qantity_unit;
	private String expected_production_start_date;
	private String expected_production_end_date;
	private String production_plan_period;
	private String production_plan_note;
	private String production_plan_reg_date;
	private String production_plan_update_date;
	public String getProduction_plan_code() {
		return production_plan_code;
	}
	public void setProduction_plan_code(String production_plan_code) {
		this.production_plan_code = production_plan_code;
	}
	public String getGender_categorized_name() {
		return gender_categorized_name;
	}
	public void setGender_categorized_name(String gender_categorized_name) {
		this.gender_categorized_name = gender_categorized_name;
	}
	public String getDetailed_categorized_name() {
		return detailed_categorized_name;
	}
	public void setDetailed_categorized_name(String detailed_categorized_name) {
		this.detailed_categorized_name = detailed_categorized_name;
	}
	public String getCharge_employee_code() {
		return charge_employee_code;
	}
	public void setCharge_employee_code(String charge_employee_code) {
		this.charge_employee_code = charge_employee_code;
	}
	public String getCharge_employee_name() {
		return charge_employee_name;
	}
	public void setCharge_employee_name(String charge_employee_name) {
		this.charge_employee_name = charge_employee_name;
	}
	public String getProduction_plan_quantity() {
		return production_plan_quantity;
	}
	public void setProduction_plan_quantity(String production_plan_quantity) {
		this.production_plan_quantity = production_plan_quantity;
	}
	public String getProduction_plan_qantity_unit() {
		return production_plan_qantity_unit;
	}
	public void setProduction_plan_qantity_unit(String production_plan_qantity_unit) {
		this.production_plan_qantity_unit = production_plan_qantity_unit;
	}
	public String getExpected_production_start_date() {
		return expected_production_start_date;
	}
	public void setExpected_production_start_date(String expected_production_start_date) {
		this.expected_production_start_date = expected_production_start_date;
	}
	public String getExpected_production_end_date() {
		return expected_production_end_date;
	}
	public void setExpected_production_end_date(String expected_production_end_date) {
		this.expected_production_end_date = expected_production_end_date;
	}
	public String getProduction_plan_period() {
		return production_plan_period;
	}
	public void setProduction_plan_period(String production_plan_period) {
		this.production_plan_period = production_plan_period;
	}
	public String getProduction_plan_note() {
		return production_plan_note;
	}
	public void setProduction_plan_note(String production_plan_note) {
		this.production_plan_note = production_plan_note;
	}
	public String getProduction_plan_reg_date() {
		return production_plan_reg_date;
	}
	public void setProduction_plan_reg_date(String production_plan_reg_date) {
		this.production_plan_reg_date = production_plan_reg_date;
	}
	public String getProduction_plan_update_date() {
		return production_plan_update_date;
	}
	public void setProduction_plan_update_date(String production_plan_update_date) {
		this.production_plan_update_date = production_plan_update_date;
	}
	
	
	@Override
	public String toString() {
		return "ProductionPlan [production_plan_code=" + production_plan_code + ", gender_categorized_name="
				+ gender_categorized_name + ", detailed_categorized_name=" + detailed_categorized_name
				+ ", charge_employee_code=" + charge_employee_code + ", charge_employee_name=" + charge_employee_name
				+ ", production_plan_quantity=" + production_plan_quantity + ", production_plan_qantity_unit="
				+ production_plan_qantity_unit + ", expected_production_start_date=" + expected_production_start_date
				+ ", expected_production_end_date=" + expected_production_end_date + ", production_plan_period="
				+ production_plan_period + ", production_plan_note=" + production_plan_note
				+ ", production_plan_reg_date=" + production_plan_reg_date + ", production_plan_update_date="
				+ production_plan_update_date + "]";
	}
	
	
}
