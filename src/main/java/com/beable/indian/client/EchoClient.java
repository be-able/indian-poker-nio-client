package com.beable.indian.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class EchoClient {

  private final Selector selector;
  private final EchoClientRunning running;

  public EchoClient() throws IOException {

    this.selector = Selector.open();
    this.running = new EchoClientRunning(this.selector);

  }

  /**
   * 서버와 연결을 시도하고, 성공하면 서버와 통신을 시작한다
   *
   * @param hostname ip or hostname
   * @param port     port
   */
  public void connect(String hostname, int port) {

    try (SocketChannel socket = SocketChannel.open(new InetSocketAddress(hostname, port))) {

      int options = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
      SelectionKey register = socket.register(this.selector, options);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
