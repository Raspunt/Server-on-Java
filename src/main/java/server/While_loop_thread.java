package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class While_loop_thread extends  Thread {

    private int port ;
    private Socket socket ;
    private ServerSocket serverSocket;
    private final static Logger LOGGER = LoggerFactory.getLogger(While_loop_thread.class);





    public While_loop_thread(int port ) throws IOException {
        this.port = port ;
        this.serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {

        try {

        while (serverSocket.isBound() && !serverSocket.isClosed()) {

            socket = serverSocket.accept();

            LOGGER.info("connection accepted: " + socket.getInetAddress());

            HttpConnectionWorkerThread workerThread = new HttpConnectionWorkerThread(socket);
            workerThread.start();

        }



            } catch (IOException e) {
                e.printStackTrace();
            }finally {

                if (serverSocket!= null){
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }







