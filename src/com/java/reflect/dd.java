package com.java.reflect;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by cdc on 2018/3/29.
 */
public class dd {

    /**
     * 采用递归树的思想，当左括号数大于右括号数时可以加左或者右括号，
     * 否则只能加左括号，当左括号数达到n时，剩下全部
     */

    public ArrayList<String> generateParentthesis(int n){
        ArrayList<String> res = new ArrayList<String>();
        String item = new String();
        getGenerateParentList(res,item,n,0,0);
        return res;
    }

    public void getGenerateParentList(ArrayList<String> res, String item,
                                      int n, int lge, int rge){
        if (lge == n){
            for (int i=0; i<n-rge; i++){
                item += ")";
            }
            res.add(new String(item));
            return;
        }
        getGenerateParentList(res, item + "(",n, lge + 1, rge);
        if (lge > rge){
            getGenerateParentList(res, item+")",n,lge,rge+1);
        }
    }

    public static void main(String[] args) {
        dd d = new dd();
        System.out.println(d.generateParentthesis(2).toString());

        ArrayList<String> list = new ArrayList<>(Arrays.asList("I","love","you","too"));
        for (String str : list){
            if (str.length()>3){
                System.out.println(str);
            }
        }

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length() > 3){
                    System.out.println(s);
                }
            }
        });

        list.forEach(str ->{
            if (str.length() > 3)
                System.out.println(str);
        });
    }

}
