package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个有80000个的数据的随机的数组
		//速度测试
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
		
//		System.out.println("排序前");
//		System.out.println(Arrays.toString(arr));

		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);

		selectSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
		
//		System.out.println("排序后");
//		System.out.println(Arrays.toString(arr));
	}

	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int minIndex = i;
			int min = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if (min > arr[j]) {     // 说明假定的最小值，并不是最小
					min = arr[j];       // 重置min
					minIndex = j;       // 重置minIndex					
				}
			}
			// 将最小值，放在arr[i], 即交换
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}
}
//选择排序时间复杂度是 O(n^2)