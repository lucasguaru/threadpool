package br.com.santander.msg.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FileOutput {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 1000; i++) {
			executorService.execute(new Runnable() {
			    public void run() {
			        System.out.println("Asynchronous task-" + Thread.currentThread().getName());
			    }
			});
		}

		executorService.shutdown();
		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("****** shutdown task-" + Thread.currentThread().getName());
	}
	
	class ThreadTask implements Runnable {

		   private String[] fileContents;

		   public ThreadTask(String[] fileContents) {
		        this.fileContents = fileContents;
		   }

		   public void run(){
		      //processes txt file
		   }
		}

}
