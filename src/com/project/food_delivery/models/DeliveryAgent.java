package com.project.food_delivery.models;

public class DeliveryAgent {
	private int agentId;
	private String name;
	private String phone;
	private boolean isAvailable;
	public DeliveryAgent(int agentId, String name, String phone, boolean isAvailable) {
		super();
		this.agentId = agentId;
		this.name = name;
		this.phone = phone;
		this.isAvailable = isAvailable;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "DeliveryAgent [agentId=" + agentId + ", name=" + name + ", phone=" + phone + ", isAvailable="
				+ isAvailable + "]";
	}
	
	
	

}
