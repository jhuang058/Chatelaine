package com.darby.models;

public class LeaseDTO {

	public int leaseID;
	
	public String party;
	
	public byte[] file;

	public LeaseDTO(byte[] file) {
		super();
		this.file = file;
	}

	public LeaseDTO() {
		super();
	}

	public LeaseDTO(int leaseID, String party) {
		super();
		this.leaseID = leaseID;
		this.party = party;
	}

	public LeaseDTO(int leaseID, String party, byte[] file) {
		super();
		this.leaseID = leaseID;
		this.party = party;
		this.file = file;
	}
	
	

}
