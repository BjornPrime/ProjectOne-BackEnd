package com.revature.ExpenseWebApp.models;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.websocket.Decoder.BinaryStream;

public class Reimbursement {
	int reimbID;
	int status;
	int type;
	int author;
	Timestamp submitDate;
	BigDecimal amount;
	String description;
	BinaryStream documentation;
	int resolver;
	Timestamp resolutionDate;
	String rejectionReason = null;
	String authorName;
	
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
	public BinaryStream getDocumentation() {
		return documentation;
	}
	public void setDocumentation(BinaryStream documentation) {
		this.documentation = documentation;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public Timestamp getResolutionDate() {
		return resolutionDate;
	}
	public void setResolutionDate(Timestamp resolutionDate) {
		this.resolutionDate = resolutionDate;
	}
	public String getRejectionReason() {
		return rejectionReason;
	}
	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}