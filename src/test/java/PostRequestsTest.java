import com.httpRequests.requests.PostRequest;
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
public class PostRequestsTest {
    private String url = "http://httpbin.org/post";
    private String url2 = "https://httpbin.org/get?show_env=1";
    private String requestBody = "custname=qwe&custtel=123&custemail=123%40qsd.com&size=small&topping=bacon&delivery=13%3A45&comments=asdasdasd";
    private static HashMap<String,String> headers = new HashMap<String, String>();
    static {
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");
    }

    @Test
    public void postRequestTest1() throws Exception {

        JSONObject getJsonResponse = new PostRequest().withBody(requestBody).withURL(url)
                .withHeaders(headers).sendReqAndGetResAsJSONObject();
        System.out.println(getJsonResponse);
    }
}
