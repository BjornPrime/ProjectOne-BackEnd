package com.revature.ExpenseWebApp.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Reimbursement {
	int reimbID;
	int status = 0;
	int reimbType;
	int author;
	Timestamp submitDate;
	BigDecimal reimbAmount;
	String description;
	String documentation;
	int resolver;
	int resolutionDate;
	String rejectionReason = null;
	
	public Reimbursement(int reimbID, int status, int reimbType, int author, Timestamp submitDate,
			BigDecimal reimbmount, String description, String documentation, int resolver, int resolutionDate,
			String rejectionReason) {
		super();
		this.reimbID = reimbID;
		this.status = status;
		this.reimbType = reimbType;
		this.author = author;
		this.submitDate = submitDate;
		this.reimbAmount = reimbmount;
		this.description = description;
		this.documentation = documentation;
		this.resolver = resolver;
		this.resolutionDate = resolutionDate;
		this.rejectionReason = rejectionReason;
	}


	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getRequestID() {
		return reimbID;
	}


	public void setRequestID(int requestID) {
		this.reimbID = requestID;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getRequestType() {
		return reimbType;
	}


	public void setRequestType(int requestType) {
		this.reimbType = requestType;
	}


	public int getRequestor() {
		return author;
	}


	public void setRequestor(int requestor) {
		this.author = requestor;
	}


	public Timestamp getRequestDate() {
		return submitDate;
	}


	public void setRequestDate(Timestamp requestDate) {
		this.submitDate = requestDate;
	}


	public BigDecimal getRequestAmount() {
		return reimbAmount;
	}


	public void setRequestAmount(BigDecimal requestAmount) {
		this.reimbAmount = requestAmount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDocumentation() {
		return documentation;
	}


	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}


	public int getResolver() {
		return resolver;
	}


	public void setResolver(int resolver) {
		this.resolver = resolver;
	}


	public int getResolutionDate() {
		return resolutionDate;
	}


	public void setResolutionDate(int resolutionDate) {
		this.resolutionDate = resolutionDate;
	}


	public String getRejectionReason() {
		return rejectionReason;
	}


	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}


	
	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", status=" + status + ", reimbType=" + reimbType + ", author="
				+ author + ", submitDate=" + submitDate + ", reimbAmount=" + reimbAmount + ", description="
				+ description + ", documentation=" + documentation + ", resolver=" + resolver + ", resolutionDate="
				+ resolutionDate + ", rejectionReason=" + rejectionReason + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((documentation == null) ? 0 : documentation.hashCode());
		result = prime * result + ((rejectionReason == null) ? 0 : rejectionReason.hashCode());
		result = prime * result + ((reimbAmount == null) ? 0 : reimbAmount.hashCode());
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		result = prime * result + reimbID;
		result = prime * result + reimbType;
		result = prime * result + author;
		result = prime * result + resolutionDate;
		result = prime * result + resolver;
		result = prime * result + status;
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
		Reimbursement other = (Reimbursement) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (documentation == null) {
			if (other.documentation != null)
				return false;
		} else if (!documentation.equals(other.documentation))
			return false;
		if (rejectionReason == null) {
			if (other.rejectionReason != null)
				return false;
		} else if (!rejectionReason.equals(other.rejectionReason))
			return false;
		if (reimbAmount == null) {
			if (other.reimbAmount != null)
				return false;
		} else if (!reimbAmount.equals(other.reimbAmount))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		if (reimbID != other.reimbID)
			return false;
		if (reimbType != other.reimbType)
			return false;
		if (author != other.author)
			return false;
		if (resolutionDate != other.resolutionDate)
			return false;
		if (resolver != other.resolver)
			return false;
		if (status != other.status)
			return false;
		return true;
	}	
}
