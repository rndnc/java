package jp.co.sss.test.exception;

/**
 *レビュー操作に関する例外
 */

public class ReviewOperationException extends RuntimeException{
	
	private final int productId;
	
	
	public ReviewOperationException(String message,Throwable cause,int productId) {
		super(message,cause);
		this.productId = productId;
	}
	
	public int getProductId() {
		return productId;
	}

}
