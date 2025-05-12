package com.productioncheck.dtos;

import java.sql.Timestamp;
import java.util.List;

public class LVPSubMeterDTO {

	private String identifier;
	private String datetime;
	private String datatime;
	private Double endData;
	private Double consumption;
	private Double cost;
	private Double predictConsumption;	
	private Boolean edited;
	private String site;
	private String cluster;
	private String zone;
	private String subCommunity;
	private String community;
	private String masterCommunity;
    private String colony;
    private String type;
	private List<String> spaces;
	public LVPSubMeterDTO() {
	}
    public LVPSubMeterDTO(String identifier, String datetime, String datatime, Double consumption, Double enddata,
	Double cost, Double temperature, Boolean edited, String site, String cluster, String zone,
	String subCommunity, String community, String masterCommunity, String colony, List<String> spaces) {
	super();
	this.identifier = identifier;
	this.datetime = datetime;
	this.datatime = datatime;
	this.consumption = consumption;
	this.endData = enddata;
	this.cost = cost;
	this.edited = edited;
	this.site = site;
	this.cluster = cluster;
	this.zone = zone;
	this.subCommunity = subCommunity;
	this.community = community;
	this.masterCommunity = masterCommunity;
	this.colony = colony;
	this.spaces = spaces;
	}

	public String getIdentifier() {
	return identifier;
	}

	public void setIdentifier(String identifier) {
	this.identifier = identifier;
	}
}


