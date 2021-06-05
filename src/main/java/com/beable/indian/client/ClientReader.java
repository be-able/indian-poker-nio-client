package com.beable.indian.client;

import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

// 입력을 담당하는 클래스
class ClientReader {

  private final SocketChannel socket;

  private final ByteBuffer buffer;

  // 연결된 소켓 채널과 모니터 출력용 채널을 생성자로 받음
  public ClientReader(SocketChannel socket, int bufferSize) {

    this.socket = socket;
    this.buffer = ByteBuffer.allocate(bufferSize);
  }

  public void readLine(String message) {

    WritableByteChannel out = Channels.newChannel(new ClientOutput());

    ByteBuffer buf = ByteBuffer.allocate(bufferSize);

    // 출력을 담당할 스레드 생성 및 실행
    ClientWriter writer = new ClientWriter(socket, 1024);

    while (true) {

      socket.read(buf); // 읽어서 버퍼에 넣고
      buf.flip();
      out.write(buf); // 모니터에 출력
      buf.clear();
    }
  }
}
