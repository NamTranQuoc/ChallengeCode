package com.model;

import java.util.ArrayList;
import java.util.List;

public class CreateDb {
   private static CreateDb instance = null;

   private CreateDb() {
   }

   public static CreateDb getInstance() {
      if (instance == null) {
         instance = new CreateDb();
      }
      return instance;
   }

   public static List<Exercise> exercises;

   public void create() {
      exercises = new ArrayList<>();

      Exercise exercise1 = new Exercise(1L, "Bạn hãy viết chương trình hiển thị ra màn hình dòng chữ: Hello World!!", "", "Hello World!!");
      exercises.add(exercise1);

      Exercise exercise2 = new Exercise(2L, "xyz", "7 8 9", "3 3");
      exercises.add(exercise2);
   }

   public Exercise getById(Long id) {
      Exercise exercise = null;
      for (Exercise e: exercises) {
         if (e.getId() == id) {
            exercise = e;
            break;
         }
      }
      return exercise;
   }
}
