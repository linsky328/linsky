package cn.com.common.innerClass.demo3;

/**
 * 
* @ClassName: MainExample 
* @Description:里面分别实现了两个内部类 test1,和test2 ，test1类又继承了Example1，test2继承了Example2，
* 	这样我们的类三MainExample就拥有了Example1和Example2的方法和属性，也就间接地实现了多继承
* @author linsky328
* @date 2017年6月29日 下午4:44:08 
*
 */
public class MainExample {
	private class test1 extends Example1 {
		public String name() {
			return super.name();
		}
	}

	private class test2 extends Example2 {
		public int age() {
			return super.age();
		}
	}

	public String name() {
		return new test1().name();
	}

	public int age() {
		return new test2().age();
	}

	public static void main(String args[]) {
		MainExample mi = new MainExample();
		System.out.println("姓名:" + mi.name());
		System.out.println("年龄:" + mi.age());
	}
}