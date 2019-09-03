package com.miromaric.dentalassistant.security;

import com.miromaric.dentalassistant.myresponse.MyResponse;
import com.miromaric.dentalassistant.myresponse.Status;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        List<String> auths = requestContext.getHeaders().get("Authorization");
        if (auths != null && auths.size() > 0) {
            String authToken = auths.get(0).split("\\s+")[1];
            String decodedString = new String(Base64.getDecoder().decode(authToken));
            StringTokenizer tokenizer = new StringTokenizer(decodedString,":");
            String username = tokenizer.nextToken();
            String password = tokenizer.nextToken();
            if (Security.getInstance().isWebServiceUser(username, password)) {
                System.out.println("Authentication is successful");
                return;
            }
        }
        Response unauthorizedStatus = Response.
                status(Response.Status.UNAUTHORIZED).
                entity(new MyResponse(Status.ERROR, null, "User cannot access the resource")).
                type(MediaType.APPLICATION_JSON).build();
        requestContext.abortWith(unauthorizedStatus);
    }

}
