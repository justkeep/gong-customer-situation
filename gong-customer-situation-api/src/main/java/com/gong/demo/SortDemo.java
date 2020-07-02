package com.gong.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 二分法查找一个元素在数组中的位置
 */
public class SortDemo {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,2,88,6,23,45,66,77,99,800);
//    System.out.println(DichotomyDemo.getIndex(list,801));
    int[] arrars = new int[]{3,6,7,4,1,4,3,11};
      fastSort(arrars,0,arrars.length-1);
    System.out.println("冒泡排序结果"+ Arrays.toString(arrars));
  }
  /**
   * 二分法查询指定元素所在位置
   * @param list 从小到大的有序list
   * @param element 指定元素
   * @return 返回指定元素所在下标
   */
    public static int getIndex(List<Integer> list,int element) {
        int startIndex = 0;
        int endIndex = list.size()-1;
        while (startIndex<=endIndex){
          int index = (startIndex + endIndex) / 2;
          if (list.get(index) == element){
            return index;
          }
          if (list.get(index)>element){
            endIndex = index-1;
          }
          if (list.get(index)<element){
            startIndex= index+1;
          }
        }
        return -1;
    }

  /**
   * 冒泡排序
   * @param arrays
   * @return
   */
    public static int[] bubbleSort(int[] arrays){
        for (int i=1;i<arrays.length;i++){
          for (int j=0;j<arrays.length-i;j++){
              if (arrays[j]>arrays[j+1]){
                int temp = arrays[j];
                arrays[j] = arrays[j+1];
                arrays[j+1] = temp;
              }
          }
        }
        return arrays;
    }


    /**
     * 快速排序 双边循环法
     * @param arrays
     * @param startPoint
     * @param endIndex
     */
    public static void fastSort(int[] arrays,int startPoint,int endIndex){
        if (startPoint>=endIndex){
            return;
        }
        int i = divisionIndex2(arrays, startPoint, endIndex);
        fastSort(arrays,startPoint,i-1);
        fastSort(arrays,i+1,endIndex);
    }

    private static int divisionIndex(int[] arrays,int startIndex,int endIndex){
        int baseline = arrays[startIndex];
        int leftPoint = startIndex;
        int rightPoint = endIndex;
        while(leftPoint!=rightPoint){
            /**
             * 先移动右指针简直是经典之作
             * 不信可以将两个while 换下位置，你会有意想不到的结果
             */
            while (arrays[rightPoint]>baseline && rightPoint>leftPoint){
                rightPoint--;
            }
            while (arrays[leftPoint]<=baseline && leftPoint<rightPoint){
                leftPoint++;
            }

            if (leftPoint<rightPoint){
                //左右指针对应的下标交换值
                int temp = arrays[leftPoint];
                arrays[leftPoint] = arrays[rightPoint];
                arrays[rightPoint] = temp;
            }
        }
        arrays[startIndex] = arrays[leftPoint];
        arrays[leftPoint] = baseline;
        return leftPoint;
    }

    /**
     * 快排（单边循环）
     * @param arrays
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int divisionIndex2(int[] arrays,int startIndex,int endIndex){
        int mark = startIndex;
        Random rand = new Random();
        //随机选取基准数的下标
        int randIndex = rand.nextInt(endIndex-startIndex+1) +startIndex;
        if (randIndex!=startIndex){
            int temp = arrays[startIndex];
            arrays[startIndex] = arrays[randIndex];
            arrays[randIndex] = temp;
        }
        //获取基准数
        int pivotIndex = arrays[startIndex];
        for (int i=startIndex+1;i<=endIndex;i++){
            if (arrays[i]<pivotIndex){
                mark = mark+1;
                int p = arrays[mark];
                arrays[mark] = arrays[i];
                arrays[i] = p;
            }
        }
        arrays[startIndex] = arrays[mark];
        arrays[mark] = pivotIndex;
        return mark;
    }
}
