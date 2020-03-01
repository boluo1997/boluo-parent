package cn.tedu;

public class TestSearch {
    public static void main(String[] args) {
        int[] array = {1,5,6,9,13,21,25,39,57,69,78,95};
        int index = binarySearch2(array,57);

        if(index == -1){
            System.out.println("查找结果不存在!");
        }else {
            System.out.println(index);
        }

    }

    //非递归方法
    public static int binarySearch(int[] array,int key){
        //返回的是索引值

        int low = 0;
        int high = array.length-1;

        while(low <= high){

            int mid = (low+high)/2;

            if(array[mid] == key){
                return mid;
            }else if(key < array[mid]){
                high = mid - 1;
            }else {     //key > array[mid]
                low = mid + 1;
            }
        }
        return -1;
    }

    //递归方法
    public static int binarySearch2(int[] array,int key){
        //返回的是索引值

        int low = 0;
        int high = array.length-1;

        return binarySearch3(array,key,low,high);
    }

    public static int binarySearch3(int[] array,int key,int low,int high){

        int mid = (low + high)/2;

        //递归结束条件
        if(low > high){
            return -1;
        }else if(key == array[mid]){
            return mid;
        }else if(key < array[mid]){
            high = mid - 1;
            return binarySearch3(array,key,low,high);
        }else {     //key > array[mid]
            low = mid + 1;
            return binarySearch3(array,key,low,high);
        }
    }

}
