package ru.otus.hw36grpcserver;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.otus.protobuf.generated.Empty;
import ru.otus.protobuf.generated.GenerateLongGrpc;
import ru.otus.protobuf.generated.Value;

@Component
@Slf4j
@RequiredArgsConstructor
public class GeneratorService extends GenerateLongGrpc.GenerateLongImplBase {
    private final Generator generator;
    @Override
    public void getValue(Empty request, StreamObserver<Value> responseObserver) {
        long generate = generator.generate();
        Value value = Value.newBuilder().setValue(generate).build();
        responseObserver.onNext(value);
        responseObserver.onCompleted();
        super.getValue(request, responseObserver);
        log.info("sent... {}", generate);
    }
}
