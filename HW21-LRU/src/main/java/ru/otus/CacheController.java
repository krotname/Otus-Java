package ru.otus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cache")
public class CacheController {
    private final Cache<String, String> cache;

    public CacheController() {
        this.cache = new TimedWeakCache<>(); // capacity 100, lifetime 60 seconds
    }

    @PostMapping("/{key}")
    public ResponseEntity<Void> set(@PathVariable String key, @RequestBody String value) {
        cache.set(key, value);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{key}")
    public ResponseEntity<String> get(@PathVariable String key) {
        Optional<String> value = cache.get(key);
        return value.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
        cache.clear();
        return ResponseEntity.ok().build();
    }
}