package helloworld;

import com.amazon.dax.client.dynamodbv2.AmazonDaxClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomebowdataHandler {

    private DynamoDBMapper initDynamoDBClient() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        return new DynamoDBMapper(client);
    }

    private DynamoDBMapper initDax() {//?
        AmazonDaxClientBuilder daxClientBuilder = AmazonDaxClientBuilder.standard();
        daxClientBuilder.withRegion("us-west-1").withEndpointConfiguration("");
        AmazonDynamoDB client = daxClientBuilder.build();
        return new DynamoDBMapper(client);
    }

    public APIGatewayProxyResponseEvent create(APIGatewayProxyRequestEvent request, Context context){
        DynamoDBMapper mapper = this.initDynamoDBClient();

        String body = request.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Homebowdata homebowdata = objectMapper.readValue(body, Homebowdata.class);
            mapper.save(homebowdata);
            String jsonString = objectMapper.writeValueAsString(homebowdata);
            return new APIGatewayProxyResponseEvent().withStatusCode(201).withBody(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            return new APIGatewayProxyResponseEvent().withStatusCode(500);
        }
    }

    public APIGatewayProxyResponseEvent read(APIGatewayProxyRequestEvent request, Context context) {
        DynamoDBMapper mapper = this.initDynamoDBClient();

        String[] array = request.getPath().split("/");
//        String mlsId = array[array.length - 1];
        String mlsId = array[2];
        Homebowdata homebowdata = mapper.load(Homebowdata.class, mlsId);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonInString = objectMapper.writeValueAsString(homebowdata);

            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json");
            return new APIGatewayProxyResponseEvent().withStatusCode(200).withHeaders(headers).withBody(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new APIGatewayProxyResponseEvent().withStatusCode(500);
        }
    }

    public APIGatewayProxyResponseEvent update(APIGatewayProxyRequestEvent request, Context context) {
        DynamoDBMapper mapper = this.initDynamoDBClient();
        String body = request.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        Homebowdata homebowdata;

        try {
            homebowdata = objectMapper.readValue(body, Homebowdata.class);
            mapper.save(homebowdata);
            String jsonString = objectMapper.writeValueAsString(homebowdata);
            return new APIGatewayProxyResponseEvent().withStatusCode(200).withBody(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            return new APIGatewayProxyResponseEvent().withStatusCode(500);
        }
    }

    public APIGatewayProxyResponseEvent delete(APIGatewayProxyRequestEvent request, Context context) {
        DynamoDBMapper mapper = this.initDynamoDBClient();
        String[] array = request.getPath().split("/");
        String mlsId = array[2];
        Homebowdata homebowdata = mapper.load(Homebowdata.class, mlsId);
        if (homebowdata != null) {
            mapper.delete(homebowdata);
        }
        return new APIGatewayProxyResponseEvent().withStatusCode(200);
    }

    public APIGatewayProxyResponseEvent getAll(APIGatewayProxyRequestEvent request, Context context) {
        DynamoDBMapper mapper = this.initDynamoDBClient();
        List<Homebowdata> homebowdataList = mapper.scan(Homebowdata.class, new DynamoDBScanExpression());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonInString = objectMapper.writeValueAsString(homebowdataList);

            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json");
            return new APIGatewayProxyResponseEvent().withStatusCode(200).withHeaders(headers).withBody(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new APIGatewayProxyResponseEvent().withStatusCode(500);
        }
    }
}
