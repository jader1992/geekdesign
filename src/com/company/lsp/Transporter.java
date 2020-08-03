package com.company.lsp;

public class Transporter {
    private HttpClient httpClient;

    public Transporter(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Response SendRequest(Request request) {
        // ... use httpClient to send request;
    }
}
