package server;

import server.While_loop_thread;

import java.io.IOException;

public class Main {

    public static int port = 4000 ;




    public static void main(String[] args) {





        try {
            While_loop_thread wlt = new While_loop_thread(port);
            wlt.start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
