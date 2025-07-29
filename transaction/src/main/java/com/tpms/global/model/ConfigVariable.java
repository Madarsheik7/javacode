package com.tpms.global.model;

import org.springframework.stereotype.Component;

/**
 * Class for configuration value from properties file for different environment
 * 
 * @author deepeshb
 *
 */
@Component
public class ConfigVariable {
	
	//@Value("${eventHub.bootstrap.servers}")
	private String eventHubBootStrapServers;
	
	//@Value("${eventHub.security.protocol}")
	private String eventHubSecurityProtocol;
	
	//@Value("${eventHub.sasl.mechanism}")
	private String eventHubSaslMechansim;
	
	//@Value("${eventHub.sasl.jaas.config}")
	private String eventHubSaslJaasConfig;
	
	//@Value("${eventHub.max.poll.records}")
	private Integer eventMaxPollRecords;
	
	
	public String getEventHubBootStrapServers() {
		return eventHubBootStrapServers;
	}

	public void setEventHubBootStrapServers(String eventHubBootStrapServers) {
		this.eventHubBootStrapServers = eventHubBootStrapServers;
	}

	public String getEventHubSecurityProtocol() {
		return eventHubSecurityProtocol;
	}

	public void setEventHubSecurityProtocol(String eventHubSecurityProtocol) {
		this.eventHubSecurityProtocol = eventHubSecurityProtocol;
	}

	public String getEventHubSaslMechansim() {
		return eventHubSaslMechansim;
	}

	public void setEventHubSaslMechansim(String eventHubSaslMechansim) {
		this.eventHubSaslMechansim = eventHubSaslMechansim;
	}

	public String getEventHubSaslJaasConfig() {
		return eventHubSaslJaasConfig;
	}

	public void setEventHubSaslJaasConfig(String eventHubSaslJaasConfig) {
		this.eventHubSaslJaasConfig = eventHubSaslJaasConfig;
	}

	public Integer getEventMaxPollRecords() {
		return eventMaxPollRecords;
	}

	public void setEventMaxPollRecords(Integer eventMaxPollRecords) {
		this.eventMaxPollRecords = eventMaxPollRecords;
	}

	

}
