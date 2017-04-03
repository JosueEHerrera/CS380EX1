
import java.io.*;
import java.net.*;
// import java.io.InputStream;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.net.Socket;

public final class EchoClient {

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 22222)) {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
           	System.out.println(br.readLine());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("here1");
           
    		String userinput;
	        while((userinput = br.readLine()) != null){
	        	
	        	System.out.println("here2");
	        	out.println(userinput);
	        	System.out.println("Client> "+ userinput);
	        }
        }

        
    }
}















