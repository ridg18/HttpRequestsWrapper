import com.httpRequests.requests.GetRequest;
import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ragas
 * Date: 4/20/15
 * Time: 2:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetRequestTest {

    private String url = "http://httpbin.org/get";
    private String url2 = "https://httpbin.org/get?show_env=1";
    private static HashMap<String,String> headers = new HashMap<String, String>();
    static {
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");
    }

    @Test
    public void getRequestTest1() throws Exception {

        JSONObject getJsonResponse = new GetRequest().withURL(url)
                .withHeaders(headers).sendReqAndGetResAsJSONObject();
        System.out.println(getJsonResponse);
    }

    @Test
    public void getRequestTest2() throws Exception {
        GetRequest getRequest =(GetRequest) new GetRequest().withURL(url2)
                .withHeaders(headers);
        HttpResponse getRequestResponse = getRequest.send();
        JSONObject getJsonResponse2 = getRequest.sendReqAndGetResAsJSONObject();
        System.out.println(getJsonResponse2);
        System.out.println(getRequestResponse);
    }
}
