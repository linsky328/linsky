package cn.com.common.innerClass.demo1;

public class Example {
	
	
	private class InsideClass implements Incrementable
	{
		@Override
		public void increment() {
			System.out.println("这是一个测试");
		}
        
    }
    public Incrementable getIn()
    {
        return new InsideClass();
    }
}
