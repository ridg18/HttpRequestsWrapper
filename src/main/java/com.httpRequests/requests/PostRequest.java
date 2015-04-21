package com.httpRequests.requests;

import com.google.gson.Gson;
import com.httpRequests.RequestBase;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ragas
 * Date: 4/20/15
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostRequest extends RequestBase {



    private String body;
    private Gson gson = new Gson();

    public PostRequest() {
    }

    public RequestBase withBody(String body) {
        this.body =gson.toJson(body);
        return this;
    }

    @Override
    public HttpResponse send() throws Exception {
        client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        // add header
        for (Map.Entry<String, String> entry : RequestHeader.entrySet()) {
            post.setHeader(entry.getKey(), entry.getValue());
        }
        //add body
        post.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));
        //execute request
        HttpResponse response = client.execute(post);
        responseStatus = response.getStatusLine().getStatusCode();

        System.out.println("\nSending 'POST' request to URL : " + url
                + "\nPost parameters : " + post.getEntity()
                + "\nResponse Code : " + responseStatus);
        try {
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
                result.append("\n");
            }
            return response;
        } catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");
        }
        return null;
    }
}