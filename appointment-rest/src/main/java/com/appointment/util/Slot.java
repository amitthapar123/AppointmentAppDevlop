package com.appointment.util;

public class Slot {
	

	public static class Builder {
		 StringBuffer slot = new StringBuffer();
		public Builder addSlotStartAt(int start) {
			slot.append(start).append(":00 - ");
			return this;
		}
		public Builder addSlotEndAt(int end) {
			slot.append(end).append(":00");
			return this;
		}
		public String getSlot(){
			return slot.toString();
		}
	}

}
