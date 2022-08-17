package com.java.study;

import java.net.Socket;

public class ClientApp {
  public static void main(String[] args) {
    System.out.println("[ 관리 클라이언트 ] ");

    try {
      // 네트워크 준비
      // => 정상적으로 연결되어 있으면 socket 객체를 리턴한다.
      // [ new Socket("접속할 네트워크주소", 포트번호); ]
      // 127.0.0.1 -> 자기자신을 의미함.(localhost)
      // 포트번호 : 인식번호와 같음. 임의로 정해줌. 
      Socket socket = new Socket("127.0.0.1",8008);
      System.out.println("연결 되었음!");

      // 서버와 연결을 끊기 => 서버와 연결된 것을 끊는다.
      socket.close();
      System.out.println("연결을 끊었음.");

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("종료!");
  }
}
