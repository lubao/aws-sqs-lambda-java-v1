package example;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.lambda.runtime.Context;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

/*
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;

import java.util.Date;
import java.util.List;
*/

public class Hello implements RequestHandler<Request, Response> {


    final AmazonSQS sqs = AmazonSQSClientBuilder.standard()
        .withClientConfiguration(new ClientConfiguration().withMaxConnections(1000))
        .build();//;.defaultClient();
    private static final String QUEUE_NAME = "test";
    private String queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();

    // final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
    // private static final String QUEUE_NAME = "test";
    // Same region 
    // private String queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();
    
    public Response handleRequest(Request request, Context context) {
        System.out.println("Hello");
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody("hello world Java SDK")
                .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);

        String greetingString = String.format("Hello %s %s.", request.firstName, request.lastName);
        return new Response(greetingString);
    }
}
