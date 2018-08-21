import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import java.util.Date;
import java.io.*;

public class Server
{
   static Connection cons;
    public static void main(String[] args) throws IOException, SQLException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //loading driver class in jar file
            cons=DriverManager.getConnection("jdbc:mysql://localhost:3306/udp_typing_tracker?serverTimezone=UTC&useSSL=false", "root", "victoriawngml77");
            System.out.println("Connection Success!\n");
            Statement st=cons.createStatement();

         }
         catch(ClassNotFoundException|SQLException e)
         {
            System.out.println("Connection Failed.");
         }

        // Step 1 : Create a socket to listen at port 1234
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[10];
        byte[] time=new byte[30];

        DatagramPacket DpReceive = null;
        DatagramPacket DpTime = null;
       while(true)
       {
           // Step 2 : create a DatgramPacket to receive the data.
           DpReceive = new DatagramPacket(receive, receive.length);
           DpTime=new DatagramPacket(time,time.length);

           // Step 3 : revieve the data in byte buffer.
           ds.receive(DpReceive);
           ds.receive(DpTime);

           System.out.println("Client:-" + data(receive));
           System.out.println("Time:-" + data(time));
           String re=new String(receive);

           String ti=new String(time);

           String query=" insert into typing_list (Pressed_Key, Time)"+ " values (?,?)";
           PreparedStatement preparedstmt=cons.prepareStatement(query);

           preparedstmt.setString(1, re);
           preparedstmt.setString(2, ti);

           preparedstmt.execute();
           receive = new byte[10];
           time=new byte[30];
       }

    }

    // A utility method to convert the byte array
    // data into a string representation.
    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}
