package DataStructure;
import java.util.Scanner;
import javax.management.RuntimeErrorException;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		//测试一下
		//创建队列
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' '; //接收用户输入
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show): 显示数据");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据");
			key = sc.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数： ");
				int value = sc.nextInt();
				queue.addQueue(value);
				break;
			case 'g': //取出数据
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是：%d\n", res);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h': //查看队列头的数据
				try {
					int res = queue.headQueue();
					System.out.printf("队列头的数据是：%d\n", res);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e': //退出
				sc.close();
				loop = false;
				break;
			default:
				break;
			}			
		}
		
		System.out.println("程序退出");
		
		
	
	} 

}
//使用数组模拟队列——编写一个ArrayQueue类
class ArrayQueue{
	private int maxSize; //表示数组的最大容量
	private int front; //指向队列头部
	private int rear; //指向队列尾部
	private int[] arr; //该数组用于存放数据，模拟队列
	
	//创建队列的构造器
	public ArrayQueue(int arrayMaxSize) {
		maxSize = arrayMaxSize;
		arr = new int[maxSize];
		front = -1; //指向队列头部，分析出front指向队列头的前一个位置
		rear = -1;  //指向队列尾具体的数据
	}
	
	//判断队列是否满
	public boolean is_full() {
		return rear == maxSize - 1;
	}
	
	//判断队列为空
	public boolean is_empty() {
		return rear == front;
	}
	
	//添加数据到队列
	public void addQueue(int n) {
		//判断队列是否已满
		if (is_full()) {
			System.out.println("队列已满，不能加入数据");
			return;
		}
		rear++; //让rear后移
		arr[rear] = n;
	}
	
	//获取队列数据，出队列
	public int getQueue() {
		//判断队列是否空
		if(is_empty()) {
			//通过抛出异常来处理
			throw new RuntimeException("队列为空，不能取数据");
		}
		front++; //front后移
		return arr[front];
	}
	
	//显示队列的所有数据
	public  void showQueue() {
		//遍历
		if(is_empty()) {
			System.out.println("队列为空，无法遍历");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
	}
	
	//显示队列的头部数据，注意不是取数据
	public int headQueue() {
		if(is_empty())
		throw new RuntimeException("队列为空，没有数据");
		return front + 1;
	}
}



