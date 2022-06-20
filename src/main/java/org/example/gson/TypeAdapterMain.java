package org.example.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * 自定义序列过程  类型适配器
 */
public class TypeAdapterMain {
    public static void main(String args[]) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Student.class, new StudentAdapter());
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String jsonString = "{\"name\":\"Maxsu\", \"age\":1}";
        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student);

        jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }




    static class StudentAdapter extends TypeAdapter<Student> {
        @Override
        public Student read(JsonReader reader) throws IOException {
            Student student = new Student();
            reader.beginObject();
            String fieldname = null;

            while (reader.hasNext()) {
                JsonToken token = reader.peek();

                if (token.equals(JsonToken.NAME)) {
                    //get the current token
                    fieldname = reader.nextName();
                }
                if ("name".equals(fieldname)) {
                    //move to next token
                    token = reader.peek();
                    student.setName(reader.nextString());
                }
                if("age".equals(fieldname)) {
                    //move to next token
                    token = reader.peek();
                    student.setAge(reader.nextInt());
                }
            }
            reader.endObject();
            return student;
        }
        @Override
        public void write(JsonWriter writer, Student student) throws IOException {
            writer.beginObject();
            writer.name("nameNew");
            writer.value(student.getName());
            writer.name("ageNew");
            writer.value(student.getAge()+1);
            writer.endObject();
        }
    }


}
