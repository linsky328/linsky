package cn.com.common.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 
* @ClassName: ThreadJoinTest 
* @Description:Thread.join()方法解析
* @author linsky328
* @date 2017年7月4日 上午10:22:36 
*
 */
public class ThreadJoinTest  {
	
	 public static void main(String[] args){  
	        DataSourcesLoader dsLoader = new DataSourcesLoader();  
	        Thread thread1 = new Thread(dsLoader,"DataSourceThread");  
	          
	        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();  
	        Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");  
	          
	        thread1.start();  
	        thread2.start();   
	          
	        try { 
	        	/**
	        	 * Thread.join()，是用来指定当前主线程等待其他线程执行完毕后，再来继续执行Thread.join()后面的代码。
	        	 */
	            thread1.join();  
	            /**
	        	 * Thread.join(1900)，是用来指定当前主线程等待其他线程执行1.9秒后，再来继续执行Thread.join(1900)后面的代码。
	        	 */
	            thread2.join(1900);  
	          } catch (InterruptedException e) {  
	            e.printStackTrace();  
	          }  
	            
	          System.out.printf("Main: Configuration has been loaded: %s\n",new Date());  
	    }  
	
}


class DataSourcesLoader implements Runnable{  
  
    @Override  
    public void run() {  
        System.out.printf("Beginning data sources loading: %s\n",new Date());  
        try {  
          TimeUnit.SECONDS.sleep(4);  
        } catch (InterruptedException e) {  
          e.printStackTrace();  
        }  
        System.out.printf("Data sources loading has finished: %s\n",new Date());  
    }  
  
}


class NetworkConnectionsLoader implements Runnable{  
	  
    @Override  
    public void run() {  
        System.out.printf("Beginning network connect loading: %s\n",new Date());  
        try {  
          TimeUnit.SECONDS.sleep(6);  
        } catch (InterruptedException e) {  
          e.printStackTrace();  
        }  
        System.out.printf("Network connect loading has finished: %s\n",new Date());  
          
    } 
}  