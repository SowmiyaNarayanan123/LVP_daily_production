package com.productioncheck.dtos;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDTO {

 private String meterType;
 private Long startDate;
 private Long enddate;
 private List<String> colony;
 private List<String> community;
 private List<String> subcommunity;
 private List<String> site;
public String getMeterType() {
	return meterType;
}
public void setMeterType(String meterType) {
	this.meterType = meterType;
}

public Long getStartDate() {
	return startDate;
}
public void setStartDate(Long startDate) {
	this.startDate = startDate;
}
public Long getEnddate() {
	return enddate;
}
public void setEnddate(Long enddate) {
	this.enddate = enddate;
}
public List<String> getColony() {
	return colony;
}
public void setColony(List<String> colony) {
	this.colony = colony;
}
public List<String> getCommunity() {
	return community;
}
public void setCommunity(List<String> community) {
	this.community = community;
}
public List<String> getSubcommunity() {
	return subcommunity;
}
public void setSubcommunity(List<String> subcommunity) {
	this.subcommunity = subcommunity;
}
public List<String> getSite() {
	return site;
}
public void setSite(List<String> site) {
	this.site = site;
}
 



 
}
