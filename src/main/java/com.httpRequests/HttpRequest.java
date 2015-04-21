package com.httpRequests;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ragas
 * Date: 4/20/15
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
public interface HttpRequest {

    /**
     * <p><b>Return the headers of the request</b></p>
     * @return
     */
    HashMap<String, String> getHeaders();

    /**
     * <p><b>send the request</b></p>
     * @return
     */
    HttpResponse send() throws IOException, Exception;
}
