import java.util.Scanner;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
public class Client extends JFrame {
   KeyEvent e;
   String line = "";
   byte buf[] = null;
   JPanel contentpane=new JPanel();

   public Client()   // constructor to put ip address and port
      {

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setContentPane(contentpane);

            contentpane.addKeyListener(new MyKeylistener());

            setSize(250,250);
            setVisible(true); //panel's size is 250,250 and user can see the panel
            contentpane.requestFocus();


            System.out.println("Connected");

      }
   class MyKeylistener extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
         byte buf[] = null;
         byte ti[] = null;
         line = (e.getKeyText(e.getKeyCode()));// when i press the key, console shows the key what user's pressed.
         try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = InetAddress.getLocalHost();
            buf = line.getBytes();
            long time = System.currentTimeMillis(); // get time
            SimpleDateFormat daytime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String str = daytime.format(new Date(time));
            ti = str.getBytes();
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
            DatagramPacket DpTime = new DatagramPacket(ti, ti.length, ip, 1234);
            ds.send(DpSend);
            ds.send(DpTime);

            System.out.println(line);
            System.out.println(str);

         } catch (IOException i) {
            System.out.println(i);
         }
      }
   }
   public static void main(String args[]) {
         Client client = new Client();
   }
}
