package jp.co.sss.test.exception;

/**
 *カート操作に関する例外
 */
 

public class CartOperationException extends RuntimeException{

	public CartOperationException(String message) {
		super(message);
	}
	
	public CartOperationException(String message,Throwable cause) {
		super(message,cause);
	}
}
