
import java.io.*;
import java.net.*;
import java.util.*;

public final class EchoClient {

    public static void main(String[] args) throws Exception {
        try (Socket socket = new Socket("localhost", 22222)) {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os,true,"UTF-8");
            Scanner kb = new Scanner(System.in);
    		String userinput = "";
	        while(!userinput.equals(" ")){
                System.out.print("Client> "); 
                userinput = kb.nextLine();
                out.printf(userinput + "%n");
                userinput = br.readLine();
                System.out.println("Server> " + userinput);
	        }
        } 
    }
}















