package server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread {


    public Socket socket ;
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);

    public HttpConnectionWorkerThread(Socket socket){
        this.socket = socket ;
    }

    @Override
    public void run() {
        InputStream inputStream  = null;
        OutputStream outputStream = null ;

        try {

        LOGGER.info("server " + socket.getInetAddress());

         inputStream = socket.getInputStream();
         outputStream = socket.getOutputStream();





         ReadTemplates tr = new ReadTemplates();
         String html = tr.ReadHtml("templates/index.html");


         PrintStream out = new PrintStream( socket.getOutputStream());



        final String CRLF = "\n\r";

        String response = "HTTP/1.1 200 OK" + CRLF +
                "Content-Length:" + html.getBytes().length + CRLF +
                "Content-Type: text/html; charset=utf-8" +
                CRLF +
                html +
                CRLF + CRLF;


        outputStream.write(response.getBytes());








        }catch (IOException e){
             e.printStackTrace();
        }finally {
            try {

                if(inputStream!= null ) {
                    inputStream.close();
                }
                if(outputStream != null) {
                    outputStream.close();
                }
                if(socket != null){
                    socket.close();
                }


            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
