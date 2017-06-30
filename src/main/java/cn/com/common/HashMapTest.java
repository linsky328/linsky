package cn.com.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 【推荐】集合初始化时，指定集合初始值大小。 说明：HashMap 使用 HashMap(int initialCapacity) 初始化，
 * 正例：initialCapacity = (需要存储的元素个数 / 负载因子) + 1。注意负载因子（即 loader factor）默认为
 * 0.75，如果暂时无法确定初始值大小，请设置为 16。 反例：HashMap 需要放置 1024 个元素，由于没有设置容量初始大小，随着元素不断增加，容
 * 量 7 次被迫扩大，resize 需要重建 hash 表，严重影响性能。
 * 
 * @ClassName: HashMapTest
 * @Description:
 * @author linsky328
 * @date 2017年6月30日 下午3:45:50
 *
 */
public class HashMapTest {

	private final static int SIZE = 3000000; // 容量

	public static void main(String[] args) {

		performance();

		forEach();
	}
	
	/**
	 * map循环测试
	 */
	private static void forEach() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			map.put(i, i);
		}
		long time1 = System.currentTimeMillis();
		Set<Entry<Integer, Integer>> set = map.entrySet();
		for (Entry<Integer, Integer> entry : set) {
			int code = entry.getKey().hashCode() + entry.getValue().hashCode();
		}
		long time2 = System.currentTimeMillis();
		System.out.println("costs1:" + (time2 - time1) + "ms");

		for (Integer key : map.keySet()) {
			int code = key.hashCode() + map.get(key).hashCode();
		}
		long time3 = System.currentTimeMillis();
		System.out.println("costs2:" + (time3 - time2) + "ms");

		map.forEach((key, value) -> {
			int code = key.hashCode() + value.hashCode();
		});
		long time4 = System.currentTimeMillis();
		System.out.println("costs3:" + (time4 - time3) + "ms");
	}

	/**
	 * ArrayList大容量性能测试
	 */
	private static void performance() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		long a1 = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			map.put(i, i);
		}
		long a2 = System.currentTimeMillis();
		System.out.println("costs:" + (a2 - a1) + "ms");

		// 预先设置大小
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			map2.put(i, i);
		}
		System.out.println("costs:" + (System.currentTimeMillis() - a2) + "ms");
	}

}
