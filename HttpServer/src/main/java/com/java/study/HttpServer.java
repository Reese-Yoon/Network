package com.java.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
  public static void main(String[] args) throws Exception {
    try(ServerSocket ss = new ServerSocket(80);){
      System.out.println("서버 시작!");
      // 왜 중첩try 구문?

      while(true) { //무한 반복
        try(
            // 서버 준비 완료
            Socket socket = ss.accept(); // 클라이언트가 올 때까지 대기

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 한 줄씩 읽어줌. 
            PrintStream out = new PrintStream(socket.getOutputStream()); // 한 줄씩 출력함.

            ){
        System.out.println("클라이언트의 요청이 들오옴.");
          System.out.println("------------------------------------------");

          String line; // 줄 단위로 읽고, 출력
          while((line = in.readLine()) != null) { // 클라이언트가 빈 줄을 보내면 읽기를 끝낸다.
            if(line.length() == 0) { //만약 출력할 길이가 0이면 나간ㄷ.
              break;
            }
            System.out.println(line);
          }
          // 클라이언트에게 응답한다.
          out.println("HTTP/1.1 200 OK");
          out.println("Content-Type : text/html; charset = UTF-8");
          out.println(); //이제부터 본격적으로  콘텐츠를 보내겠다고 알린다.
          out.println("<html>");
          out.println("<head>");
          out.println("<title> Hello </title>");
          out.println("</head>");
          out.println("<body>");
          out.println("<h1> 안녕하세요. </h1>");
          out.println("</body>");
          out.println("</html>");
        } //try
      } //while
    } //try

  } // main()
}



