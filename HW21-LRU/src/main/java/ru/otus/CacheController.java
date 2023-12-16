package ru.otus;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Optional;

@RestController
@RequestMapping("/cache")
@Slf4j
public class CacheController {
    private final Cache<String, String> cache;

    public CacheController() {
        this.cache = new TimedWeakCache<>();
    }

    @PostMapping("/{key}")
    public ResponseEntity<Void> set(@PathVariable String key, @RequestBody String value) {
        log.info("POST key = {}, value = {}", key, value);
        boolean set = cache.set(key, value);
        if (set) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/{key}")
    public ResponseEntity<String> get(@PathVariable String key) {
        Optional<String> value = cache.get(key);
        if (value.isPresent()) {
            log.info("GET key = {}, value = {}", key, value.get());
            return ResponseEntity.ok(value.get());
        } else {
            log.warn("GET key = {}, value notFound", key);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/size")
    public ResponseEntity<Integer> size() {
        return ResponseEntity.ok(cache.size());
    }

    @GetMapping("/isEmpty")
    public ResponseEntity<Boolean> isEmpty() {
        return ResponseEntity.ok(cache.isEmpty());
    }

    @DeleteMapping
    public ResponseEntity<Void> clear() {
        log.warn("Сlear");
        cache.clear();
        return ResponseEntity.ok().build();
    }
}