package com.interview.test;

import java.util.ArrayList;
import java.util.List;

public class AddBorderElementIn2DArray {
    public static void main(String[] s){
        Integer[][] mat = new Integer[4][4];
        int counter = 1;
        List<Integer> sortedList = new ArrayList<>();
        for(int i=1;i<=12;i++){
            sortedList.add(i);
        }
        int index = 0;
        int lastIndex = sortedList.size() - 1;
        for(int x=0;x<mat.length;x++){
            if(index <= sortedList.size()-1){
                for(int y=0;y<mat[x].length;y++){
                    if (x == 0){
                        mat[x][y] = sortedList.get(index);
                    } else if(y == 0){
                        mat[x][y] = sortedList.get(lastIndex);
                    } else if(x == mat.length - 1){
                        mat[x][y] = sortedList.get(lastIndex);
                    } else if(y == mat[x].length - 1) {
                        mat[x][y] = sortedList.get(index);
                    }
                    index++;
                    lastIndex--;
                    System.out.print(mat[x][y]+" ");
                }
            }
            System.out.println();
        }



    }
}
