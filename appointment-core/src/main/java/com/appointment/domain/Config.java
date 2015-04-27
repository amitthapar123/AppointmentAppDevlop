package com.appointment.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Parag Shrivastava
 *
 */
@Entity
@Table(name = "Config")
@Document(collection = "Config")
public class Config implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String orgShortName;
	private int resources;
	private int minTimePerResource;
	private int startHr;
	private int endHr;
	private int frequency;
	private String resourcesType;

	

	public String getOrgShortName() {
		return orgShortName;
	}

	public void setOrgShortName(String orgShortName) {
		this.orgShortName = orgShortName;
	}

	/**
	 * @return
	 */
	public String getResourcesType() {
		return resourcesType;
	}

	/**
	 * @param resourcesType
	 */
	public void setResourcesType(String resourcesType) {
		this.resourcesType = resourcesType;
	}

	

	/**
	 * @return the resources
	 */
	public int getResources() {
		return resources;
	}

	/**
	 * @param resources
	 *            the resources to set, total no of worker as doctor, barber etc
	 */
	public void setResources(int resources) {
		this.resources = resources;
	}

	/**
	 * @return the minTimePerResource
	 */
	public int getMinTimePerResource() {
		return minTimePerResource;
	}

	/**
	 * @param minSlotPerResource
	 *            the minSlotPerResource to set
	 */
	public void setMinTimePerResource(int minTimePerResource) {
		this.minTimePerResource = minTimePerResource;
	}

	/**
	 * @return the startHr
	 */
	public int getStartHr() {
		return startHr;
	}

	/**
	 * @param startHr
	 *            the startHr to set
	 */
	public void setStartHr(int startHr) {
		this.startHr = startHr;
	}

	/**
	 * @return the endHr
	 */
	public int getEndHr() {
		return endHr;
	}

	/**
	 * @param endHr
	 *            the endHr to set
	 */
	public void setEndHr(int endHr) {
		this.endHr = endHr;
	}

	/**
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency
	 *            the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
