package com.revature.ExpenseWebApp.util;

public class HttpException extends RuntimeException {

		private int code;
		private String message;
		
		public HttpException(int code, String message) {
			System.out.println("Http exception thrown");
			this.code = code;
			this.message = message;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
}
