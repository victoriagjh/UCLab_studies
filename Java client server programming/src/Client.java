import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class Client extends JFrame {
   private Socket socket =null;
   private DataOutputStream output=null;   //initialize socket, input output streams
   JPanel contentpane=new JPanel();
   KeyEvent e;
   String line ="";
   public Client(String address,int port)   // constructor to put ip address and port
   {
      try
      {
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setContentPane(contentpane);
         
         contentpane.addKeyListener(new MyKeylistener()); 
         
         setSize(250,250);
         setVisible(true); //panel's size is 250,250 and user can see the panel
         contentpane.requestFocus();
         
         
         socket=new Socket(address, port);
         System.out.println("Connected");
         
         output= new DataOutputStream(socket.getOutputStream());
         //sends output to the socket
      }
      catch(UnknownHostException u)
      {
         System.out.println(u);
      }
      catch(IOException i)
      {
         System.out.println(i);
      }
      
   }
   class MyKeylistener extends KeyAdapter
   {
      public void keyPressed (KeyEvent e)
      {
         line=(e.getKeyText(e.getKeyCode()));//when i press the key, console shows the key what user's pressed.
        
            try 
            {
               System.out.println(line);
               output.writeUTF(line);
            }
            catch(IOException i) 
            {
               System.out.println(i);
            }
      }
   }
   
   public static void main(String arg[])
   {
      Client client = new Client("127.0.0.1",5000);
   }
   
}
//In the program, Client keeps reading input from user and sends to the server until ¡°Over¡± is typed.