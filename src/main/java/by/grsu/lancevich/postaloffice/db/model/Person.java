package by.grsu.lancevich.postaloffice.db.model;

import java.sql.Timestamp;

public class Person {
	private Integer id;
	private String name;
	private String ser_name;
	private String patronymic;
	private Integer address_id;
	private String passport_number;
	private String indetification_number;
	private String passport_authority;
	private Timestamp created;
	private Timestamp updated;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSer_name() {
		return ser_name;
	}
	public void setSer_name(String ser_name) {
		this.ser_name = ser_name;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public String getPassport_number() {
		return passport_number;
	}
	public void setPassport_number(String pasport_number) {
		this.passport_number = pasport_number;
	}
	public String getIndetification_number() {
		return indetification_number;
	}
	public void setIndetification_number(String indetification_number) {
		this.indetification_number = indetification_number;
	}
	public String getPassport_authority() {
		return passport_authority;
	}
	public void setPassport_authority(String passport_authority) {
		this.passport_authority = passport_authority;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", ser_name=" + ser_name + ", patronymic=" + patronymic
				+ ", address_id=" + address_id + ", passport_number=" + passport_number + ", indetification_number="
				+ indetification_number + ", passport_authority=" + passport_authority + ", created=" + created
				+ ", updated=" + updated + "]";
	}
	
	
	

}
