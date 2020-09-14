package com.gong.demo;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
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
//    System.out.println("冒泡排序结果"+ Arrays.toString(arrars));

//    int[] aaa = new int[]{2,3,4,1,33,22,55,11,10};
//    for (int i = (aaa.length-1)/2;i>=0;i--){
//        downAdjust1(aaa,i,aaa.length);
//    }
//      System.out.println(Arrays.toString(aaa));

//      System.out.println(addOperation("666666666666666666666666","999999999999999999999999"));

//      System.out.println(getPower(2.1,-1));
      System.out.println(text("asdafghjka","aafasd"));

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
            //可优化为  int index = startIndex + (startIndex+endIndex) / 2  防止在数组过大时，相加之和溢出
            //追求性能的条件下可转化为位运算  int index = startIndex + ((startIndex+endIndex)>>1)
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
     * 二分法查找指定元素在有序递增的队列中的最小下标
     * @param a
     * @param element
     * @return -- 最小下标
     */
    public static int getMinIndex(int[] a,int element) {
        int left = 0;
        int right = a.length-1;
        while (left<right){
            int temp = (left + right) / 2;
            if(a[temp] >= element){
                right = temp;
            }else {
                left = temp+1;
            }
        }
        if (a[right] == element){
            return right;
        }
        return -1;
    }

    /**
     * 二分法查找指定元素在有序递增的队列中的最大下标
     * @param a
     * @param element
     * @return  -- 最大下标
     */
    public static int getMaxIndex(int[] a,int element) {
        int left = 0;
        int right = a.length-1;
        while (left<right){
            int temp = (left + right +1) / 2;
            if(a[temp] <= element){
                left = temp;
            }else {
                right = temp-1;
            }
        }
        if (a[left] == element){
            return left;
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
     * 快速排序
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

    /**
     * 双边循环法
     * @param arrays
     * @param startIndex
     * @param endIndex
     * @return
     */
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

    /**
     * 最小堆 下沉操作
     * @param arrays
     * @param parentIndex 要下沉的父节点
     * @param length  数组的有效长度
     */
    public static void minDownAdjust(int[] arrays,int parentIndex,int length){
        int temp = arrays[parentIndex];
        int childrenIndex = 2 * parentIndex + 1;
        while (childrenIndex < length){
            //如果有右孩子，并且右孩子小于左孩子，则定位到右孩子
            if (childrenIndex+1<length && arrays[childrenIndex+1]<arrays[childrenIndex]){
                childrenIndex++;
            }
            //如果父节点小于等于左右孩子的最小值，直接返回
            if (temp <= arrays[childrenIndex]){
                break;
            }
            arrays[parentIndex] = arrays[childrenIndex];
            parentIndex = childrenIndex;
            childrenIndex = childrenIndex*2 + 1;
        }
        arrays[parentIndex] = temp;
    }

    /**
     * 最大堆 下沉操作
     * @param arrays
     * @param parentIndex
     * @param length
     */
    public static void maxDownAdjust(int[] arrays,int parentIndex,int length){
        int temp = arrays[parentIndex];
        int childrenIndex = 2 * parentIndex + 1;
        while (childrenIndex < length){
            //如果有右孩子，并且右孩子小于左孩子，则定位到右孩子
            if (childrenIndex+1<length && arrays[childrenIndex+1]>arrays[childrenIndex]){
                childrenIndex++;
            }
            //如果父节点大于等于左右孩子的最小值，直接返回
            if (temp >= arrays[childrenIndex]){
                break;
            }
            arrays[parentIndex] = arrays[childrenIndex];
            parentIndex = childrenIndex;
            childrenIndex = childrenIndex*2 + 1;
        }
        arrays[parentIndex] = temp;
    }

    /**
     * 实现两个超大整数相加的问题
     * long都无法存下
     * @param paramOne
     * @param paramTwo
     * @return
     */
    public static String addOperation(String paramOne,String paramTwo){
        //创建两个数组来分别存放需要计算的两个值
        //数据的长度为较长字符长度+1，+1的目的是最高位进位预留
        int arrayIndex = paramOne.length()<=paramTwo.length()? paramTwo.length()+1:paramOne.length()+1;
        //将待计算的数值倒序存放在数组中
        int[] arrayOne = new int[arrayIndex];
        int[] arrayTwo = new int[arrayIndex];
        for (int i=0;i<paramOne.length();i++){
            arrayOne[i] = (paramOne.charAt(paramOne.length()-1-i) - '0');
        }
        for (int i=0;i<paramTwo.length();i++){
            arrayTwo[i] = (paramTwo.charAt(paramTwo.length()-1-i) - '0');
        }
        //声明结果数组
        int[] result = new int[arrayIndex];
        for (int i=0;i<arrayIndex;i++){
            int temp = result[i];
            temp+= arrayOne[i];
            temp+= arrayTwo[i];
            //判断是否需要进位
            if (temp>=10){
                temp-=10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        //逆序遍历结果数组，从第一个有效位开始输出
        //有效位表示
        boolean significantBitFlag = false;
        for (int i = result.length-1;i>=0;i--){
            if (!significantBitFlag){
                if (result[i]!=0){
                    significantBitFlag = true;
                }
                continue;
            }
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }


    /**
     * 求 x 开根号
     *
     * @param x
     * @param precision 精确到小数点后3位  0.001
     * @return
     */
    private static double sqrt(double x, double precision) {
        if (x < 0) {
            return Double.NaN;
        }
        double low = 0;
        double up = x;
        if (x < 1 && x > 0) {
        /** 小于1的时候*/
            low = x;
            up = 1;
        }
        double mid = low + (up - low)/2;
        while(up - low > precision) {
            if (mid * mid > x ) {//TODO mid可能会溢出
                up = mid;
            } else if (mid * mid < x) {
                low = mid;
            } else {
                return mid;
            }
            mid = low + (up - low)/2;
        }
        return mid;
    }


    /**
     * 求n的m次方
     * @param n
     * @param m
     * @return
     */
    private static double getPower(double n, int m){
        assert m >= 0;
        if(m == 0) return 1;
        if(m == 1) return n;
        double temp = getPower(n,m/2);
        return m%2 == 0? temp * temp: temp * temp * n;
    }

    /**
     * 求两个字符串的最大子串
     * @param s1
     * @param s2
     * @return
     */
    public static String text(String s1,String s2) {
        String max="";String min="";
        max=(s1.length()>s2.length())?s1:s2;
        min=(max==s1)?s2:s1;
        for(int x=0;x<min.length();x++){
            for(int y=0,z=min.length()-x;z!=min.length()+1;y++,z++){
                String temp=min.substring(y, z);
                if(max.contains(temp)) {
                    return temp;
                }
            }
        }
        return null;
    }

}
