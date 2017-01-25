package sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2017年1月24日
 * <p>description:</p>
 * <p>直接插入排序，由小到大，时间复杂度O(n~2),n的平方 </p>
 * 步骤：
 * 1、将原数组第一个赋值给新数组
 * 2、遍历原数组剩余元素（一层循环进入），与新数组每一个比较（二层循环进入），
 * 	    直到小于某个元素，在这个位置插入，break（二层循环结束）
 * 3、遍历原数组到第i个，如果新数组第i个小于原数组第i个，说明原数组第i个比新数组所有元素都大，
 *   在新数组第i个插入。
 * 4、原数组遍历完成（一层循环结束）
 */
public class InsertSort {
	//直接插入排序，使用数组实现
	public static void insertSortByArray(int[] is){
		if(is.length == 0){
			System.out.println("数组为空!");
			return;
		}
		//使用数组
		int[] result = new int[is.length];
		result[0] = is[0];
		for(int i=1; i< is.length; i++){
			//注意j与i的关系，j<i，插最后实际上是result数组第i个
			for(int j=0; j< i; j++){
				if(is[i]<result[j]){
					//插入点及之后元素后移一位(从中间插入)
					for(int h=i; h>j; h--){
						result[h] = result[h-1];
					}
					result[j]= is[i];
					break;
				}
			}
			//result数组中第i个小于is[i],说明第i个没有插入进去，则加在最后
			if(result[i]<is[i]){
				result[i]=is[i];
			}
		}
		System.out.println("Array1: "+Arrays.toString(result));
	}
	
	//使用数组，只需要一个数组
	public static void insertSortByUniqueArray(int[] is){
		if(is.length == 0){
			System.out.println("数组为空!");
			return;
		}
		for(int i=1; i<is.length; i++){
			//循环到底i个时，前i-1个最大值为第i-1个
			if(is[i] < is[i-1]){
				int temp = is[i];
				is[i] = is[i-1];
				for(int j=i-1;j>0;j--){
					//第i个与i-2个比较（与i-1比较结果已经知道），决定的是第i-1个的值
					if(temp < is[j-1]){
						is[j] = is[j-1];
					}else{
						is[j] = temp;
						break;
					}
				}
				if(temp<is[0]) is[0] = temp;
			}
		}
		System.out.println("Array2: "+Arrays.toString(is));
	}
	
	//直接插入排序，使用list实现
	public static void insertSortByList(int[] is){
		if(is.length == 0){
			System.out.println("数组为空!");
			return;
		}
		//使用list，linkedList适合插入、删除等操作
		List<Integer> list = new LinkedList<Integer>();
		list.add(is[0]);
		for(int i=1; i< is.length; i++){
			for(int j=0;j<i; j++){
				if(is[i]<list.get(j)){
					//使用list可以不用移动数组
					list.add(j, is[i]);
					break;
				}
			}
			if(list.get(list.size()-1)<=is[i]){
				list.add(is[i]);
			}
		}
		System.out.println("List: "+list.toString());
	}
	public static void main(String[] args) {
		int[] is = {1,5,3,1,0,4,6,2,3};
		int[] is1 = {1,5,3,1,0,4,6,2,3};
		int[] is2 = {1,5,3,1,0,4,6,2,3};
		insertSortByArray(is);
		insertSortByUniqueArray(is1);
		insertSortByList(is2);
	}
}
