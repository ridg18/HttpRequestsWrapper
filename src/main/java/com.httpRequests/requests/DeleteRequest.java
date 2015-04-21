package com.httpRequests.requests;

import com.httpRequests.RequestBase;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ragas
 * Date: 4/20/15
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class DeleteRequest extends RequestBase {

    @Override
    public HttpResponse send() throws Exception {
        client = new DefaultHttpClient();
        HttpDelete request = new HttpDelete(url);
        // add request headers
        for (Map.Entry<String, String> entry : RequestHeader.entrySet()) {
            request.setHeader(entry.getKey(), entry.getValue());
        }
        HttpResponse response = client.execute(request);
        responseStatus = response.getStatusLine().getStatusCode();
        System.out.println("\nSending 'GET' request to URL : " + url
                + "\nResponse Code : " + responseStatus);
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return response;
    }
}
