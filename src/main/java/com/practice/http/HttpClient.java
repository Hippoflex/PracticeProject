package com.practice.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {

    // one instance, reuse
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws Exception {

        HttpClient obj = new HttpClient();

        try {
            System.out.println("Testing 1 - Send Http GET request");
            CloseableHttpResponse response = obj.sendGet();
            obj.printResponse(response);

            //System.out.println("Testing 2 - Send Http POST request");
            //obj.sendPost();
        } finally {
            obj.close();
        }
    }

    private void close() throws IOException {
        httpClient.close();
    }
    // Метод для отправки Http GET запроса.
    private CloseableHttpResponse sendGet() throws Exception{
        // HttpGet запрос для получения HTML-кода страницы https://www.google.com/search?q=mkyong.
        HttpGet request = new HttpGet("http://www.cbr.ru/scripts/XML_daily.asp?date_req=22/06/2022");

        for (Header header : request.getAllHeaders()) {
            System.out.println(header.getName() + " : " + header.getValue());
        }

        return httpClient.execute(request);
    }
    // Метод для печати в консоль Http ответа.
    private void printResponse(CloseableHttpResponse response) {
        try {
            System.out.println("\n" + response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            for (Header header : response.getAllHeaders()) {
                System.out.println(header.getName() + " : " + header.getValue());
            }

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity, "cp1251");
                System.out.println("\n" + result);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
