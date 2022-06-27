package com.algoexpert;

public class ArrayOfProducts {
    public static void main(String[] args) {

    }

    /*Array Of Products✩
Write a function that takes in a non-empty array of integers and returns an array of the same
length,where each element in the output array is equal to the product of every other number
in the input array.
In other words,the value at output[i]is equal to the product of every number in the input
array other than input[i].
Note that you're expected to solve this problem without using division.
Sample Input
 array=[5,1,4,2]
Sample Output
 [8,40,10,20]
 //8is equal to1x4x2
 // 40 is equal to5x4x2
 // 10 is equal to5x1x2
 // 20 is equal to5x1x4
*/
    //O(n^2)time|0(n)space where n is the length of the input array
    public int[] arrayOfProducts(int[] array) {
        int[] products = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int runningProduct = 1;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    runningProduct *= array[j];
                }
                products[i] = runningProduct;
            }
        }
        return products;
    }

    //0(n)time|0(n)space where n is the length of the input array
    public int[] arrayOfProductsV2(int[] array) {
        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];
        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }
        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }
        for (int i = 0; i < array.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }
        return products;
    }


    //0(n)time|0(n)space where n is the length of the input array
    public int[]arrayOfProductsV3(int[]array){
        int[]products=new int[array.length];
        int leftRunningProduct=1;
        for(int i=0;i<array.length;i++){
            products[i]=leftRunningProduct;
            leftRunningProduct*=array[i];
        }
        int rightRunningProduct=1;
        for(int i=array.length-1;i>=0;i--){
            products[i]*=rightRunningProduct;
            rightRunningProduct*=array[i];
        }
        return products;
    }


}
