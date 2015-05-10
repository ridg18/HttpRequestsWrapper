package com.httpRequests.requests;

import com.httpRequests.RequestBase;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
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
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class PutRequest extends RequestBase {
    private String body;

    /**
     * <p><b>Constructor</b></p>
     */
    public PutRequest() {
    }

    /**
     * <p><b>Add a String body to the Put request</b>
     * the method get a String and convert it to JSON form </p>
     *
     * @param body
     * @return
     */
    public PutRequest withBody(String body) {
        this.body = body;
        return this;
    }

    /**
     * <p><b>Add the necessary parameters and execute the request</b><br/>
     * the method build the request (add the headers and the body)<br/>
     * and execute the request</p>
     *
     * @return
     * @throws Exception
     */
    @Override
    public HttpResponse send() throws Exception {
        client = new DefaultHttpClient();
        HttpPut post = new HttpPut(url);
        // add header
        for (Map.Entry<String, String> entry : RequestHeader.entrySet()) {
            post.setHeader(entry.getKey(), entry.getValue());
        }
        //add body
        post.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));
        //execute request
        HttpResponse response = client.execute(post);
        responseStatus = response.getStatusLine().getStatusCode();

        logger.info("\nSending 'POST' request to URL : " + url
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
