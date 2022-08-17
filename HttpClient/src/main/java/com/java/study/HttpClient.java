package com.java.study;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class HttpClient {
  public static void main(String[] args) throws Exception{
    Socket socket = new Socket("www.etnews.co.kr", 80);

    // in, adapter, in2.close() 호출하는게 너무 많음! -> try( 알아서 close() 자동 실행해주는 블록 ) { }
    try(
        // 서버에 연결하여 페이지를 출력
        InputStream in = socket.getInputStream();
        InputStreamReader adapter = new InputStreamReader(in); 
        // BufferedReader(Char), InputStream(byte) 단위를 통일시켜주기위해 데코레이터 InputStream을 Reader로 바꿔줌
        BufferedReader in2 = new BufferedReader(adapter); 
        //줄 단위로 출력할 수 있지만 아쉽게도 Char단위로 데이터를 읽음(Char stream)

        OutputStream out = socket.getOutputStream();
        PrintStream out2 = new PrintStream(out); //PrintStream은 byte단위를 바로 연결 가능함! 데코레이터 필요없음.

        // 실무에선 이렇게 줄여서 쓸 수 있음!
        // InputStrem in = new BufferedReader(new InputStreamReader(socekt.getInputStream()));
        // OutputStream out = new new PrintStream(socket.getOutputStream());

        ){ //위에 생성된 in,in2,out,out2의 모든 close()가 자동으로 실행

      // HTTP 프로토콜에 따라서 메인 웹페이지를 요청한다.
      out2.println("GET /thisbike HTTP/1.1"); // 프로토콜 HTTP1.1버전에 따라 요청함.
      out2.println("HOST : stores.aution.co.kr"); // 내가 요청하는 호스트는
      out2.println(); // 요청에 대한 요청 정보 끝

      // 웹서버의 응답을 출력한다.
      String line; // 한줄 단위로 읽음
      while ((line = in2.readLine()) != null) { //읽을려는 하는데  null값이 아니면 출력
        System.out.println(line);
      }
    }





  }
}
