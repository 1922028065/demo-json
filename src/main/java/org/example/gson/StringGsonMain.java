package org.example.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.gson.Student;

import java.lang.reflect.Modifier;

/**
 * 与字符串的 互转
 */
public class StringGsonMain {

   public static void main(String[] args) {
      String jsonString = "{\"name\":\"Maxsu\", \"age\":24}";
      /**
       * 1.通过GsonBuilder构建 gson 对象
       * 2.JSON反序列化为对象  fromJson
       * 3.对象序列化为JSON tojson
       */
      GsonBuilder builder = new GsonBuilder();
      builder.setPrettyPrinting();
      /**
       * 序列化null,
       */
      //builder.serializeNulls();
      /**
       * 排除字段打了哪种标记符的字段不进行序列化
       * Modifier.TRANSIENT  标记了 transient 的字段
       */
      builder.excludeFieldsWithModifiers(Modifier.TRANSIENT);

      /**
       * 配合注解@Expose 来决定需要序列号的字段
       */
      //builder.excludeFieldsWithoutExposeAnnotation();
      //自定义要排除的字段
      //builder.addSerializationExclusionStrategy()







      Gson gson = builder.create();
      //从 String -> Object
      Student student = gson.fromJson(jsonString, Student.class);

      System.out.println(student);

      //从 Object -> String
      String s = gson.toJson(student);
      System.out.println(s);
   } 
}


