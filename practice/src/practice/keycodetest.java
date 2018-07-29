package practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class keycodetest extends JFrame{
	JPanel contentpane=new JPanel();	 //make a panel named contentpane
	public keycodetest()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentpane);
		
		contentpane.addKeyListener(new MyKeylistener()); //if i pressed the key in the contentpane, the function named addkeylistener can listen the user's pressing
		//mykeylistener is function that i maked
		setSize(250,250); 
		setVisible(true); //panel's size is 250,250 and user can see the panel
		contentpane.requestFocus();
	}
	class MyKeylistener extends KeyAdapter
	{
		public void keyPressed (KeyEvent e) 
		{
			System.out.println((e.getKeyText(e.getKeyCode())));
			try {
				BufferedWriter output = new BufferedWriter(new FileWriter("outs.txt",true)); //make file
				output.write((e.getKeyText(e.getKeyCode())));      
			      output.write("\t\t\t");
			      long time=System.currentTimeMillis();   //get time
			      SimpleDateFormat daytime=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			      String str=daytime.format(new Date(time));
			      output.write(str);
			      output.newLine();
			      output.close();
		      	
		    } catch (IOException a) {
		        System.err.println(a); // 에러가 있다면 메시지 출력
		        System.exit(1);
		    }
		}
	}
	public static void main(String[] arr)
	{
		new keycodetest(); //In the main function, I call the function named keycodetest
	}
}
