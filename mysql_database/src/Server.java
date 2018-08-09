import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import java.util.Date;
import java.io.*;
public class Server {
   private Socket socket = null;
   private ServerSocket server=null;
   private DataInputStream in=null;
   private DataInputStream intime=null;
   Connection conn;
   public Server(int port) throws SQLException
   {
      try 
      {
    	  try {
  			Class.forName("com.mysql.cj.jdbc.Driver");
  			//loading driver class in jar file
  			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/typing_tracker?serverTimezone=UTC&useSSL=false", "root", "victoriawngml77");
  			System.out.println("Connection Success!\n");
  			Statement st=conn.createStatement();
  			
  		}
  		catch(ClassNotFoundException|SQLException e)
  		{
  			System.out.println("Connection Failed.");
  		}
         server= new ServerSocket(port);      //make serversocket and it has port num
         System.out.println("Server started");
         
         System.out.println("Waiting for a client ...");
         
         socket = server.accept();   //accept method
         System.out.println("Client accepted");
         while(socket!=null)
         {
        	 in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));//takes input from the client socket
        	 intime =new DataInputStream(new BufferedInputStream(socket.getInputStream()));
             String line="";
             String times="";
             
                try 
                {
                   line=in.readUTF();
                   times=intime.readUTF();
                   try {
                      BufferedWriter output = new BufferedWriter(new FileWriter("outs.txt",true)); //make file. this class have to handle exception. so use try and catch.
                      output.write(line);
                      System.out.println(line);
                      System.out.println(times);
                      
                         output.write("\t\t\t");                                         
                         String query=" insert into typing_list (Pressed_Key, Time)"+ " values (?,?)";
                         PreparedStatement preparedstmt=conn.prepareStatement(query);
                         
                         preparedstmt.setString(1, line);
                         preparedstmt.setString(2, times);
                         
                         preparedstmt.execute();
                         
                         output.write(times);
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
      public static void main(String args[]) throws SQLException
      {
         Server server=new Server(5000);
      }
}