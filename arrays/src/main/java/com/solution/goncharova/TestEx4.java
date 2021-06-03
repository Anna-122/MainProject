package com.solution.goncharova;

public class TestEx4 {
    public static void main(String[] args) {
        int i, len_max, len_ser, start ;
        int x[] = {5,10,7,8,1,2,3} ;
        len_max = 0;
        len_ser = 0;
        start = 0;
        { for(i=0; i<x.length; i++) {
            if(x[i]==0)
            {len_ser = len_ser + 1;}
            else
            {if (len_ser > len_max)
                len_max = len_ser;
                start = i - len_ser;
            }
            len_ser=0;
        }
        }
        System.out.println (len_max);
    }
}
