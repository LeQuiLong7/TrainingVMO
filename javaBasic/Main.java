package javaBasic;

import collection.Person;

public class Main {
    public static void main(String[] args) {

        // variables, data type in java
        int a = 10;
        double b = 5.6;
        String s = "abc";
        Person p = new Person(1, "abc");


        // array in java
        int[] arr = {1, 5, 32, 6};
        int[] arr2 = new int[5];


        // get element in an array by index
        int n = arr[0];
        // arr.length to get the length of the array
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // or
        for(int i : arr) {
            System.out.println(i);
        }

        // if, else if, else
        if(arr[0] == 1) {
            System.out.println("arr[0] = 1");
        }else if(arr[0] == 2) {
            System.out.println("arr[0] = 2");
        } else {
            System.out.println("arr[0] != 1 and arr[0] != 2");
        }
        // switch case, default
        switch (arr[0]) {
            case 1 -> System.out.println("arr[0] = 1");
            case 2 -> System.out.println("arr[0] = 2");
            default -> System.out.println("arr[0] != 1 and arr[0] != 2");
        }





    }
}
