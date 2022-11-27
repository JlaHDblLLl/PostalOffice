package by.grsu.lancevich.postaloffice.web.dto;

import java.sql.Timestamp;

public class UserdataDto {
	private Integer id;
	private String name;
	private String surname;
	private String patronymic;
	private Integer address_id;
	private String address_name;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	@Override
	public String toString() {
		return "UserDate [id=" + id + ", name=" + name + ", ser_name=" + surname + ", patronymic=" + patronymic
				+ ", address_name=" + address_name + ", passport_number=" + passport_number + ", indetification_number="
				+ indetification_number + ", passport_authority=" + passport_authority + ", created=" + created
				+ ", updated=" + updated +"]";
	}
}
