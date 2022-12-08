package by.grsu.lancevich.postaloffice.web.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ParcelDto {
	private Integer id;
	private Integer receiver_id;
	private String receiver_name;
	private Integer sender_id;
	private String sender_name;
	private Date date_send_date;
	private Time date_send_time;
	private Date date_accept_date;
	private Time date_accept_time;
	private Boolean fragile;
	private Double length;
	private Double width;
	private Double height;
	private Double weight;
	private Date expiration_date;
	private Time expiration_time;
	private Integer address_from_id;
	private String address_from_name;
	private Integer address_to_id;
	private String address_to_name;
	private Timestamp created;
	private Timestamp updated;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(Integer receiver_id) {
		this.receiver_id = receiver_id;
	}
	public Integer getSender_id() {
		return sender_id;
	}
	public void setSender_id(Integer sender_id) {
		this.sender_id = sender_id;
	}
	public Boolean getFragile() {
		return fragile;
	}
	public void setFragile(Boolean fragile) {
		this.fragile = fragile;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Date getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}
	public Integer getAddress_from_id() {
		return address_from_id;
	}
	public void setAddress_from_id(Integer address_from_id) {
		this.address_from_id = address_from_id;
	}
	public Integer getAddress_to_id() {
		return address_to_id;
	}
	public void setAddress_to_id(Integer address_to_id) {
		this.address_to_id = address_to_id;
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
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public String getAddress_from_name() {
		return address_from_name;
	}
	public void setAddress_from_name(String address_from_name) {
		this.address_from_name = address_from_name;
	}
	public String getAddress_to_name() {
		return address_to_name;
	}
	public void setAddress_to_name(String address_to_name) {
		this.address_to_name = address_to_name;
	}
	@Override
	public String toString() {
		return "Parcel [id=" + id + ", receiver_name=" + receiver_name + ", sender_name=" + sender_name +
				", fragile=" + fragile + ", length=" + length
				+ ", width=" + width + ", height=" + height + ", weight=" + weight + ", expiration_date="
				+ expiration_date + ", address_from_name=" + address_from_name + ", address_to_name=" + address_to_name
				+ ", created=" + created + ", updated=" + updated + "]";
	}
	public Date getDate_send_date() {
		return date_send_date;
	}
	public void setDate_send_date(Date date_send_date) {
		this.date_send_date = date_send_date;
	}
	public Time getDate_send_time() {
		return date_send_time;
	}
	public void setDate_send_time(Time date_send_time) {
		this.date_send_time = date_send_time;
	}
	public Date getDate_accept_date() {
		return date_accept_date;
	}
	public void setDate_accept_date(Date date_accept_date) {
		this.date_accept_date = date_accept_date;
	}
	public Time getDate_accept_time() {
		return date_accept_time;
	}
	public void setDate_accept_time(Time date_accept_time) {
		this.date_accept_time = date_accept_time;
	}
	public Time getExpiration_time() {
		return expiration_time;
	}
	public void setExpiration_time(Time expiration_time) {
		this.expiration_time = expiration_time;
	}
}
