## 네트워크를 통한 데이터 전송하는 방법

### 1. ServerApp 생성
  - SeverSocket을 생성하여 네트워크 준비

### 2. 클라이언트의 연결을 기다림
  - Socket socket = serverSocket.accept(); 선언
  - accept();는 클라이언트가 연결될때까지 서버가 기다려줌.
  - 연결이 되면 socket 객체를 리턴!
  - 연결이 안되면 될때까지 기다림.

### 3. 연결을 끝는다. 
  - socket과 serverSocket 연결을 끝어줌.
  - socket.close(); 클라이언트와 연결을 끊어주고
  - serverSocket.close();는  서버 연결을 끊어줌.
  ** 나중에 close()가 많아질때는 try() {}구문을 이용해 자동으로 close()처리를 하게된다!

## 2. 준비된 클라이언트와 서버에 데이터 전송해보기(클라이언트와 데이터 주고 받기)
### 1. 클라이언트가 보낸 데이터를 읽을 때 필요한 도구를 준비한다.
  -InputStream in = socket.getInputStream(); 아쉽게도 InputStream은 byte단위로 실행함
  - Primitive type(int, float, char..), String type(String)을 출력하기 위해서는 보조도구(Decorator)가 필요함.
  -DataInputStream in2 = new DataInputStream(in);

### 2. 클라이언트로 데이터를 보낼 때 사용할 도구를 준비한다.
  - OutputStream out = socket.getOutputStream();
  - DataOutputStream out2 = new DataOutputStream(out);