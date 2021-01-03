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

      exercises.add(new Exercise(1L, "Bạn hãy viết chương trình hiển thị ra màn hình dòng chữ: Hello World!!", "", "Hello World!!"));

      exercises.add(new Exercise(2L, "Viết chương trình tính tổng hai chữ số nguyên a, b cho trước", "7 8", "15"));
      exercises.add(new Exercise(3L, "Viết chương trình tính và in ra chu vi, diện tích của hình chữ nhật cho biết trước chiều dài (d) và chiều rộng (r)", "20 10", "60 200"));
      exercises.add(new Exercise(4L, "Tìm số nguyên lớn nhất trong 3 số a, b, c cho trước", "7 6 16", "16"));
      exercises.add(new Exercise(5L, "Số chính phương là số tự nhiên mà căn bậc hai của nó là một số tự nhiên. Hoặc nói ngược lại, số chính phương là số bằng bình phương của một số tự nhiên. Nhiệm vụ của bạn là viết chương trình kiểm tra một số nguyên n cho trước có phải là số chính phương hay không?", "9", "YES"));
      exercises.add(new Exercise(6L, "Viết chương trình làm tròn số thực n cho trước về số nguyên gần nhất (chênh lệch giá trị nhỏ nhất).", "12.567", "13"));
      exercises.add(new Exercise(7L, "Viết chương trình liệt kê các ước nguyên dương của số nguyên n cho trước theo thứ tự giảm dần.", "8", "8 4 2 1"));
      exercises.add(new Exercise(8L, "Viết chương trình tìm số đảo ngược của 1 số nguyên dương n cho trước.", "1234", "4321"));
      //exercises.add(new Exercise(9L, "xyz", "7 8 9", "3 3"));
      //exercises.add(new Exercise(10L, "xyz", "7 8 9", "3 3"));
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
