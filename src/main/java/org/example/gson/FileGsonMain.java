package org.example.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 与文件的json 互转
 */
public class FileGsonMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        //准备工作
        Student student = new Student("张三", 10, new Date());
        File file = new File("student.json");
        if (!file.exists()){
            file.createNewFile();
        }

        //写入文件
        FileWriter fileWriter = new FileWriter(file);
        gson.toJson(student,fileWriter);
        fileWriter.close();

        System.out.println("看下文件内容吧");
        TimeUnit.MILLISECONDS.sleep(10000);

        //文件读出
        FileReader fileReader = new FileReader(file);
        Student student1 = gson.fromJson(fileReader, Student.class);
        System.out.println(student1);
        fileReader.close();
    }
}
