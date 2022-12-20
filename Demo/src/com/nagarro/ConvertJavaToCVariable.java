package com.nagarro;


public class ConvertJavaToCVariable {
    public static void main(String[] s){
        String input = "_snake_case_to_camel_case_";
        if(input.contains("_")){
            System.out.println(convertSnakeCaseToCamel(input));
        }else{
            System.out.println(convertCamelCaseToSnakeCase(input));
        }
    }

    public static String convertSnakeCaseToCamel(String input){
        input = input.substring(0,1).toUpperCase() + input.substring(1);
        StringBuilder builder = new StringBuilder(input);

        if(builder.substring(builder.length() - 1).equals("_"))
            builder.deleteCharAt(builder.length()-1);

        for (int i=0;i<builder.length();i++){
            if(builder.charAt(i) == '_'){
                builder.deleteCharAt(i);
                builder.replace(i, i+1, String.valueOf(Character.toUpperCase(builder.charAt(i))));
            }
        }
        return builder.toString();
    }

    public static String convertCamelCaseToSnakeCase(String input){
        String result = "";
        char c = input.charAt(0);
        result = result + Character.toLowerCase(c);

        for(int i=1; i<input.length();i++){
            char ch = input.charAt(i);
            if(Character.isUpperCase(ch)){
                result = result + '_';
                result = result + Character.toLowerCase(ch);
            } else {
                result = result + ch;
            }
        }
        return result;
    }
}
