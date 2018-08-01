import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
public class Server {
   private Socket socket = null;
   private ServerSocket server=null;
   private DataInputStream in=null;
   
   public Server(int port)
   {
      try 
      {
         server= new ServerSocket(port);      //make serversocket and it has port num
         System.out.println("Server started");
         
         System.out.println("Waiting for a client ...");
         
         socket = server.accept();   //accept method
         System.out.println("Client accepted");
         while(socket!=null)
         {
        	 in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));//takes input from the client socket
             String line="";
             
                try 
                {
                   line=in.readUTF();
                   try {
                      BufferedWriter output = new BufferedWriter(new FileWriter("outs.txt",true)); //make file. this class have to handle exception. so use try and catch.
                      output.write(line);
                         output.write("\t\t\t");
                         long time=System.currentTimeMillis();   //get time
                         SimpleDateFormat daytime=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                         String str=daytime.format(new Date(time)); //str can show what time the user pressed the key.
                         output.write(str);
                         output.newLine();
                         output.close();

                    } catch (IOException a) {
                        System.err.println(a); // if there are some errors,
                        System.exit(1);
                    }
                   System.out.println(line);
                }
                catch(IOException i)
                {
                   System.out.println(i);
                }
                          
             
         }
        
      }
      catch(IOException i)
      {
         System.out.println(i);
      }
   }
      public static void main(String args[])
      {
         Server server=new Server(5000);
      }
}