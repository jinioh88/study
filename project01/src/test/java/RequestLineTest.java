import http.HttpMethod;
import http.RequestLine;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RequestLineTest {
    @Test
    public void create_method() {
        RequestLine line = new RequestLine("GET /home.html HTTP/1.1");
        assertEquals(HttpMethod.GET,line.getMethod());
        assertEquals("/home.html",line.getPath());
        line = new RequestLine("POST /home.html HTTP/1.1");
        assertEquals("/home.html", line.getPath());
    }

    @Test
    public void create_path_and_parmas() {
        RequestLine line = new RequestLine("GET /user/create?userId=sana&passwrod=pass HTTP/1.1");
        assertEquals(HttpMethod.GET, line.getMethod());
        assertEquals("/user/create",line.getPath());
        Map<String, String> params = line.getParams();
        assertEquals(2,params.size());
    }
}
