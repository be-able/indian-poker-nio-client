package com.beable.indian.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

// 입력을 담당하는 클래스
class ClientWriter {

  private final SocketChannel socket;

  private final ByteBuffer buffer;

  // 연결된 소켓 채널과 모니터 출력용 채널을 생성자로 받음
  public ClientWriter(SocketChannel socket, int bufferSize) {

    this.socket = socket;
    this.buffer = ByteBuffer.allocate(bufferSize);
  }

  public void writeLine(String message) {

    this.buffer.put(message.getBytes(StandardCharsets.UTF_8));
    try {
      this.socket.write(this.buffer); // 입력한 내용을 서버로 출력
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
