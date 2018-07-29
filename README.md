# related-with-UClab
## 20180725_Streaming Service 
Streaming means flowing. Streaming Service is the method of sending and playing multimedia file such as a music or video.  Internet sends that data to system continuosly and playing in real time. Streaming just plays tha data without saving that file in hard disk, so the storage space of the hard disk is not affected. 

Streaming service can compare with Download method. Download method usually downloads file and open it. But that spends much time than Streaming Service. On the other hand, Streaming service playing the file while downloading file. So we can reduce spending time. And the speed of internet is important element in streaming service.

There are 3 types of streaming service. progressive download, rtsp/rtmp streaming, adaptive http streaming.

Progressive download is most popular video sending method. Youtube use this method. User just know some videos URL. That video is on Webserver. When User access the video using URL, System downloads the video and play. This type has fault. We can see the video as downloaded. So the video can stop if particular section has not been downloaded. This is Buffering. And if user wants to change the video’s quality, we should download video again that user’s wants quailty. 

Second one is rtsp/rtmp streaming. This type doesn’t download data already. Only the video frame currently being watched by the user is transmitted, and data already watched is discarded.

Lastly Adaptive http streaming is combination of progressive method and rtmp/rtsp method. The server streams with a few seconds of video, and the user connects these fragments into a continuous stream.

## 20180731_Key Tracking in Java 
This program shows the key what user pressed and time when the user pressed that key. In c++, there is getch() function. That is a function that moves the control forward as soon as a keyboard key is pressed, and also stores the character pressed.

However, There's no getch() function equivalent in java. We have to create GUI and attach the Event Listener to them.

I make a panel. When I execute the program, it shows a panel. Then i press the keyboard, console shows me what key i pressed. At the same time, it makes a file named 'outs'. There are keys and times that what kind of key user pressed and when is it in the file.

