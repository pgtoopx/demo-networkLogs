import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;


import java.io.IOException;


public class demo {
    public static void main(String[] args) throws IOException {
        pruebaApache();
        pruebaUniRest();
        pruebaOkHttp();
    }

    public static void pruebaApache() throws IOException {
        CloseableHttpClient client = HttpClients.custom().build();
        HttpUriRequest request = RequestBuilder.get()
                .setUri("https://api.browserstack.com/app-automate/builds/3c16fef99509abd31ab6fd4bc0f8e76557b6a417/sessions/a26a4c8ab7395ee54bfbdb551f991c58774f13ce/networklogs")
                .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .setHeader("Authorization", "Basic ZWR1YXJkb3NhbGlhbnMxOjJzeUFYc1Q2ZnFjcGphamlyWnhx")
                .build();
        CloseableHttpResponse response = client.execute(request);
        System.out.println(request.toString());
        String respuesta = EntityUtils.toString(response.getEntity());
        System.out.println("respuesta:"+respuesta);
    }

    public static void pruebaUniRest(){
        HttpResponse<String> response = Unirest.get("https://api.browserstack.com/app-automate/builds/3c16fef99509abd31ab6fd4bc0f8e76557b6a417/sessions/a26a4c8ab7395ee54bfbdb551f991c58774f13ce/networklogs")
                .header("Authorization", "Basic ZWR1YXJkb3NhbGlhbnMxOjJzeUFYc1Q2ZnFjcGphamlyWnhx")
                .asString();
        System.out.println(response.getBody());
    }

    public static void pruebaOkHttp() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.browserstack.com/app-automate/builds/3c16fef99509abd31ab6fd4bc0f8e76557b6a417/sessions/a26a4c8ab7395ee54bfbdb551f991c58774f13ce/networklogs")
                .method("GET", null)
                .addHeader("Authorization", "Basic ZWR1YXJkb3NhbGlhbnMxOjJzeUFYc1Q2ZnFjcGphamlyWnhx")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }


}
