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

   public List<Exercise> create() {
      List<Exercise> exercises = new ArrayList<>();

      Exercise exercise1 = new Exercise(1L, "abc", "1 2 3", "2");
      exercises.add(exercise1);

      Exercise exercise2 = new Exercise(2L, "xyz", "7\n8\n9", "3 3");
      exercises.add(exercise2);

      return exercises;
   }
}
