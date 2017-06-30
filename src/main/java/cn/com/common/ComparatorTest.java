package cn.com.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	/**
	 * 
	 * @ClassName: Student
	 * @Description:内部类，不直接对外提供
	 * @author linsky328
	 * @date 2017年6月30日 上午10:54:10
	 *
	 */
	private class Student {
		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	}

	public Student getStudent() {
		return new Student();
	}
	
	
	/**
	 * 在 JDK7 版本及以上，Comparator 要满足如下三个条件，不然 Arrays.sort，
Collections.sort 会报 IllegalArgumentException 异常。
说明：
1） x，y 的比较结果和 y，x 的比较结果相反。
2） x>y，y>z，则 x>z。
3） x=y，则 x，z 比较结果和 y，z 比较结果相同。
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sample = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 1, 0,
				-2, 0, 0 };
		List<Student> list = new ArrayList<Student>();
		for (int i : sample) {
			Student s = new ComparatorTest().getStudent();
			s.setId(i);
			list.add(s);
		}

		Collections.sort(list, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				int id1 = o1.getId();
				int id2 = o2.getId();
				//return id1 > id2 ? 1 : -1;// throw java.lang.IllegalArgumentException
				 return id1==id2?0:id1 > id2 ? 1 : -1; 
			}
		});
	}
}
