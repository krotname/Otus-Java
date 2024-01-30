package ru.otus.hw36grpcclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduleFixedDelayTask {

    private final GrpcClient grpcClient;
    @Scheduled(fixedDelay = 2000)
    public void scheduleFixedDelayTask() {
        grpcClient.retrieve();
    }

}
