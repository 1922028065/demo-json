package org.example.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 基本数据类型 基本对象 互转
 */
public class RawDataGsonMain {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String name = "Maxsu";
        long rollNo = 1;
        boolean verified = false;
        int[] marks = {100,90,85};
        List list = new ArrayList();
        list.add(new Student("张三",10,new Date()));
        list.add(new Student("李四",20,new Date()));



        //serialization
        System.out.println("{");
        System.out.println("name: " + gson.toJson(name) +",");
        System.out.println("rollNo: " + gson.toJson(rollNo) +",");
        System.out.println("verified: " + gson.toJson(verified) +",");
        System.out.println("marks:" + gson.toJson(marks));
        System.out.println("list:" + gson.toJson(list));
        System.out.println("}");

        //De-serialization
        name = gson.fromJson("\"Maxsu\"", String.class);
        rollNo = gson.fromJson("1", Long.class);
        verified = gson.fromJson("false", Boolean.class);
        marks = gson.fromJson("[100,90,85]", int[].class);

        //匿名内部类
        Type type = new TypeToken<ArrayList<Student>>() {}.getType();
        list = gson.fromJson("[{\"name\":\"张三\",\"age\":10,\"createTime\":\"Jun 20, 2022 11:36:40 PM\"},{\"name\":\"李四\",\"age\":20,\"createTime\":\"Jun 20, 2022 11:36:40 PM\"}]", type);

        System.out.println("name: " + name);
        System.out.println("rollNo: " + rollNo);
        System.out.println("verified: " +verified);
        System.out.println("marks:" + Arrays.toString(marks));
        System.out.println("list:" + list);






    }
}
