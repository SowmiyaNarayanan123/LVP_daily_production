package com.productioncheck.beans;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.Transient;

import com.vladmihalcea.hibernate.type.array.ListArrayType;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.Transient;

import com.vladmihalcea.hibernate.type.array.ListArrayType;

@Entity
@Table(name = "water_sub_data_aggregation")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
@IdClass(EnergyPk.class)
public class WaterSubMeter {

@Id
@Column(name = "identifier", columnDefinition = "text")
private String identifier;
@Id
@Column(name = "datetime", columnDefinition = "TIMESTAMP WITH TIME ZONE NOT NULL")
private Timestamp datetime;

@Column(name = "datatime", columnDefinition = "TIMESTAMP WITH TIME ZONE NOT NULL", updatable = false)
private Timestamp datatime;

@Transient
@Column(name = "enddata", updatable = false)
private Double endData;

@Column(name = "consumption")
private Double consumption;

@Column(name = "cost")
private Double cost;

@Transient
@Column(name = "predictconsumption", updatable = false)
private Double predictConsumption;

@Transient
@Column(name = "edited")
private Boolean edited;

@Transient
@Column(name = "site", columnDefinition = "text", updatable = false)
private String site;

@Transient
@Column(name = "cluster", columnDefinition = "text", updatable = false)
private String cluster;

@Transient
@Column(name = "zone", columnDefinition = "text", updatable = false)
private String zone;

@Transient
@Column(name = "subcommunity", columnDefinition = "text", updatable = false)
private String subCommunity;

@Transient
@Column(name = "community", columnDefinition = "text", updatable = false)
private String community;

@Transient
@Column(name = "mastercommunity", columnDefinition = "text", updatable = false)
private String masterCommunity;

@Transient
@Column(name = "colony", columnDefinition = "text", updatable = false)
private String colony;

@Transient
@Column(name = "type", columnDefinition = "text", updatable = false)
private String type;

@Type(type = "list-array")
@Column(name = "spaces", columnDefinition = "text[]", updatable = false)
private List<String> spaces;

public WaterSubMeter() {
}



public WaterSubMeter(String identifier, Timestamp datetime, Timestamp datatime, Double endData, Double consumption,
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