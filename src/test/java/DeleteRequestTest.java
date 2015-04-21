import com.httpRequests.requests.DeleteRequest;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ragas
 * Date: 4/20/15
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteRequestTest {
    private String url = "http://httpbin.org/delete";
    private static HashMap<String,String> headers = new HashMap<String, String>();
    static {
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/json");
    }

    @Test
    public void deleteRequestTest1() throws Exception {

        JSONObject getJsonResponse = new DeleteRequest().withURL(url)
                .withHeaders(headers).sendReqAndGetResAsJSONObject();
        System.out.println(getJsonResponse);
    }
}
