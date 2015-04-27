package com.appointment.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Parag Shrivastava
 * 
 */
@Entity
@Table(name = "Schedule")
@Document(collection = "Schedule")
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId id;
	@Indexed(unique=true)
	private String orgShortName;
	private Config config;

	private int duration;

	private Long durationId;
	private String status;
	private int threshold;
	private int resourceCount;
	public Schedule(){
		
	}
	public Schedule(Config config){
		this.config=config;
		this.duration=config.getEndHr()-config.getStartHr()+1;
		this.threshold=config.getFrequency()*60/config.getMinTimePerResource();
	}

	/**
	 * @return the config
	 */
	public Config getConfig() {
		return config;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * @param config
	 *            the config to set
	 */
	public void setConfig(Config config) {
		this.config = config;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		
		return this.duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}



	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the threshold
	 */
	public int getThreshold() {
		
		return this.threshold ;
	}

	/**
	 * @param threshold
	 *            the threshold to set
	 */
	public void setThreshold(int resourceCount){
		this.threshold *= resourceCount;
	}

	/**
	 * @return the resourceCount
	 */
	public int getResourceCount() {
		return resourceCount;
	}

	/**
	 * @param resourceCount
	 *            the resourceCount to set
	 */
	public void setResourceCount(int resourceCount) {
		setThreshold(resourceCount);
		this.resourceCount = resourceCount;
	}

	

	public String getOrgShortName() {
		return orgShortName;
	}

	public void setOrgShortName(String orgShortName) {
		this.orgShortName = orgShortName;
	}

	public Long getDurationId() {
		return durationId;
	}

	public void setDurationId(Long durationId) {
		this.durationId = durationId;
	}
	
	

}
