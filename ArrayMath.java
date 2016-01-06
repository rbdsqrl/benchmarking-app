package com.myapp.narendran.myapplication;


import java.util.Arrays;

public class ArrayMath {
    public static void BubbleSort(int a[]){
        int temp;
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a.length-1; j++){
                if(a[j]>a[j+1]){
                    temp = a[j+1];
                    a[j+1]=a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static int[] AverageCase(int a) {
        int[] arr = new int[a];
        for (int i=0;i<a;i++)
            arr[i] = (int)(Math.random()*100);

        return arr;
    }

    public static int[] WorstCase(int a) {
        int[] ar = new int[a];
        for(int i=a-1;i!=0;i--){
            ar[i]=i;
        }

        return ar;
    }

    public static int[] clone(int[] a){
        return Arrays.copyOf(a,a.length) ;
    }

    public static int[] BestCase(int a) {
        int[] ar = new int[a];
        for(int i=0;i<a;i++){
            ar[i]=i+1;
        }

        return ar;
    }

    public static void InsertionSort(int a[]){
        int temp;
        for(int i = 1; i<a.length; i++){
            for(int j = 0; j<i; j++){
                if(a[j]>a[i]){
                    temp = a[j];
                    a[j]=a[i];
                    a[i] = temp;
                }
            }
        }
    }

        public static void SelectionSort(int a[]){
        int temp=0,pos=0;
        for(int i = 0; i<a.length; i++){
            temp = a[0];pos=0;
            for(int j = 1; j<a.length-i; j++){
                if(temp<a[j]){
                    temp =a[j];
                    pos = j;
                }
            }
            a[pos] = a[a.length-1-i];
            a[a.length-1-i]=temp;
        }
    }
}

