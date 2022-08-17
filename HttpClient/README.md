## 1. httpClient 네트워크 프로그래밍

### 1.Socket으로 클라이언트를 준비

### 2. 서버에 연결하여 페이지를 읽을 준비(InputStream)
  - InputStream으로 byte단위로 페이지를 읽음.
  - 줄 단위로 읽고 싶어서  BufferedReader을 사용함. 하지만 아쉽게 char단위로 읽어서 중간에 어뎁터(Decorator) 가 필요함.
  - InputStreamReader -> byte단위를 char로 바꿔줌.

### 3. 서버에 연결하여 페이지를 출력할 준비(OutputSream)
  - OutputStream은 byte단위로 출력함.
  - PrintStream은 byte단위,  Char단위 모두 출력할 수 있어서 어뎁터(Decorater)가 필요 없음.

### 4. InputStream과 OutputSream을 현업에서는 짧게 두줄로 나타낼 수 있음.
  InputStream in = socket.getInputStream();
  InputStreamReader adapter = new InputStreamReader(in); 
  BufferedReader in2 = new BufferedReader(adapter); 
        
  OutputStream out = socket.getOutputStream();
  PrintStream out2 = new PrintStream(out);

  // 실무에선 이렇게 줄여서 쓸 수 있음!
  InputStrem in = new BufferedReader(new InputStreamReader(socekt.getInputStream()));
  OutputStream out = new new PrintStream(socket.getOutputStream());

### 5. try() {}을 이용해서 auto-close()를 사용함.
    - in,out,socket,severSocket등등 모두 close()를 닫기 귀찮음.
    - try(){}으로 묶으면 ()안에는 자동으로 close()시켜줌.

### 6. HTTP 프로토콜에 맞춰 페이지 출력 요청
    - out.println("GET /this.bike HTTP/1.1"); -> this.bike페이지를 HTTP/1.1버전에 따라 요청함.
    - out.println(HOST : stores.aution.co.kr) ->   내가 위에 주소를 요청한다.
    - out.println() -> 요청에 대한 요청 정보 끝

### 7. HTTP 프로토콜에 맞춰 웹서버의 응답을 읽어줌.
  - String line; -> 한 줄씩 읽어줄 수 있음.
  - While((line = in.readLine()) != null){
      System.out.println(line);
  } -> 읽은 줄이 null값이 아니면 출력한다.