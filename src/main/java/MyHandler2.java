import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class MyHandler2 implements HttpHandler{

    @Override
    public void handle(HttpExchange exchange) throws IOException {
      String filePath = "./user.json";
        File file = new File("./user.json");
        ObjectMapper objectMapper = new ObjectMapper();
        User[] users = objectMapper.readValue(file, User[].class);

        String response = """
                {
                    "sum": 
                """;
        int result = 0;


        exchange.getResponseHeaders().add("Content-Type", "application/json"); //응답 헤더 설정
        exchange.sendResponseHeaders(200, response.getBytes().length); //응답 코드와 길이 설정
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }

}
