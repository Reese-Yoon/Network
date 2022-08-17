package com.java.study;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
  public static void main(String[] args) {
    System.out.println("[ 데이터 관리 서버 ]");

    try {
      // 네트워크 준비
      // => 클라이언트와 연결할 준비를 한다.
      ServerSocket serverSocket = new ServerSocket(8008);
      System.out.println("서버 소켓 준비 완료");

      // 클라이언트의 연결을 기다림
      // => 클라이언트와 연결되면 그 클라이언트와 통신할 준비를 한다.
      // => 연결되면 socket객체 리턴 / 연결 안되면 연결될때까지 기다림.
      Socket socket = serverSocket.accept();
      System.out.println("클라이언트와 연결 되었음!");

      // 연결된 클라이언트와 연결을 끊는다.
      socket.close();
      System.out.println("클라이언트와 연겯을 끊읐음");


      // 클라이언트와 데이터를 주고 받는다.
      // => 클라이언트가 보낸 데이터를 읽을 때 필요한 도구를 준비한다.
      InputStream in = socket.getInputStream();
      
      // 그냥 InputStream은 byte씩 출력함.
      // => 데이터를 읽을 때 primitive type, String type 값을 보다 손 쉽게 읽을 수 있도록
      //    기존의 출력 도구에 보조 도구(Decorator)를 붙여 사용함.
      DataInputStream in2 = new DataInputStream(in);

      // => 클라이언트로 데이터를 보낼 때 사용할 도구를 준비한다.
      OutputStream out = socket.getOutputStream();
      DataOutputStream out2 = new DataOutputStream(out);

      // 클라이언트와 서버 사이에 정해진 규칙(프로토콜)에 따라 데이터를 주고 받는다.

      // 네트워크 종료
      serverSocket.close();

    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");

  }
}
