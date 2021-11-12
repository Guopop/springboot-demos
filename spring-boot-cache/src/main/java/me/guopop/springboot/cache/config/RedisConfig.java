package me.guopop.springboot.cache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.Objects;

/**
 * @author guopop
 * @date 2021/9/13 17:12
 */
@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public CacheManager cacheManager(RedisTemplate<String, Object> template) {
        RedisCacheConfiguration defaultCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(template.getStringSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(template.getValueSerializer()))
                .disableCachingNullValues()
                .entryTtl(Duration.ofHours(1));

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(Objects.requireNonNull(template.getConnectionFactory()))
                .cacheDefaults(defaultCacheConfiguration)
                .transactionAware()
                .build();
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }
}
