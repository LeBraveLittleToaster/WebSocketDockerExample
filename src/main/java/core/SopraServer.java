package core;

import java.net.InetSocketAddress;

public class SopraServer {

  public static final int WS_PORT = 54321;

  protected static WSSocketService service;

  public static void main(String[] args) {
    while(true) {
      if(service == null) {
        service = new WSSocketService(new InetSocketAddress(WS_PORT));
        System.out.println("Started core...");
        service.start();
      }
    }
  }
}
