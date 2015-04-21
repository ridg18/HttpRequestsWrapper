package com.httpRequests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ragas
 * Date: 4/20/15
 * Time: 9:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class RequestBase implements HttpRequest {

    protected HttpClient client;
    public HashMap<String, String> RequestHeader = new HashMap<String, String>();
    protected int responseStatus;
    protected String url;
    protected StringBuffer result = new StringBuffer();

    /**
     * <p><b>Add headers to the request as a Hashmap</b><br/>
     * the method get a parameter as a Hashmap and add it to the Http request<br/>
     * the Hashmap should look like:<br/>
     * <pre>
     * <code>
     *  Accept,application/json
     *  Content-Type,application/json
     * </code></pre></p>
     *
     * @param RequestHeader
     * @return
     */
    public RequestBase withHeaders(HashMap<String, String> RequestHeader) {
        this.RequestHeader = RequestHeader;
        return this;
    }

    /**
     * <p><b>add the destination URL to the request</b><br/>
     * the method add the url as String to the request</p>
     *
     * @param url
     * @return
     */
    public RequestBase withURL(String url) {
        this.url = url;
        return this;
    }

    /**
     * <p><b>return the response status</b></p>
     *
     * @return
     */
    public int getResponseStatus() {
        return responseStatus;
    }

    /**
     * <p><b>return the headers</b></p>
     *
     * @return
     */
    @Override
    public HashMap<String, String> getHeaders() {
        return RequestHeader;
    }

    @Override
    public HttpResponse send() throws Exception {
        return null;
    }

    /**
     * <p><b>the method execute the request and return the response body as json</b><br/>
     * </p>
     *
     * @return
     * @throws Exception
     */
    public JSONObject sendReqAndGetResAsJSONObject() throws Exception {
        send();
        String json_string = result.toString();
        JSONObject jsonObject = new JSONObject(json_string);
        return jsonObject;
    }
}
