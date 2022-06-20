package org.example.gson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
   private String name; 
   private int age;
   private Date createTime;


   @Override
   public String toString() { 
      return "Student [ name: "+name+", age: "+ age+ " ]"; 
   }  
}

