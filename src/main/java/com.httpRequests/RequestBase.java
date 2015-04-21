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


    public RequestBase withHeaders(HashMap<String, String> RequestHeader) {
        this.RequestHeader = RequestHeader;
        return this;
    }

    public RequestBase withURL(String url) {
        this.url = url;
        return this;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return RequestHeader;
    }

    @Override
    public HttpResponse send() throws Exception {
        return null;
    }

    public JSONObject sendReqAndGetResAsJSONObject() throws Exception {
        send();
        String json_string = result.toString();
        JSONObject jsonObject = new JSONObject(json_string);
        return jsonObject;
    }
}
