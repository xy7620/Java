package sort;

import java.util.Arrays;

/**
 * @date 2017年1月25日
 * <p>description:</p>
 * <p>堆排序，由大到小，时间复杂度O(nlog2n)，详情见下 </p>
 * n个数组元素，则堆深度为【log2n+1】（向下取整）
 * heapAdjust()为O(log2n)，heapSort()为O(nlog2n)
 */
public class HeapSort {

	/**
	 * 将第s个元素及它的子树变成堆（核心方法）
	 * @param is
	 * @param s 可能要调整的节点（现在破坏堆的节点）
	 * @param length 要调整的数组的长度（可能不是数组中所有的元素都进入堆排序）
	 * 此方法复杂度与堆深度有关，n个数组元素，深度【log2n+1】，时间复杂度O(log2n)
	 * 用途：
	 * 1、循环调用构造堆
	 * 2、输出堆顶后，调整剩余的n-1个元素，成为新堆
	 */
	public static void heapAdjust(int[] is, int s, int length){
		int temp = is[s];
		//左孩子
		int minChild = 2*s;
		while(minChild < length-1){
			//如果左孩子大于右孩子，将child赋值为右孩子索引（结果都是child为左右孩子小的）
			if(is[minChild] > is[minChild+1]){
				minChild++;
			}
			//节点大于子节点，调整。否则已经是正常堆，退出循环。
			if(is[s] > is[minChild]){
				is[s] = is[minChild];
				is[minChild] = temp;
				//调整s为交换的孩子索引（s又变成下次循环可能调整的节点）
				s = minChild;
				minChild = 2*s;
			}else{
				break;
			}
		}
	}
	/**
	 * 初始数组建立堆
	 * @param is
	 * @param length
	 * 从最后一个有孩子的节点开始，循环向左向上，每次循环只调整本节点作为跟节点的堆
	 * 把本节点及子树（子节点）调用heapAdjust()变成正常堆，直到根节点和它的子树已经变成堆。
	 */
	public static void buildHeap(int[] is, int length){
		for(int i=(length - 1)/2; i>=0; --i){
			heapAdjust(is, i, length); 
		}
	}
	//输出堆
	public static void printHeap(int[] is){
		for(int i=0,j=1;i<is.length; i++){
			System.out.print(is[i]+" ");
			if(i+1==j){
				System.out.println();
				j = 2*j+1;
			}
		}
	}
	/**
	 * 堆排序
	 * @param is
	 * 步骤：
	 * 1、buildHeap()初始数组建立堆（小顶堆）
	 * 2、for循环，从数组长度减1开始遍历
	 * 3、（进入循环）取出数组第一个元素，与数组最后一个交换。第一个是最小值，最后一个是堆的最后一个孩子，
	 * 	    每次将最后一个孩子与第一个交换，可以一直保持完全二叉树的结构，只用交换节点来调整堆。
	 * 4、调用heapAdjust()方法，传入数组、0（本次调整的节点）和数组长度
	 * 	    交换到数组后的元素已经是排好序的，不再作为堆的元素，这样完成了本次取出最小元素后重新构造堆的过程
	 * 5、遍历完成（退出循环），由大到小排好序。（如果是大顶堆，排序结果是由小到大）
	 */
	public static void heapSort(int[] is){
		if(is.length==0){
			System.out.println("数组为空！");
		}
		buildHeap(is, is.length);
		for(int i=is.length-1; i>0; i--){
			int temp = is[0];
			is[0] = is[i];
			is[i] = temp;
			heapAdjust(is, 0, i);
		}
	}
	public static void main(String[] args) {
		int[] is = {3,1,10,-2,0,-8,1,3,1,4,6,2,6,4,3,7,9,2};
		heapSort(is);
		System.out.println(Arrays.toString(is));
	}

}
