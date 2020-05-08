package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
		// 测试快速排序的执行速度
		// 创建随机数组
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 的随机数
		}

		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);

		quickSort(arr, 0, arr.length - 1);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);

		// System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2]; // pivot 中轴值
		int l = left; // 左下标
		int r = right; // 右下标
		int temp = 0; // 临时变量，作为交换时使用
		// while循环的目的是让比pivot 值小放到左边
		// 比pivot 值大放到右边
		while (l < r) {
			// 在pivot的左边一直找,找到大于等于pivot值,才退出
			while (arr[l] < pivot) {
				l += 1;
			}
			// 在pivot的右边一直找,找到小于等于pivot值,才退出
			while (arr[r] > pivot) {
				r -= 1;
			}
			// 如果l >= r说明pivot 的左右两的值，已经按照左边全部是
			// 小于等于pivot值，右边全部是大于等于pivot值
			if (l >= r) {
				break;
			}

			// 交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			// 如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
			if (arr[l] == pivot) {
				r -= 1;
			}
			// 如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
			if (arr[r] == pivot) {
				l += 1;
			}
			// 这两个if是用来避免死循环存在的, 比如说对数组{1,6,5,5,3,2}排序,如果没有这两个if就会进入死循环
		}

		// 如果 l == r, 必须l++, r--, 否则为出现栈溢出
		if (l == r) {
			l += 1;
			r -= 1;
		}
		// 向左递归
		if (left < r) {
			quickSort(arr, left, r);
		}
		// 向右递归
		if (right > l) {
			quickSort(arr, l, right);
		}
	}

}
