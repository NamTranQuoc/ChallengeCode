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
   }
}