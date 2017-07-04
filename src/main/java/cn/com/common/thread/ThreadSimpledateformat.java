package cn.com.common.thread;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 
* @ClassName: ThreadSimpledateformat 
* @Description:Simpledateformat线程安全
* @author linsky328
* @date 2017年7月4日 上午11:29:20 
*
 */
public class ThreadSimpledateformat {
	
	
    private static String date[] = { "01-Jan-1999", "01-Jan-2000", "01-Jan-2001" };  
    
    
    private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>();  
    
    public static SimpleDateFormat getSimpleDateFormat(){  
        SimpleDateFormat sdf = local.get();  
        if (sdf == null) {  
            sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);  
            local.set(sdf);  
        }  
        return  sdf;
    }
    
    public static void main(String[] args) {  
        for (int i = 0; i < date.length; i++) {  
            final int temp = i;  
            new Thread(new Runnable() {  
                @Override  
                public void run() {  
                    try {  
                        while (true) {  
								String str1 = date[temp];
								String str2 = getSimpleDateFormat().format(getSimpleDateFormat().parse(str1));
								System.out.println(Thread.currentThread().getName() + ", " + str1 + "," + str2);
								if (!str1.equals(str2)) {
									throw new RuntimeException(Thread.currentThread().getName() + ", Expected " + str1
											+ " but got " + str2);
								}
							}  
                    } catch (Exception e) {  
                        throw new RuntimeException("parse failed", e);  
                    }  
                }  
            }).start();  
        }  
    }  
}
