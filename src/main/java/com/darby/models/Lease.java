package com.darby.models;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="lease")
public class Lease implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lease_id", nullable=false)
	private int leaseID;
	@Column(name="start_date")
	private Timestamp startDate;
	@Column(name="end_date")
	private Timestamp endDate;
	@Column(name="landlord_sig")
	private boolean landlordSig;
	@Column(name="tenant_sig")
	private boolean tenantSig;
	@Column(name="landlord_sig_date")
	private Timestamp landlordSigDate;
	@Column(name="tenant_sig_date")
	private Timestamp tenantSigDate;
	
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name="lease_file")
	private byte[] leaseFile;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	

	public Lease() {
	}
	


	public Lease(byte[] leaseFile) {
		super();
		this.leaseFile = leaseFile;
	}

	

	public Lease(Timestamp startDate, Timestamp endDate, boolean landlordSig, boolean tenantSig,
			Timestamp landlordSigDate, Timestamp tenantSigDate, byte[] leaseFile, User user) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.landlordSig = landlordSig;
		this.tenantSig = tenantSig;
		this.landlordSigDate = landlordSigDate;
		this.tenantSigDate = tenantSigDate;
		this.leaseFile = leaseFile;
		this.user = user;
	}



	public Lease(Timestamp startDate, Timestamp endDate, boolean landlordSig, boolean tenantSig,
			Timestamp landlordSigDate, Timestamp tenantSigDate, User user) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.landlordSig = landlordSig;
		this.tenantSig = tenantSig;
		this.landlordSigDate = landlordSigDate;
		this.tenantSigDate = tenantSigDate;
		this.user = user;
	}


	public byte[] getLeaseFile() {
		return leaseFile;
	}

	public void setLeaseFile(byte[] leaseFile) {
		this.leaseFile = leaseFile;
	}

	public int getLeaseID() {
		return leaseID;
	}


	public void setLeaseID(int leaseID) {
		this.leaseID = leaseID;
	}


	public Timestamp getStartDate() {
		return startDate;
	}


	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}


	public Timestamp getEndDate() {
		return endDate;
	}


	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}


	public boolean isLandlordSig() {
		return landlordSig;
	}


	public void setLandlordSig(boolean landlordSig) {
		this.landlordSig = landlordSig;
	}


	public boolean isTenantSig() {
		return tenantSig;
	}


	public void setTenantSig(boolean tenantSig) {
		this.tenantSig = tenantSig;
	}


	public Timestamp getLandlordSigDate() {
		return landlordSigDate;
	}


	public void setLandlordSigDate(Timestamp landlordSigDate) {
		this.landlordSigDate = landlordSigDate;
	}


	public Timestamp getTenantSigDate() {
		return tenantSigDate;
	}


	public void setTenantSigDate(Timestamp tenantSigDate) {
		this.tenantSigDate = tenantSigDate;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (landlordSig ? 1231 : 1237);
		result = prime * result + ((landlordSigDate == null) ? 0 : landlordSigDate.hashCode());
		result = prime * result + leaseID;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + (tenantSig ? 1231 : 1237);
		result = prime * result + ((tenantSigDate == null) ? 0 : tenantSigDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lease other = (Lease) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (landlordSig != other.landlordSig)
			return false;
		if (landlordSigDate == null) {
			if (other.landlordSigDate != null)
				return false;
		} else if (!landlordSigDate.equals(other.landlordSigDate))
			return false;
		if (leaseID != other.leaseID)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (tenantSig != other.tenantSig)
			return false;
		if (tenantSigDate == null) {
			if (other.tenantSigDate != null)
				return false;
		} else if (!tenantSigDate.equals(other.tenantSigDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Lease [leaseID=" + leaseID + ", startDate=" + startDate + ", endDate=" + endDate + ", landlordSig="
				+ landlordSig + ", tenantSig=" + tenantSig + ", landlordSigDate=" + landlordSigDate + ", tenantSigDate="
				+ tenantSigDate + ", user=" + user + "]";
	}


}
