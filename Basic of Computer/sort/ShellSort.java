package sort;

import java.util.Arrays;

/**
 * @date 2017年1月24日
 * <p>description:</p>
 * <p>希尔排序,缩小增量排序，由小到大 </p>
 * 步骤：
 * 1、while循环获取增量n为长度的1/2，1/4……直到n小于1
 * 2、（进入while循环）修改增量，for循环从0开始，直到加上n等于数组长度，即增量为n时遍历完成
 * 3、（进入for循环）如果当前值大于当前序号+增量的元素，两个元素互换
 * 4、（for循环结束）（while结束）
 */
public class ShellSort {

	public static void shellSort(int[] is){
		int n=is.length/2;
		int i=1;
		while(n >= 1){
			n = is.length/(++i);
			for(int j=0;j+n < is.length; j++){
				if(is[j]>is[j+n]){
					int temp = is[j];
					is[j] = is[j+n];
					is[j+n] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(is));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] is = {2,1,3,6,2,5,1,5,0};
		shellSort(is);
	}

}
