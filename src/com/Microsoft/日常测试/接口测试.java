package com.Microsoft.日常测试;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2019/11/30 15:11
 */
public class 接口测试 {
 public static List<Person> s(List<Person> person, Predicate<Person> predicate){
     ArrayList<Person> destList = new ArrayList<Person>();
     for (Person employee : person) {
         if(predicate.test(employee)) {
             destList.add(employee);
         }
     }
     return destList;
 }



    public static void main(String[] args) {
        List<Person> li= Arrays.asList(new Person("xlw", 123),new Person("alw", 234),new Person("blw", 1),new Person("xlw", 13));
        List<Person> res=s(li,(a)->a.getAge()>100);
        System.out.println("");
        List<Person> ress=s(li,(a)->a.getName().compareTo("xlw")==0);
        res.forEach(System.out::print);
        System.out.println("");
        ress.forEach(System.out::print);
        }

}
