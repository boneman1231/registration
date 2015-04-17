package org.redcenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * The Class Record.
 */
@Entity
public class Record {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/** The date. */
	//private String date;
	private Date date;
	
	/** The time slot. */
	private String timeSlot;
	
	/** The account. */
	private String account;
	
	/** The name. */
	private String name;	
	/*
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="TARGET_ID_FK")
    private Target target;
	*/
	/** The target id. */
	private long targetId;
	
	/** The remark. */
	private String remark;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	//public String getDate() {
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	//public void setDate(String date) {
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the time slot.
	 *
	 * @return the time slot
	 */
	public String getTimeSlot() {
		return timeSlot;
	}

	/**
	 * Sets the time slot.
	 *
	 * @param timeSlot the new time slot
	 */
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 *
	 * @param account the new account
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the target id.
	 *
	 * @return the target id
	 */
	public long getTargetId() {
		return targetId;
	}

	/**
	 * Sets the target id.
	 *
	 * @param targetId the new target id
	 */
	public void setTargetId(long targetId) {
		this.targetId = targetId;
	}

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}	
}