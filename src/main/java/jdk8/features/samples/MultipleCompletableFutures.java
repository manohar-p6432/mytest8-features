package jdk8.features.samples;

import java.util.concurrent.CompletableFuture;

/**
 * The purpose of this class is to demonstrate how to call multiple services simultaneously.
 * 'CompletableFuture' makes it possible to call as many services as possible and 
 * store the result in a variable.
 */
public class MultipleCompletableFutures {
	
	public static void main(String[] args) {
		/**
		 * For the demonstrate purpose, 4 CompletableFuture instances are created.
		 * let's suppose 4 different services are being called which is represented 
		 * by calling static method here.
		 */
		final CompletableFuture<String> java = questions("java");
		final CompletableFuture<String> scala = questions("scala");
		final CompletableFuture<String> closure = questions("closure");
		final CompletableFuture<String> groovy = questions("groovy");
		
		/**
		 * 'allOf()' method will wait until all the services are complete. The result is stored in 'allCompleted'.
		 */
		final CompletableFuture<Void> allCompleted = CompletableFuture.allOf(java, scala, closure, groovy); 
		
		/**
		 * Whenever 'allCompleted' is available after getting all services result, 'thenRun()' will be invoked automatically.
		 * It takes a Lambda Expression as argument. The result of individual CompletableFuture instances can be accessed using
		 * get() method.
		 * get() must be within try-catch block. 
		 */
		allCompleted.thenRun( () -> {
			try {
				System.out.println("loaded" + java.get());
				System.out.println("loaded" + scala.get());
				System.out.println("loaded" + closure.get());
				System.out.println("loaded" + groovy.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * This is a dummy method in place of actual service.
	 * 'supplyAsync()' takes 'Supplier' Functional Interface as argument.
	 */
	public static CompletableFuture<String> questions(String language) {
		try{Thread.sleep(2000);} 
		catch(Exception ex){}
		final CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {return language;});
		return future;
	}

}
