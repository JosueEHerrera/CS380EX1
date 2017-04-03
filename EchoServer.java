
import java.io.*;
import java.net.*;
public final class EchoServer {

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(22222)) {
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    String address = socket.getInetAddress().getHostAddress();
                    System.out.printf("Client connected: %s%n", address);
                    
                    // Get OutputStream (byte stream) through network to connected client
                    OutputStream os = socket.getOutputStream();

                    // Make PrintStream (character stream) on top of client-connected OutputStream
                    // This allows us to write text in the given character encoding through the
                    // Socket's OutputStream
                    PrintStream out = new PrintStream(os, true, "UTF-8");
                    InputStream is = socket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                    BufferedReader br = new BufferedReader(isr);

                    //Read statements being typed by client

                    String line;
                
                    while((line = br.readLine()) != null) {
                        out.println(line);
                    }


                    out.printf("Hi %s, thanks for connecting!%n", address);
                }
            }
        }
    }
}
