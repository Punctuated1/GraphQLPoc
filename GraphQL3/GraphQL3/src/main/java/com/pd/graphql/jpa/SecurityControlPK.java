package com.pd.graphql.jpa;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * The primary key class for the security_control database table.
 * 
 */
@Embeddable
public class SecurityControlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="account_id")
	private String accountId;

	@Column(name="carrier_id")
	private String carrierId;

	@Column(name="client_id")
	private String clientId;

	@Column(name="group_id")
	private String groupId;

	@Column(name="plan_code")
	private String planCode;

	public SecurityControlPK() {
	}
	public String getAccountId() {
		return this.accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCarrierId() {
		return this.carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getClientId() {
		return this.clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getGroupId() {
		return this.groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getPlanCode() {
		return this.planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SecurityControlPK)) {
			return false;
		}
		SecurityControlPK castOther = (SecurityControlPK)other;
		return 
			this.accountId.equals(castOther.accountId)
			&& this.carrierId.equals(castOther.carrierId)
			&& this.clientId.equals(castOther.clientId)
			&& this.groupId.equals(castOther.groupId)
			&& this.planCode.equals(castOther.planCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.accountId.hashCode();
		hash = hash * prime + this.carrierId.hashCode();
		hash = hash * prime + this.clientId.hashCode();
		hash = hash * prime + this.groupId.hashCode();
		hash = hash * prime + this.planCode.hashCode();
		
		return hash;
	}
}