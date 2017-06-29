package cn.com.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
* @ClassName: ArrayListTest 
* @author linsky328
* @date 2017年6月29日 上午10:26:16 
*
 */
public class ArrayListTest {
	
	private  final static int SIZE = 10000000;  
	
	/**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {  
        performance();  
        
        List<String> a = new ArrayList<String>(); 
        a.add("1");
        a.add("2"); 
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
        String temp = it.next();
        if ("2".equals(temp)) {
        	it.remove();;
        	}
        }
        System.out.println(a.size());
        a.add("2"); 
        System.out.println(a.size());
        
        for (String temp : a) {
        	if ("2".equals(temp)) {
        	a.remove(temp);
        	}
        } 
        System.out.println(a.size());
    }
    
    
    
    /**
     * ArrayList大容量性能测试 
     */
	private static void performance() {
		Object obj = new Object();  
        ArrayList<Object> list = new ArrayList<Object>();  
  
        long a1 = System.currentTimeMillis();  
        for (int i = 0; i < SIZE; i++) {  
            list.add(obj);  
        }  
        long a2 = System.currentTimeMillis();  
        System.out.println("costs:" + (a2 - a1) + "ms");  
        
        list = new ArrayList<Object>();  
        a1 = System.currentTimeMillis();  
      //调用ensureCapacity预先设置大小
        list.ensureCapacity(SIZE);  
        for (int i = 0; i < SIZE; i++) {  
            list.add(obj);  
        }  
        a2 = System.currentTimeMillis();  
        System.out.println("costs:" + (a2 - a1) + "ms");
	}  
    
}
