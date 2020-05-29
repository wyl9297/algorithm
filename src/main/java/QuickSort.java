import java.util.Random;

public class QuickSort{

    static void printArray( String msg , int[] arr ){
        System.out.print(msg);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /**
     * 无复杂加减方法
     * */
    public static class QuickSortNoCal {

        private static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                //将数组分为两部分
                int index = partition(arr, low, high);
                //将前半部分再进行快排
                quickSort(arr, 0, index - 1);
                //将后半部分再进行快排
                quickSort(arr, index + 1, high);
            }
        }

        private static int partition(int[] arr, int left, int right) {
            // 基准数据:在原始数组中随机取一个数出来（这里取最左边的位置），留出一个空位置(为了便于识别 把空位置设为 -1)
            int basic = arr[left];
            printArray("原数组:" , arr);
            arr[left] = -1;
            System.out.println("basic = " + basic);
            while (left < right) {
                //右边的数要大于等于原来空位置上的数则，右边界左移
                while (left < right && arr[right] >= basic) {
                    right--;
                }
                //把右边第一个小于那个原来空位置上的数放到空位置上去，腾出了一个新的空位置(为了便于识别 把空位置设为 -1)
                arr[left] = arr[right];
                arr[right] = -1;
                printArray("arr[right] = arr["+right+"] = "+ arr[right] +" 转移到arr[left] = arr["+ left +"]="+ arr[left] +" 后的数据：",arr);
                //左边的数要小于等于原来空位置上的数则，左边界右移
                while (left < right && arr[left] <= basic) {
                    left++;
                }
                //把左边第一个大于那个原来空位置上的数放到新的空位置上去，腾出了一个新的空位置(为了便于识别 把空位置设为 -1)
                arr[right] = arr[left];
                arr[left] = -1;
                printArray("arr[left] = arr["+left+"] = "+ arr[left] +" 转移到arr[right] = arr["+ right +"]="+ arr[right] +" 后的数据：",arr);
            }
            //此时，以left下标为分界线，left的左边的数都比随机取出的数basic要小，left的右边的数都比随机取出来的数basic要大
            //把随机取出来的数放到分界线下标的空位置上去
            arr[left] = basic;
            //返回分界线的下标
            System.out.println("分界位置：arr[left] = arr[" + left + "] = " + arr[left] );
            return left;
        }

        private static int partitionNoPrint(int[] arr, int left, int right) {
            // 基准数据:在原始数组中随机取一个数出来（这里取最左边的位置），留出一个空位置
            int basic = arr[left];
            while (left < right) {
                //右边的数要大于等于原来空位置上的数则，右边界左移
                while (left < right && arr[right] >= basic) {
                    right--;
                }
                //把右边第一个小于那个原来空位置上的数放到空位置上去，腾出了一个新的空位置
                arr[left] = arr[right];
                //左边的数要小于等于原来空位置上的数则，左边界右移
                while (left < right && arr[left] <= basic) {
                    left++;
                }
                //把左边第一个大于那个原来空位置上的数放到新的空位置上去，腾出了一个新的空位置
                arr[right] = arr[left];
            }
            //此时，以left下标为分界线，left的左边的数都比随机取出的数basic要小，left的右边的数都比随机取出来的数basic要大
            //把随机取出来的数放到分界线下标的空位置上去
            arr[left] = basic;
            //返回分界线的下标
            return left;
        }

        public static void main(String[] args) {
            int arr[] = new int[]{2,5,7,4,1,0,6,8,3};
            QuickSortNoCal.quickSort(arr, 0, arr.length - 1);
            printArray("排序后：", arr);
        }
    }
}