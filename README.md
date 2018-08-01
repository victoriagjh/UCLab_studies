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


