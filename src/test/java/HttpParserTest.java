import http.HttpParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HttpParserTest {

    private HttpParser httpParser ;


    @BeforeAll
    private void  beforeClass(){
        httpParser = new HttpParser();
    }




    @Test
    void parseHttpRequest() {
    }
}