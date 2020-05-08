package һѧ;
import java.util.Arrays;;
public class BubbleSort {
	public static void bubbleSort(int[] a)  {
		for (int pass = 1; pass < a.length; pass++) {
			boolean flag = false;
			for (int j = 0; j < a.length - pass; j++) {
				if (a[j] > a[j+1]) { // the larger item bubbles down (swap)
					flag = true;
					int temp = a[j]; 
					a[j] = a[j+1]; 
					a[j+1] = temp; 
				}
				if (!flag) {
					break;
				}
	 		}
		}
	}
	public static void main(String[] args) {
		int[] data= {9,8,7,6,5,4,3,2,1,12,33,45,22,10,50,200,15,0,77};
		double l1 = System.currentTimeMillis();
		for(int pass = 1;pass<data.length;pass++) {
			for(int i = 0;i<data.length-1;i++) {
				if(data[i]>data[i+1]) {
				int temp = data[i+1];
				data[i+1] = data[i];
				data[i] = temp;
				}
			}
		}
		double l2 = System.currentTimeMillis();
//		System.out.println(data.toString());
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
//		System.out.println("");
//		System.out.println(l2);
//		System.out.println(l1);
		bubbleSort(data);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		
			
	}

}
