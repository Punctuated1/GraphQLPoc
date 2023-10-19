package com.pd.graphql.jpa;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


/**
 * The persistent class for the security_control database table.
 * 
 */
@Entity
@Table(name="security_control", schema="benchmark")
public class SecurityControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SecurityControlPK id;

	private String cag;


	@Column(name="client_cag")
	private String clientCag;

	@Column(name="coalition_id")
	private String coalitionId;

	@Column(name="line_of_business")
	private String lineOfBusiness;

	@Column(name="security_role")
	private String securityRole;

	@Column(name="security_scope")
	private String securityScope;

	public SecurityControl() {
	}

	public SecurityControlPK getId() {
		return this.id;
	}

	public void setId(SecurityControlPK id) {
		this.id = id;
	}

	public String getCag() {
		return this.cag;
	}

	public void setCag(String cag) {
		this.cag = cag;
	}

	public String getClientCag() {
		return this.clientCag;
	}

	public void setClientCag(String clientCag) {
		this.clientCag = clientCag;
	}

	public String getCoalitionId() {
		return this.coalitionId;
	}

	public void setCoalitionId(String coalitionId) {
		this.coalitionId = coalitionId;
	}

	public String getLineOfBusiness() {
		return this.lineOfBusiness;
	}

	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}

	public String getSecurityRole() {
		return this.securityRole;
	}

	public void setSecurityRole(String securityRole) {
		this.securityRole = securityRole;
	}

	public String getSecurityScope() {
		return this.securityScope;
	}

	public void setSecurityScope(String securityScope) {
		this.securityScope = securityScope;
	}

}