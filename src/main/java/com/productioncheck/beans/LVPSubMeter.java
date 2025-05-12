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

@Entity
@Table(name = "lvp_sub_data_aggregation")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
@IdClass(EnergyPk.class)

public class LVPSubMeter {
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

	public LVPSubMeter() {
	}

	public LVPSubMeter(String identifier, Timestamp datetime, Timestamp datatime, Double consumption, Double enddata,
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
