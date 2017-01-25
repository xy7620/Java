package sort;

import java.util.Arrays;

/**
 * @date 2017年1月24日
 * <p>description:</p>
 * <p>简单选择排序，由小到大 </p>
 * 时间复杂度o(n^2)，n+(n-1)+(n-2)+……+1=n*(n+1)/2
 * 步骤：
 * 1、for循环i 遍历数组每个元素
 * 2、（进入for循环i）for循环j 从当前第i个后面开始遍历剩下的元素
 * 3、（进入for循环j）如果第j个大于第i个，互换
 * 4、（退出for循环i、j）遍历完成，排序完成
 */
public class SelectSort {
	//简单排序
	public static void selectSort(int[] is){
		for(int i=0; i<is.length-1; i++){
			for(int j=i+1; j<is.length; j++){
				if(is[j]<is[i]){
					int temp = is[j];
					is[j] = is[i];
					is[i] = temp;
				}
			}
		}
	}
	
	/**
	 * 二元选择排序
	 * @param is
	 * 每次循环确定最小值和最大值，外层循环n/2次即可完成
	 * 注意：
	 * 交换时先在内层循环中使用索引，内层循环完成再进行交换。
	 * 不要直接在内层循环中直接开始交换，因为内层循环中交换了2次，第一次比较寻找小的，如果没有找到，第二次寻找大的，找到了，交换，如果交换回
	 * 一个较小的值，因为内层循环已经过了该值，那么排序就出错了。
	 */
	public static void binarySelectSort(int[] is){
		int len = is.length-1;
		//保存该次循环中，最小值和最大值的索引。使用索引是为了循环后可以用索引来交换。
		int min=0;
		int max=0;
		//只需要遍历n/2
		for(int i=0; i<is.length/2+1; i++){
			//放在本层循环中，每次循环重新赋值
			min = i;
			max = len-i;
			//前后都是第i个界限
			for(int j=i+1; j<is.length-i; j++){
				//min和max是数组索引，比较之后，赋值也用索引赋值。如果是最小，退出本次循环
				if(is[j]<is[min]){
					min = j;
					continue;
				}
				if(is[max]<is[j]){
					max = j;
				}
			}
			//交换本次循环的最值
			int temp = is[i];
			is[i] = is[min];
			is[min] = temp;
			temp = is[len-i];
			is[len-i] = is[max];
			is[max] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] is={2,3,1,1,3,5,0,4,-1,4};
		int[] is1={2,3,1,1,3,5,0,4,-1,4};
		selectSort(is);
		binarySelectSort(is1);
		System.out.println(Arrays.toString(is));
		System.out.println(Arrays.toString(is1));
	}
}
