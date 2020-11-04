/*
 * This class has been copied from http://cs.lmu.edu/~ray/notes/javanetexamples/ 
 */
//package javasocketprogramming;


import java.io.IOException;
//import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.Date;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class ThreadedDateServer {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        int port = 9094;
        ServerSocket listener = new ServerSocket(port);
        System.out.println("Server started on " + port);
        try {
            while (true) {
                Socket socket = listener.accept();
                new ServerThread(socket).run();               
            }
        }
        finally {
            listener.close();
        }
    }
}