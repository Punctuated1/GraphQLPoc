package com.pd.graphql.jpa;

import java.io.Serializable;

public class SecurityControlDao implements Serializable {
	
	private static final long serialVersionUID = 8015604569988243943L;
	
	private String id;
	private String accountId;
	private String carrierId;
	private String clientId;
	private String groupId;
	private String planCode;
	
	private String cag;
	private String clientCag;
	private String coalitionId;
	private String lineOfBusiness;
	private String securityRole;
	private String securityScope;
	private int securityControlCount;
	
	public int getSecurityControlCount() {
		return securityControlCount;
	}
	public void setSecurityControlCount(int securityControlCount) {
		this.securityControlCount = securityControlCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getCag() {
		return cag;
	}
	public void setCag(String cag) {
		this.cag = cag;
	}
	public String getClientCag() {
		return clientCag;
	}
	public void setClientCag(String clientCag) {
		this.clientCag = clientCag;
	}
	public String getCoalitionId() {
		return coalitionId;
	}
	public void setCoalitionId(String coalitionId) {
		this.coalitionId = coalitionId;
	}
	public String getLineOfBusiness() {
		return lineOfBusiness;
	}
	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}
	public String getSecurityRole() {
		return securityRole;
	}
	public void setSecurityRole(String securityRole) {
		this.securityRole = securityRole;
	}
	public String getSecurityScope() {
		return securityScope;
	}
	public void setSecurityScope(String securityScope) {
		this.securityScope = securityScope;
	}

	

}
