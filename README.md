# Related-with-UClab
## 20180725_Streaming Service 
Streaming means flowing. Streaming Service is the method of sending and playing multimedia file such as a music or video.  Internet sends that data to system continuosly and playing in real time. Streaming just plays tha data without saving that file in hard disk, so the storage space of the hard disk is not affected. 

Streaming service can compare with Download method. Download method usually downloads file and open it. But that spends much time than Streaming Service. On the other hand, Streaming service playing the file while downloading file. So we can reduce spending time. And the speed of internet is important element in streaming service.

There are 3 types of streaming service. progressive download, rtsp/rtmp streaming, adaptive http streaming.

Progressive download is most popular video sending method. Youtube use this method. User just know some videos URL. That video is on Webserver. When User access the video using URL, System downloads the video and play. This type has fault. We can see the video as downloaded. So the video can stop if particular section has not been downloaded. This is Buffering. And if user wants to change the video’s quality, we should download video again that user’s wants quailty. 

Second one is rtsp/rtmp streaming. This type doesn’t download data already. Only the video frame currently being watched by the user is transmitted, and data already watched is discarded.

Lastly Adaptive http streaming is combination of progressive method and rtmp/rtsp method. The server streams with a few seconds of video, and the user connects these fragments into a continuous stream.

## 20180731_Typing Tracker in Java 
This program shows the key what user pressed and time when the user pressed that key. In c++, there is getch() function. That is a function that moves the control forward as soon as a keyboard key is pressed, and also stores the character pressed.

However, There's no getch() function equivalent in java. We have to create GUI and attach the Event Listener to them.

I make a panel. When I execute the program, it shows a panel. Then i press the keyboard, console shows me what key i pressed. At the same time, it makes a file named 'outs'. There are keys and times that what kind of key user pressed and when is it in the file.

## 20180801_Socket Programming in Java
This program is Typing Tracker using client and Server. Client types the key and Server outputs the key and file.

### TCP
 TCP is one of the Socket programming, called Stream Communication Protocol. It is also known as a connection-oriented protocol because it can only be done when both sockets are connected.
 Since this TCP protocol is a reliable protocol, it means that the data of the sender arrives at the receiver side sequentially, without loss of the data. In order to do this, the receiving side and the sending side must establish a connection in advance and exchange data in the order in which they are connected.
 In connection-oriented mode, once connected, reliable data transmission is possible, in which the transmitted data is transmitted sequentially to the destination socket until the connection is disconnected.
 It must execute the server first and server should waiting client’s access.


### Establish a Socket Connection
To connect to other machine we need a socket connection. A socket connection means the two machines have information about each other’s network loaction(IP address) and TCP port.
Socket socket=new Socket(“127.0.0.1”,5000)
“127.0.0.1” is the  IP address of Server. And 5000 is TCP port. Just a number representing which application to run on a server. For example, HTTP runs on port 80. Port number can be from 0 to 65535.

### Server and Client
Server is a computer that offers some service to lots of users. And Clients it the computer that ask service to server. 

### Steps
1. Server makes a ServerSocket
2. ServerSocket’s accept function is waiting client.
3. Client makes a socket.
4. After client makes a socket, it access to server.
5. Server’s accept method returns client’s socket.
6. Obtain input,output stream  from a socket
7. Communication from Inputstream and outputstream
8. Call Socket’s close method.

## 20180809_DATABASE using MySQL
This program is Typing Tracker. In this program, Server get two data from client, when client pressed the key. One is key and Second is time. Server write that key and time to file. And It stored that data in database. I made database named "typing_tracker" and table named "typing_list" in it. We can know key, time and sequence.

### Database
Database is a gathering of oragnized data. It is a bundle of public data that can be stored and operated by integrated information of various application systems.

### SQL : Structured Query Language

A database query extracts data from a database and formats it in a readable form. A query must be written in the language the database requires—usually, that language is SQL.
For example, when you want data from a database, you use a query to request the specific information you want. Perhaps you have an Employee table, and you want to track sales performance numbers. You might query your database for the employee who recorded the highest sales in a given period.

A database has the potential to reveal complex trends and activities, but this power is only harnessed through the use of the query. A complex database consists of multiple tables storing a myriad of data. A query allows you to filter it into a single table so you can more easily analyze it. 
Queries also can perform calculations on your data or automate data management tasks. You can also review updates to your data before committing them to the database.

### Steps
1. Create a Java Connection to our example MySQL database.
2. Create a SQL INSERT statement, using the Java PreparedStatement syntax.
3. Set the fields on our Java PreparedStatement object.
4. Execute a Java PreparedStatement.
5. Close our Java MYSQL database connection.
6. Catch any SQL exceptions that may come up during the process.

### Capture the program

<div>
 <img src="https://user-images.githubusercontent.com/35221733/43883685-e602bbb4-9bee-11e8-8d09-cd43f45be5fc.PNG" width="90%"></img>
 This is the table information.
 <img src="https://user-images.githubusercontent.com/35221733/43883722-066d788a-9bef-11e8-9575-ff399af94075.PNG" width="90%"></img>
 This is typing list that user pressed.
 </div>
 
## 20180821_DATABASE using MySQL &  
### Socket
Network socket is the end point of interprocess communication via computer networks. 
Most of the computer-to-computer communication is based on Internet protocols, so most network sockets are Internet sockets. 

Socket is consisted by Internet protocol(TCP, UDP, raw IP), local IP address, local port, remote IP address and remote port.

### TCP V.S. UDP

In the TCP protocol, the client must request and accept a connection from the server. And to receive responses based on the results of every transmission of the data.

UDP is a non-connection-based service. Unlike TCP, there is no guarantee of data drift to the destination. Data may be lost, duplicated, or reversed in order. When you arrive at your destination, you are guaranteed only for the amount of data. If data is lost, the data is not automatically retransmitted. Anyone can send data knowing only the IP and port number of the destination.
Compared to TCP, it has a much simpler structure because it does not have to be in a connected state and does not need to receive a response depending on the transmission. So you can expect faster speeds even if you do not have stability.

<div>
 <img src="https://user-images.githubusercontent.com/35221733/44386413-67fd5f80-a55d-11e8-9551-a6b6723630f6.PNG" width="50%"></img>
 This is the table information.
 <img src="https://user-images.githubusercontent.com/35221733/44386456-86635b00-a55d-11e8-95fe-a3153993b096.PNG" width="50%"></img>
 This is typing list that user pressed.
 </div>
 
