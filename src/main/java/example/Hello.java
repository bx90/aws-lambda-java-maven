package example;

import bean.Request;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

public class Hello implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        Gson g = new Gson();
        Request r = g.fromJson(input.toString(), Request.class);

        context.getLogger().log("Input requestId: " + r.getRequestId());
        return "{\"RequestId\":\"" + r.getRequestId() +"\"}";
    }

}