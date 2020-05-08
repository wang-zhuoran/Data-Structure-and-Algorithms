package DataStructure;

import java.util.Scanner;

//将原来的代码进行优化，改队列为环形队列，思路如下：
/*
 * 1、front变量的含义做一个调整：front指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素
 * front的初始值=0
 * 2、rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置. 因为希望流出一个空间作为约定
 * rear的初始值=0
 * 3、当队列满时，条件是(rear+1)%maxSize==front
 * 4、队列为空的条件是：rear==front
 * 5、当我们这样分析, 队列中有效的数据的个数为：(rear + maxSize - front)%maxSize   //举个栗子会好理解
 */
public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		//测试一下
		//创建队列
		CircleArray queue = new CircleArray(4);
		char key = ' '; // 接收用户输入
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
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
			case 'g': // 取出数据
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是：%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h': // 查看队列头的数据
				try {
					int res = queue.headQueue();
					System.out.printf("队列头的数据是：%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // 退出
				sc.close();
				loop = false;
				break;
			default:
				break;
			}
		}

		System.out.println("程序退出");

	}

static class CircleArray {
		private int maxSize; // 表示数组的最大容量
		private int front; // 指向队列头部
		private int rear; // 指向队列尾部
		private int[] arr; // 该数组用于存放数据，模拟队列

		public CircleArray(int arrayMaxSize) {
			maxSize = arrayMaxSize;
			arr = new int[maxSize];
			front = 0;
			rear = 0;
		}

		// 判断队列是否满
		public boolean is_full() {
			return (rear + 1) % maxSize == front;
		}

		// 判断队列为空
		public boolean is_empty() {
			return rear == front;
		}

		// 添加数据到队列
		public void addQueue(int n) {
			// 判断队列是否已满
			if (is_full()) {
				System.out.println("队列已满，不能加入数据");
				return;
			}
			// 直接将数据加入
			arr[rear] = n;
			// 将rear后移，这里必须考虑取模
			rear = (rear + 1) % maxSize;
		}

		// 获取队列数据，出队列
		public int getQueue() {
			// 判断队列是否空
			if (is_empty()) {
				// 通过抛出异常来处理
				throw new RuntimeException("队列为空，不能取数据");
			}
			// 这里需要分析出front指向队列的第一个元素
			// 1.先把front对应的值保留到一个临时变量
			// 2.将front后移，考虑取模
			// 3.将临时保存的变量值返回
			int value = arr[front];
			front = (front + 1) % maxSize;
			return value;
		}

		// 显示队列的所有数据
		public void showQueue() {
			// 遍历
			if (is_empty()) {
				System.out.println("队列为空，无法遍历");
				return;
			}
			// 思路：从front开始遍历，遍历多少个元素
			for (int i = front; i < front + size(); i++) {
				System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
			}
		}

		// 求出当前队列中有效值的个数
		public int size() {
			return (rear + maxSize - front) % maxSize;
		}

		// 显示队列的头部数据，注意不是取数据
		public int headQueue() {
			if (is_empty())
				throw new RuntimeException("队列为空，没有数据");
			return arr[front];
		}

	}
}
