package com.camwick.Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class InputUtil {
    private String baseURL = "https://adventofcode.com/";
    private String cookie = "53616c7465645f5f57566f1e545b1db73add00fb291bdd01f8ea473e4bbd41bcf14b527b08fc9aeb605a063981c2ad31f08ea8e42e6fcfd4d2cb13f89b144c29";

    public void sendGet(String year, String day) throws ClientProtocolException, IOException {
        String url = String.format("%s%s/day/%s/input", this.baseURL, year, day);
        String fileURL = String.format("./src/main/resources/input/y%s/day%s/input.txt", year, day);
        String headerValue = "https://github.com/camwick/AdventOfCode by cwickers@pnw.edu";

        // check if file exists
        File file = new File(fileURL);
        if (!file.exists()) {
            // create cookie
            BasicCookieStore cookieStore = new BasicCookieStore();
            BasicClientCookie cookie = new BasicClientCookie("session", this.cookie);
            cookie.setDomain(".adventofcode.com");
            cookie.setPath("/");
            cookieStore.addCookie(cookie);

            // create context that holds the cookie for the http client
            HttpContext localContext = new BasicHttpContext();
            localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);

            // create the http client with appropriate headers
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader(HttpHeaders.USER_AGENT, headerValue);

            HttpResponse response = client.execute(httpGet, localContext);

            // Create file from response
            Scanner sc = new Scanner(response.getEntity().getContent());

            if (file.getParentFile() != null)
                file.getParentFile().mkdirs();
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            while (sc.hasNextLine()) {
                writer.write(sc.nextLine() + "\n");
            }

            writer.close();
        }
    }
}