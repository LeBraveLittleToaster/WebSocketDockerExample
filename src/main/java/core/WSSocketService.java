package core;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class WSSocketService extends WebSocketServer {

  public WSSocketService(InetSocketAddress address) {
    super(address);
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {
    System.out.println("New Client connected...");
    conn.send("Hello from outer space!");
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    System.out.println("Client left...");
    SopraServer.service = null;
  }

  @Override
  public void onMessage(WebSocket conn, String message) {
    System.out.println("Received => [ " + message + " ]");
    conn.send("Sending your data back => [ " + message + " ]");
  }

  @Override
  public void onError(WebSocket conn, Exception ex) {

  }

  @Override
  public void onStart() {

  }
}
