package cn.com.common.innerClass.demo2;


/**
 * 
* @ClassName: TagBean 
* @Description:可以无条件地访问外围类的所有元素
* @author linsky328
* @date 2017年6月29日 下午4:38:59 
*
 */
public class TagBean {

	private String name = "linsky328";

	private class InTest {
		public InTest() {
			System.out.println(name);
		}
	}

	public void test() {
		new InTest();
	}

	public static void main(String args[]) {
		TagBean bb = new TagBean();
		bb.test();
	}
}
