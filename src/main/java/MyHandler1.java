import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHandler1 implements HttpHandler{

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = """
                {
                    "message": "server check"
                }
                """;
        exchange.getResponseHeaders().add("Content-Type", "application/json"); //응답 헤더 설정
        exchange.sendResponseHeaders(200, response.getBytes().length); //응답 코드와 길이 설정
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
