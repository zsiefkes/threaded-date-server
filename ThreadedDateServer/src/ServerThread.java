import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket socket;
	
	public ServerThread(Socket s) {
		this.socket = s;
	}
	
	@Override
	public void run() {
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			System.out.println("A client request received at " + socket);
			out.println(new java.util.Date().toString());
			socket.close();
		} catch(IOException e) {
			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}
}
