package com.model;

public class Exercise {
   private Long id;
   private String desc;
   private String input;
   private String output;

   public Exercise(Long id, String desc, String input, String output) {
      this.id = id;
      this.desc = desc;
      this.input = input;
      this.output = output;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
   }

   public String getInput() {
      return input;
   }

   public void setInput(String input) {
      this.input = input;
   }

   public String getOutput() {
      return output;
   }

   public void setOutput(String output) {
      this.output = output;
   }
}
