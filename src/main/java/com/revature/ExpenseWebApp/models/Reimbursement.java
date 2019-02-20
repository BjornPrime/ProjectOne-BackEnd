package com.revature.ExpenseWebApp.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.websocket.Decoder.BinaryStream;

public class Reimbursement {
	int reimbID;
	int status = 0;
	int type;
	int author;
	Timestamp submitDate;
	BigDecimal amount;
	String description;
	String documentation = "";
	int resolver;
	int resolutionDate;
	String rejectionReason = null;
	
	public Reimbursement(int reimbID, int status, int type, int author, Timestamp submitDate,
			BigDecimal amount, String description, String documentation, int resolver, int resolutionDate,
			String rejectionReason) {
		super();
		this.reimbID = reimbID;
		this.status = status;
		this.type = type;
		this.author = author;
		this.submitDate = submitDate;
		this.amount = amount;
		this.description = description;
		this.documentation = documentation;
		this.resolver = resolver;
		this.resolutionDate = resolutionDate;
		this.rejectionReason = rejectionReason;
	}

	public int getReimbID() {
		return reimbID;
	}

	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbID=" + reimbID + ", status=" + status + ", type=" + type + ", author=" + author
				+ ", submitDate=" + submitDate + ", amount=" + amount + ", description=" + description
				+ ", documentation=" + documentation + ", resolver=" + resolver + ", resolutionDate=" + resolutionDate
				+ ", rejectionReason=" + rejectionReason + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + author;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((documentation == null) ? 0 : documentation.hashCode());
		result = prime * result + reimbID;
		result = prime * result + ((rejectionReason == null) ? 0 : rejectionReason.hashCode());
		result = prime * result + resolutionDate;
		result = prime * result + resolver;
		result = prime * result + status;
		result = prime * result + ((submitDate == null) ? 0 : submitDate.hashCode());
		result = prime * result + type;
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (author != other.author)
			return false;
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
		if (reimbID != other.reimbID)
			return false;
		if (rejectionReason == null) {
			if (other.rejectionReason != null)
				return false;
		} else if (!rejectionReason.equals(other.rejectionReason))
			return false;
		if (resolutionDate != other.resolutionDate)
			return false;
		if (resolver != other.resolver)
			return false;
		if (status != other.status)
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	
}
