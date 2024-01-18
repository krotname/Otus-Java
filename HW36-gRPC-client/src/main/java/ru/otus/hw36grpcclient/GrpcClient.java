package ru.otus.hw36grpcclient;

import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.otus.protobuf.generated.Empty;
import ru.otus.protobuf.generated.GenerateLongGrpc;
import ru.otus.protobuf.generated.Value;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
public class GrpcClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8190;
    private long count = 0;

    public void retrieve(){
        var channel = ManagedChannelBuilder.forAddress(SERVER_HOST, SERVER_PORT)
                .usePlaintext()
                .build();

        var stub = GenerateLongGrpc.newBlockingStub(channel);
        var value = stub.getValue(Empty.newBuilder().build());

        log.info("Received {}", value);

        count = count + value.getValue();
        log.info("new count {}", count);

        channel.shutdown();
    }
}
