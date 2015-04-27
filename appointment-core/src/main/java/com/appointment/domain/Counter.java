package com.appointment.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author SinghDP
 *
 */
@Document(collection = "sequence")
public class Counter {

	String name;
	long seqNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(long seqNum) {
		this.seqNum = seqNum;
	}

}
