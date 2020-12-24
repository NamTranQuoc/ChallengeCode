package com.Control;

import com.Model.RequestClass;
import com.jcraft.jsch.*;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class ConnectSSH {
   public static ConnectSSH instance = null;

   public static ConnectSSH getInstance() {
      if (instance == null)
         instance = new ConnectSSH();
      return instance;
   }

   private ConnectSSH () {}

   public String ExecuteCmd (RequestClass requestClass) {
      String result = "";

      String host="13.59.25.143";
      String user="ubuntu";
      String password="123456a@";
      String command1;
      String pathServer;


      if (requestClass.getLanguage().equals("Java")){
         command1="sudo rm data/Main.class\nsudo docker exec javacompile bash /data/compilejava.sh";
         pathServer = "data/Main.java";
      }
      else {
         command1 = "sudo rm data/Main.exe\nsudo docker exec c3compile bash /data/compilec3.sh";
         pathServer = "data/Main.cs";
      }

      try{

         AtomicReference<Properties> config = new AtomicReference<>(new Properties());
         config.get().put("StrictHostKeyChecking", "no");
         JSch jsch = new JSch();
         Session session=jsch.getSession(user, host, 22);
         session.setPassword(password);
         session.setConfig(config.get());
         session.connect();

         ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
         channelSftp.connect();
         channelSftp.put(new ByteArrayInputStream(requestClass.getContent().getBytes()), pathServer);
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
               String str = new String(tmp, 0, i);
               result += str;
            }
            if(channel.isClosed()){
               String str = "exit-status: " + channel.getExitStatus();
               result += str;
               break;
            }
            try{Thread.sleep(1000);}catch(Exception ee){}
         }
         channel.disconnect();
         session.disconnect();
      }catch(Exception e){
         e.printStackTrace();
      }

      return result;
   }
}
