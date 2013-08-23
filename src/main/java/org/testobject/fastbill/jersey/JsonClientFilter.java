package org.testobject.fastbill.jersey;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

public class JsonClientFilter extends ClientFilter {
 
    public ClientResponse handle(ClientRequest cr) {
        // Call the next filter
        ClientResponse resp = getNext().handle(cr);
        String contentType = resp.getHeaders().getFirst("Content-Type");
        if (contentType.startsWith("text/plain")) {
             String newContentType = "application/json" + contentType.substring(10);
             resp.getHeaders().putSingle("Content-Type", newContentType);
        }
        return resp;
    }
 
}