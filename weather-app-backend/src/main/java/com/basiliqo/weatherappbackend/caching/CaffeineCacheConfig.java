package com.basiliqo.weatherappbackend.caching;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
@Configuration
@EnableCaching
@ConfigurationProperties(prefix = "caffeine.caching")
public class CaffeineCacheConfig {

    private int duration;

    private TimeUnit timeUnit;

    private int maximumSize;

    @Bean
    public Caffeine caffeine() {
        return Caffeine.newBuilder()
                .expireAfterWrite(duration, timeUnit)
                .maximumSize(maximumSize);
    }

    @Bean
    public CacheManager cacheManager(Caffeine caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }
}
