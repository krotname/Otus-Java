package ru.otus.hw36grpcserver;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;
import ru.otus.protobuf.generated.Empty;
import ru.otus.protobuf.generated.GenerateLongGrpc;
import ru.otus.protobuf.generated.Value;

@Component
public class GeneratorService extends GenerateLongGrpc.GenerateLongImplBase {
    @Override
    public void getValue(Empty request, StreamObserver<Value> responseObserver) {
        Value value = Value.newBuilder().setValue(1).build();
        responseObserver.onNext(value);
        responseObserver.onCompleted();


        super.getValue(request, responseObserver);
    }
}
