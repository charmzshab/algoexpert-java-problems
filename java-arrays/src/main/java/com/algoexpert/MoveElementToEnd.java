package com.algoexpert;

import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {

    }
    /*Move Element To End☆
You're given an array of integers and an integer.Writeafunction that moves all instances of
that integer in the array to the end of the array and returns the array.
The function should perform this in place(i.e.,it should mutate the input array)and doesn't
need to maintain the order of the other integers.
Sample Input
 array=[2,1,2,2,2,3,4,2]
 toMove=2

 Sample Output
  [1,3,4,2,2,2,2,2]// the numbers1,3,and4could be ordered differently
   */

    //O(n)time|0(1)space wherenis the length of the array
    public static List<Integer>moveElementToEnd(List<Integer> array, int toMove){
        int i=0;
        int j=array.size()-1;
        while(i<j){
            while(i<j&& array.get(j)== toMove)j--;
            if(array.get(i)== toMove)swap(i,j,array);
            i++;
        }
        return array;
    }
    public static void swap(int i,int j,List<Integer>array){
        int temp=array.get(j);
        array.set(j,array.get(i));
        array.set(i,temp);
    }
}
