package com.Control;

import com.jcraft.jsch.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Properties;


public class testConnect {

   /**
    * JSch Example Tutorial
    * Java SSH Connection Program
    */
   public static void main(String[] args) {
      /*
      String host="13.59.25.143";
      String user="ubuntu";
      String password="123456a@";
      String command1="sudo docker exec c3compile bash /data/compilec3.sh";
      String command2="sudo docker ps";

      String pathServer = "data/Main.cs";
      try{

         Properties config = new Properties();
         config.put("StrictHostKeyChecking", "no");
         JSch jsch = new JSch();
         Session session=jsch.getSession(user, host, 22);
         session.setPassword(password);
         session.setConfig(config);
         session.connect();
         System.out.println("Connected");

         ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
         channelSftp.connect();
         channelSftp.put(new ByteArrayInputStream("code".getBytes()), pathServer);
         channelSftp.exit();

         Channel channel=session.openChannel("exec");
         ((ChannelExec)channel).setCommand(command1);
         channel.setInputStream(null);
         ((ChannelExec)channel).setErrStream(System.err);

         InputStream in=channel.getInputStream();
         channel.connect();
         byte[] tmp=new byte[1024];
         while(true){
            while(in.available()>0){
               int i=in.read(tmp, 0, 1024);
               if(i<0) break;
               System.out.print(new String(tmp, 0, i));
            }
            if(channel.isClosed()){
               System.out.println("exit-status: "+channel.getExitStatus());
               break;
            }
            try{Thread.sleep(1000);}catch(Exception ee){}
         }
         channel.disconnect();
         session.disconnect();
         System.out.println("DONE");
      }catch(Exception e){
         e.printStackTrace();
      }
       */
      GetNamespace("class HelloWorld {\n" +
              "    public static void main( String []args ) {\n" +
              "        System.out.println( \"Hello World!\" );\n" +
              "    }\n" +
              "}");
   }

   public static String GetNamespace(String code) {
      String namespace = "";
      char tempt = '{';
      int end = -1, start = -1;
      for (int i = 0; i < code.length(); i++) {

         if (code.charAt(i) == tempt) {

            for (int j = i - 1; j >= 0; j--) {
               if (code.charAt(j) != ' ') {
                  end = j;
                  break;
               }
            }
            for (int j = end - 1; j >= 0; j--) {
               if (code.charAt(j) == ' ') {
                  start = j + 1;
                  break;
               }
            }
            break;
         }
      }
      if (start == -1 || end == -1)
         return code;
      String Doan1 = "";
      String Doan2 = "";
      String full = "";
      Doan1 = code.substring(0, start);
      Doan2 = code.substring(end + 1);
      full = Doan1 + " Main " + Doan2;
      namespace = code.substring(start, end + 1);
      System.out.println(full);
      return namespace;
   }
}