package com.httpRequests.requests;

import com.httpRequests.RequestBase;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ragas
 * Date: 4/20/15
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetRequest extends RequestBase {


    public GetRequest() {
    }

    /**
     * <p><b>Add the necessary parameters and execute the request</b><br/>
     * the method build the request (add the headers)<br/>
     * and execute the request</p>
     *
     * @return
     * @throws Exception
     */
    @Override
    public HttpResponse send() throws Exception {
        client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        // add request headers
        for (Map.Entry<String, String> entry : RequestHeader.entrySet()) {
            request.setHeader(entry.getKey(), entry.getValue());
        }
        HttpResponse response = client.execute(request);
        responseStatus = response.getStatusLine().getStatusCode();
        logger.info("\nSending 'GET' request to URL : " + url
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
