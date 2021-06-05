package com.beable.indian.client;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class EchoClientRunning implements Runnable {

  private final Selector selector;

  public EchoClientRunning(Selector selector) {
    this.selector = selector;
  }

  public void run() {

    Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
    Iterator<SelectionKey> iterator = selectionKeys.iterator();
    while (iterator.hasNext()) {

      SelectionKey key = iterator.next();

      if (key.isAcceptable()) {
        // a connection was accepted by a ServerSocketChannel.

      } else if (key.isConnectable()) {
        // a connection was established with a remote server.

      } else if (key.isReadable()) {
        // a channel is ready for reading

      } else if (key.isWritable()) {
        // a channel is ready for writing
      }

      iterator.remove();
    }
  }
}
