package com.digi.service;
import java.util.HashMap;
import java.util.Map;
public class Test {

    public static int intoRoman(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Character c = s.charAt(i);
            Integer integer = map.get(c);
            if (integer >= result ) {
                result += integer;
            } else if(integer.equals(map.get(i - 1))){
                result += integer;
            }else {
                result -= integer;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(intoRoman("XXX"));
    }
}
