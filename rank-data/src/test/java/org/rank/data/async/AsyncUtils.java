package org.rank.data.async;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsyncUtils {

	public static void main(String[] args) throws TimeoutException{
		String resultString1="--";
		String resultString2="--";
		String resultString3="--";
		try {   
			CompletableFuture<String> asyncFuture1 =asyncRun1("test1");
			CompletableFuture<String> asyncFuture2 =asyncRun1("test2");
			Thread.sleep(3000);
			resultString1=asyncFuture1.get();
			resultString2=asyncFuture2.get(3000, TimeUnit.MILLISECONDS);
			resultString3=asyncFuture2.get(3000, TimeUnit.MILLISECONDS);
			
		} catch (Exception e) { 
			System.out.println(e);
		}
		System.out.println(resultString1);
		System.out.println(resultString2);
		System.out.println(resultString3);
	}
	

	public static CompletableFuture<String> asyncRun1(String para) throws InterruptedException, ExecutionException {
		CompletableFuture<String> asyncFuture = CompletableFuture.supplyAsync(() -> search(para)); 
		return asyncFuture;
	}
	
	public static String asyncRun(String para) throws InterruptedException, ExecutionException {
		CompletableFuture<String> asyncFuture = CompletableFuture.supplyAsync(() -> search(para));
		String resultString= asyncFuture.get();
		return resultString;
	}
	
	private static String search(String para) {
		 try {
		Thread.sleep(2000);
		 }catch (Exception e) { 
				System.out.println(e.getMessage());
		}
		    return para+"-"+"hasReturnLambda";
	}

}
