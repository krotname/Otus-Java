package ru.otus.hw36grpcserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GRPCServer {
    private static final int SERVER_PORT = 8190;
    private final Server server;

    @SneakyThrows
    public GRPCServer(GeneratorService generatorService) {

        server = ServerBuilder
                .forPort(SERVER_PORT)
                .addService(generatorService)
                .build();

        server.start();
        log.info("GRPCServer waiting for client connections");
        server.awaitTermination();
    }
}
