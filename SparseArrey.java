//稀疏数组SparseArrey
public class SparseArrey {

	public static void main(String[] args) {
		//创建一个原始二维数组 11*11大小
		//0 表示没有棋子，1表示黑子，2表示白子(以五子棋盘为例)
		int chessArray[][] = new int[11][11];
		chessArray[1][2] = 1;
		chessArray[2][3] = 2;
		System.out.println("原始的二维数组");
		for(int i =0 ;i < chessArray.length;i++) {
			for(int j=0;j<chessArray.length;j++) {
				System.out.print(chessArray[i][j]);
			}
			System.out.println("");
		}
		//将二维数组转为稀疏数组
		/*思路
		 * 1.先遍历原始二维数组，得到有效数据的个数 sum
		 * 2.根据sum就可以创建稀疏数组
		 * 3.将二维数组的有效数据存入稀疏数组中
		 * (稀疏数组一般有sum+1行, 3列，第一行存放原始数组有多少列、多少行、以及sum)
		 * 
		 * 
		 * 稀疏数组转原始二维数组的思路
		 * 1.先读取稀疏数组第一行，获取原始二维数组的信息，并创建原始数组
		 * 2.再读取稀疏数组后几行的数据，并为原始二维数组赋值即可
		 * 
		 */
		
		int sum = 0;
		for (int i = 0; i < chessArray.length; i++) {
			for (int j = 0; j < chessArray.length; j++) {
				if(chessArray[i][j]!=0)
					sum++;
			}
		}
//		System.out.println(sum);
		//创建稀疏数组
		int sparseArray[][] = new int[sum+1][3];
		//给稀疏数组赋值
		sparseArray[0][0] = chessArray.length;
		sparseArray[0][1] = chessArray[0].length;
		sparseArray[0][2] = sum;
		
		//遍历二维数组，将其中非0的值存放到稀疏数组中
		int count = 1;//count用于记录是第几个非零数据
		for (int i = 0; i < chessArray.length; i++) {
			for (int j = 0; j < chessArray.length; j++) {
				if(chessArray[i][j]!=0) {
					sparseArray[count][0] = i;
				    sparseArray[count][1] = j;
				    sparseArray[count][2] = chessArray[i][j];
				    count++;
				}
			}	
		}
		
		//输出稀疏数组
		System.out.println("稀疏数组：");
		for(int i =0 ;i < sparseArray.length;i++) {
			for(int j=0;j<sparseArray.length;j++) {
				System.out.print(sparseArray[i][j] +" ");
			}
			System.out.println("");
		}
		
		//恢复成原始的二维数组
		int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
		for (int i = 1; i < sparseArray.length; i++) {
			chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		
		//输出原始数组
		System.out.println();
		System.out.println("恢复的原始数组：");
		for(int i =0 ;i<chessArray2.length;i++) {
			for(int j=0;j<chessArray2.length;j++) {
				System.out.print(chessArray2[i][j] +" ");
			}
			System.out.println("");
		}

	}
}