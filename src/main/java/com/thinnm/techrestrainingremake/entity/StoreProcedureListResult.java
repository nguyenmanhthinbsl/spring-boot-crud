package com.thinnm.techrestrainingremake.entity;

import java.math.BigDecimal;
import java.util.List;

// generics T
public class StoreProcedureListResult<T> {
	private int statusCode; //trạng thái kết quả của phép SP
	private String messageError; // thông báo lỗi
	private List<T> result; // list kết quả
	private long totalRecord; // tổng dòng kq phép SP
	
	// sp test db
	public StoreProcedureListResult(int statusCode, String messageError) {
		super();
		this.statusCode = statusCode;
		this.messageError = messageError;
	}
	
	// lấy danh sách kết quả
	public StoreProcedureListResult(int statusCode, String messageError, List<T> result) {
		super();
		this.statusCode = statusCode;
		this.messageError = messageError;
		this.result = result;
	}
	
	public StoreProcedureListResult( List<T> result) {
		this.result = result;
		this.totalRecord=result.size();
	}
	
	// đếm số thể hiện
	public StoreProcedureListResult(int statusCode, String messageError, long totalRecord) {
		super();
		this.statusCode = statusCode;
		this.messageError = messageError;
		this.totalRecord = totalRecord;
	}
	
	// lấy danh sách kq + đếm số thể hiện
	public StoreProcedureListResult(int statusCode, String messageError, long totalRecord, List<T> result) {
		this.statusCode = statusCode;
		this.messageError = messageError;
		this.totalRecord = result.size();
		this.result = result;
	}

	// lấy danh sách và tổng giá trị các thể hiện(totalAmount: biến OUT trong SP)
	public StoreProcedureListResult(int statusCode, String messageError, BigDecimal totalAmount, List<T> result) {
		this.statusCode = statusCode;
		this.messageError = messageError;
		this.result = result;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	
}
