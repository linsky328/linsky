package cn.com.common.jdk8;

import java.util.Arrays;

public class LambdaTest {

	public static void main(String[] args) {
		
		Arrays.asList("a", "b", "d").forEach(e->System.out.println(e));

	}

}
