package com.algoexpert;


import java.util.*;

public class TwoNumberSum {
    public static void main(String[] args) {


    }

    /* Two Number Sum
    1. Write a function that takes in a non-empty array of distinct integers and an integer
     representing a target sum.If any two numbers in the input array sum up to the target sum,
     the function should return them in an array,in any order.If no two numbers sum up to the
     target sum,the function should return an empty array.
     Note that the target sum has to be obtained by summing two different integers in the array:
     you can't add a single integer to itself in order to obtain the target sum.
     You can assume that there will be at most one pair of numbers summing up to the target
     sum.

     Sample Input
     array=[3,5,-4,8,11,1,-1,6]
     targetSum =10
     */
    //0(nlog(n))|0(1)space
    // solution 1
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum) {
                return new int[]{array[left], array[right]};
            } else if (currentSum < targetSum) {
                left++;
            } else if (currentSum > targetSum) {
                right--;
            }
        }
        return new int[0];
    }

    // solution 2
    //O(n)time|0(n)space
    public static int[]twoNumberSumV2(int[]array,int targetSum){
        Set<Integer>nums=new HashSet<>();
        for(int num:array){
            int potentialMatch=targetSum-num;
            if(nums.contains(potentialMatch)){
                return new int[]{potentialMatch,num};
            }else{
                nums.add(num);
            }
        }
        return new int[0];
    }

    //solution 3
    //O(n^2)time|0(1)space
    public static int[]twoNumberSumV3(int[]array,int targetSum){
        for(int i=0;i<array.length-1;i++){
            int firstNum = array[i];
            for(int j=i+1;j<array.length;j++){
                int secondNum=array[j];
                if(firstNum+secondNum == targetSum){
                    return new int[]{firstNum,secondNum};
                }
            }
        }
        return new int[0];
    }










}
