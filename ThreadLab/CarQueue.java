import java.util.PriorityQueue;
import java.util.Random;

public class CarQueue {

  
   Random ran = new Random();
   PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
   private int num;
  
   public CarQueue(){
	   queue.add(ran.nextInt(4));
	   queue.add(ran.nextInt(4));
	   queue.add(ran.nextInt(4));
	   queue.add(ran.nextInt(4));
	   queue.add(ran.nextInt(4));
	   queue.add(ran.nextInt(4));
	   
  
   }
  
   public void addToQueue() {
	   class Run implements Runnable{
		   @Override
		   public void run() {
			   queue.add(ran.nextInt(4));
			   queue.add(ran.nextInt(4));
			   queue.add(ran.nextInt(4));
			   queue.add(ran.nextInt(4));
			   queue.add(ran.nextInt(4));
			   queue.add(ran.nextInt(4));
			   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Error");
			}
			   
		   }
	   }
	   Runnable run = new Run();
	   Thread t = new Thread(run);
	   t.start();
  
     
   }

   public int deleteQueue() {
	   class Run implements Runnable{

		   @Override
		   public void run() {
			   try {
				   Thread.sleep(1000);
			   } catch (InterruptedException e) {
				   System.out.println("Error");;
			   }

		   }

	   }
	   Runnable r = new Run();
	   Thread t = new Thread(r);

	   t.start();
	   num=queue.remove();

	   return num;




   }

}

