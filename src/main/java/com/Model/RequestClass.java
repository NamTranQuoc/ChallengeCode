package com.model;

public class RequestClass {
   private String language;
   private String content;


   public String getLanguage() {
      return language;
   }

   public void setLanguage(String language) {
      this.language = language;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public RequestClass () {}

   public RequestClass (String content, String language) {
      this.content = content;
      this.language = language;
   }
}
