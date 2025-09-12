package com.study.devstudy.spring.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@EnableCaching  // 캐시 기능 활성화
public class CacheConfiguration {

    // 단순 메모리 캐시
    @Bean
    public CacheManager simpleCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("users"),
                new ConcurrentMapCache("products"),
                new ConcurrentMapCache("external-users")
        ));
        return cacheManager;
    }

//    // Caffeine 캐시 (고성능 로컬 캐시)
//    @Bean
//    public CacheManager caffeineCacheManager() {
//        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
//        cacheManager.setCaffeine(Caffeine.newBuilder()
//                .maximumSize(1000)                    // 최대 1000개 엔트리
//                .expireAfterWrite(10, TimeUnit.MINUTES)  // 10분 후 만료
//                .recordStats());                      // 통계 수집
//        return cacheManager;
//    }

//    // Redis 캐시 (분산 캐시)
//    @Bean
//    public CacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofMinutes(30))     // 30분 TTL
//                .serializeKeysWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(new StringRedisSerializer()))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));
//
//        return RedisCacheManager.builder(connectionFactory)
//                .cacheDefaults(config)
//                .transactionAware()
//                .build();
//    }
}
