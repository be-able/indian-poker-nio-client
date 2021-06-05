package com.beable.indian.client;

import java.io.IOException;
import java.io.OutputStream;

// 입력을 담당하는 클래스
class ClientOutput extends OutputStream {

  @Override
  public void write(int b) throws IOException {
    System.out.print(b);
  }
}
