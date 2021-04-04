package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpParser {

    private final static Logger LOADER = LoggerFactory.getLogger(HttpParser.class);

    private static final int SP = 0x20; // 32
    private static final int CR = 0x80; // 13
    private static final int LF = 0x0A; // 18



    public  HttpParser parseHttpRequest(InputStream inputStream){

        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);



        HttpParser request = new HttpRequest();
        parseRequestLine(reader,request);
        parseHeaders(reader,request);
        parseBody(reader,request);

        return  request ;
    }

    private void parseBody(InputStreamReader reader, HttpParser request) {

        try {

            int _byte;
            while ((_byte = reader.read()) >= 0) {
                if (_byte == CR) {
                    _byte = reader.read();
                    if (_byte == LF) {
                        return;
                    }
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void parseHeaders(InputStreamReader reader, HttpParser request) {

    }

    private void parseRequestLine(InputStreamReader reader, HttpParser request) {

    }

}
