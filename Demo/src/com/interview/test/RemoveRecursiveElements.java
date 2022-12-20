package com.interview.test;

public class RemoveRecursiveElements {

    public static void main(String[] s){
        String str1 = "geeekksforgeegg";
        System.out.println(remove(str1));
        //System.out.println(oldVersion(str1));
    }

    static String remove(String str){
        char last_removed = '\0';
        return removeUtil(str, last_removed);
    }

    static String removeUtil(String str, char last_removed){
        if (str.length() == 0 || str.length() == 1)
            return str;
        if (str.charAt(0) == str.charAt(1))
        {
            last_removed = str.charAt(0);
            while (str.length() > 1 && str.charAt(0) ==
                    str.charAt(1))
                str = str.substring(1, str.length());
            str = str.substring(1, str.length());
            return removeUtil(str, last_removed);
        }
        String rem_str = removeUtil(str.substring(
                1,str.length()), last_removed);
        if (rem_str.length() != 0 &&
                rem_str.charAt(0) == str.charAt(0))
        {
            last_removed = str.charAt(0);
            return rem_str.substring(1,rem_str.length());
        }
        if (rem_str.length() == 0 && last_removed ==
                str.charAt(0))
            return rem_str;
        return (str.charAt(0) + rem_str);
    }

    static String oldVersion(String input){
        char[] arrInput = input.toCharArray();
        String res = String.valueOf(arrInput);;
        if(input.length() == 0 || input.length() == 1)
            return input;
        for(int i=0;i<arrInput.length;i++){
            boolean change = false;
            for(int j=i+1;j<arrInput.length;j++){
                if(arrInput[j] != arrInput[i]) {
                    break;
                }else{
                    change = true;
                    arrInput[j] = '#';
                }
            }
            if(change)
                arrInput[i] = '#';
            if(i == arrInput.length -1 && arrInput[i-1] == arrInput[i]){
                arrInput[i] = '#';
            }
        }
        res = String.valueOf(arrInput);
        while(res.contains("#")){
            System.out.println("with "+res);
            res = res.replaceAll("#","");
            System.out.println("without "+res);
            res = oldVersion(res);
        }

        return res;
    }
}
