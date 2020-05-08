package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,6,3,7,4,0};
		// 创建要一个有80000个数据的随机的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000); // 生成一个[0, 8000000) 数
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是 = " + date1Str);
//		
//		shellSort(arr);
		shellSort2(arr);
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序后的时间是 = " + date2Str);
		
		//System.out.println(Arrays.toString(arr));
		
//		int[] arr2 = {1,6,3,7,4,0};
		
		
	}
	
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
				for (int j = i - gap; j >= 0; j -= gap) {
					// 如果当前元素大于加上步长后的那个元素，说明交换
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
//			System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
		}
		
	}
	
	
	// 对交换式的希尔排序进行优化->移位法
	public static void shellSort2(int[] arr) {
		int count = 0;
		// 增量gap, 并逐步的缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						// 移动
						arr[j] = arr[j - gap];
						j -= gap;
					}
					// 当退出while后，就给temp找到插入的位置
					arr[j] = temp;
				}

			}
//			System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
		}
	}

}
