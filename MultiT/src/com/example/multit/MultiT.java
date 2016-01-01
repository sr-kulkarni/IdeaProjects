package com.example.multit;

/**
 * Created by Saurabh on 1/1/16.
 */
public class MultiT implements Runnable {

      public static void main(String args[]){

          System.out.println("Getting started yo.");
          System.out.println("The main thread ID is"+ Thread.currentThread().getId());
          MultiT worker = new MultiT();
          Thread thread = new Thread(worker);
          thread.start();

      }


      @Override
      public void run(){
          System.out.println("This is the run method! The thread IS is"+Thread.currentThread().getId());
      }

}
