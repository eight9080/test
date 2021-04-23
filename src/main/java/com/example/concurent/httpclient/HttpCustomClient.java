package com.example.concurent.httpclient;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class HttpCustomClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        syncGet();
    }

    private static void syncGet() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://reqres.in/api/users/2"))
                .build();

        HttpResponse<String> response
                = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("\n Body: " + response.body());
    }

    private static final List<CompletableFuture<Void>>
            asyncPushRequests = new CopyOnWriteArrayList<>();

    private static HttpResponse.PushPromiseHandler<String> pushPromiseHandler() {

        return (HttpRequest initiatingRequest,
                HttpRequest pushPromiseRequest,
                Function<HttpResponse.BodyHandler<String>, CompletableFuture<HttpResponse<String>>> acceptor) -> {
            CompletableFuture<Void> pushcf =
                    acceptor.apply(HttpResponse.BodyHandlers.ofString())
                            .thenApply(HttpResponse::body)
                            .thenAccept((b) -> System.out.println(
                                    "\nPushed resource body:\n " + b));

            asyncPushRequests.add(pushcf);

            System.out.println("\nJust got promise push number: " +
                    asyncPushRequests.size());
            System.out.println("\nInitial push request: " +
                    initiatingRequest.uri());
            System.out.println("Initial push headers: " +
                    initiatingRequest.headers());
            System.out.println("Promise push request: " +
                    pushPromiseRequest.uri());
            System.out.println("Promise push headers: " +
                    pushPromiseRequest.headers());
        };
    }

}
