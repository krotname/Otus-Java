package ru.otus.hw36grpcserver;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleFixedDelayTask {
    private final Generator generator;
    @Scheduled(fixedDelay = 2000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        System.out.println(generator.generate());
    }

}
