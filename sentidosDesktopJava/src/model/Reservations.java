package model;

import java.util.Date;

public class Reservations {

	private Long table;
	private Date dateReservation;
	private Date create_at;
	private String username;
	private String dateReservationString;
	private Boolean confirmed;
	private Boolean isTea;
	private Boolean hour;
	private Boolean disabled;
	private String location;	
	
	
	public Reservations() {
		super();
	}
	public Reservations(Long table, Date dateReservation, Date create_at, String username,
			String dateReservationString, Boolean confirmed, Boolean isTea, Boolean hour, Boolean disabled,
			String location) {
		super();
		this.table = table;
		this.dateReservation = dateReservation;
		this.create_at = create_at;
		this.username = username;
		this.dateReservationString = dateReservationString;
		this.confirmed = confirmed;
		this.isTea = isTea;
		this.hour = hour;
		this.disabled = disabled;
		this.location = location;
	}
	
	public Long getTable() {
		return table;
	}
	public void setTable(Long table) {
		this.table = table;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDateReservationString() {
		return dateReservationString;
	}
	public void setDateReservationString(String dateReservationString) {
		this.dateReservationString = dateReservationString;
	}
	public Boolean getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	public Boolean getIsTea() {
		return isTea;
	}
	public void setIsTea(Boolean isTea) {
		this.isTea = isTea;
	}
	public Boolean getHour() {
		return hour;
	}
	public void setHour(Boolean hour) {
		this.hour = hour;
	}
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Reservas [table=" + table + ", dateReservation=" + dateReservation + ", create_at=" + create_at
				+ ", username=" + username + ", dateReservationString=" + dateReservationString + ", confirmed="
				+ confirmed + ", isTea=" + isTea + ", hour=" + hour + ", disabled=" + disabled + ", location="
				+ location + "]";
	}
	
}
