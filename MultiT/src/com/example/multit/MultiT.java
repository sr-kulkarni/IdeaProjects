package com.example.multit;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
/**
 * Created by Saurabh on 1/1/16.
 */
public class MultiT implements Runnable {

       public boolean running = false;

       public MultiT(){
          Thread thread = new Thread(this);
          thread.start();
       }

      public static void main(String args[]) throws InterruptedException {



          System.out.println("Getting started yo.");
          System.out.println("The main thread ID is"+ Thread.currentThread().getId());
          //MultiT worker = new MultiT();

          List <MultiT> workers =  new ArrayList<MultiT>();

          Date start = new Date();
          for(int i = 0;i<5; i++){
              workers.add(new MultiT());
          }

          for(MultiT worker : workers){
              while(worker.running)
                  Thread.sleep(100);
          }

          Date end = new Date();
          long diff = end.getTime() - start.getTime();
          System.out.println("This whole process took "+diff/1000+" seconds.");

      }


      @Override
      public void run(){
          this.running = true;
          System.out.println("This is the run method! The thread IS is"+Thread.currentThread().getId());
          try{
              Thread.sleep(5000);
          }
          catch (InterruptedException ex){
              Thread.currentThread().interrupt();
          }
          this.running = false;
      }

}
