package com.productioncheck.dtos;

import java.sql.Timestamp;
import java.util.List;

public class WaterMeterDTO {
	private String identifier;
	private Timestamp datetime;	
	private Timestamp datatime;
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

	public WaterMeterDTO() {
	}
	public WaterMeterDTO(String identifier, Timestamp datetime, Timestamp datatime, Double endData, Double consumption,
	Double cost, Double predictConsumption, Boolean edited, String site, String cluster, String zone,
	String subCommunity, String community, String masterCommunity, String colony, String type,
	List<String> spaces) {
	super();
	this.identifier = identifier;
	this.datetime = datetime;
	this.datatime = datatime;
	this.endData = endData;
	this.consumption = consumption;
	this.cost = cost;
	this.predictConsumption = predictConsumption;
	this.edited = edited;
	this.site = site;
	this.cluster = cluster;
	this.zone = zone;
	this.subCommunity = subCommunity;
	this.community = community;
	this.masterCommunity = masterCommunity;
	this.colony = colony;
	this.type = type;
	this.spaces = spaces;
	}
	public String getIdentifier() {
	return identifier;
	}

	public void setIdentifier(String identifier) {
	this.identifier = identifier;
	}

	public Timestamp getDatetime() {
	return datetime;
	}

	public void setDatetime(Timestamp datetime) {
	this.datetime = datetime;
	}

	public Timestamp getDatatime() {
	return datatime;
	}

	public void setDatatime(Timestamp datatime) {
	this.datatime = datatime;
	}

	public Double getCost() {
	return cost;
	}

	public void setCost(Double cost) {
	this.cost = cost;
	}

	public Boolean getEdited() {
	return edited;
	}

	public void setEdited(Boolean edited) {
	this.edited = edited;
	}

	public String getSite() {
	return site;
	}

	public void setSite(String site) {
	this.site = site;
	}

	public String getCluster() {
	return cluster;
	}

	public void setCluster(String cluster) {
	this.cluster = cluster;
	}

	public String getZone() {
	return zone;
	}

	public void setZone(String zone) {
	this.zone = zone;
	}

	public String getSubCommunity() {
	return subCommunity;
	}

	public void setSubCommunity(String subCommunity) {
	this.subCommunity = subCommunity;
	}

	public String getCommunity() {
	return community;
	}

	public void setCommunity(String community) {
	this.community = community;
	}

	public String getMasterCommunity() {
	return masterCommunity;
	}

	public void setMasterCommunity(String masterCommunity) {
	this.masterCommunity = masterCommunity;
	}

	public String getColony() {
	return colony;
	}

	public void setColony(String colony) {
	this.colony = colony;
	}

	public List<String> getSpaces() {
	return spaces;
	}

	public void setSpaces(List<String> spaces) {
	this.spaces = spaces;
	}

	public Double getConsumption() {
	return consumption;
	}

	public void setConsumption(Double consumption) {
	this.consumption = consumption;
	}

	public Double getPredictConsumption() {
	return predictConsumption;
	}

	public void setPredictConsumption(Double predictConsumption) {
	this.predictConsumption = predictConsumption;
	}

	public Double getEndData() {
	return endData;
	}

	public void setEndData(Double endData) {
	this.endData = endData;
	}

	public String getType() {
	return type;
	}

	public void setType(String type) {
	this.type = type;
	}

	}



