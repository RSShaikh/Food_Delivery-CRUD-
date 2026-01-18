package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.DeliveryAgent;

public interface DeliveryAgentDao {
	boolean addAgent(DeliveryAgent agent);
	boolean updateAgent(DeliveryAgent agent); 
	boolean deleteAgent(int agentId); 
	DeliveryAgent getAgentById(int agentId); 
	List<DeliveryAgent> getAllAgents(); 
	List<DeliveryAgent> getAvailableAgents(); 
	boolean updateAvailability(int agentId, boolean isAvailable);

}
