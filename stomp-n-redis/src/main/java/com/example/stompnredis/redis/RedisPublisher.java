package com.example.stompnredis.redis;

import com.example.stompnredis.stomp.StompDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisPublisher {

    private final ChannelTopic channelTopic;

    private final RedisTemplate<String, Object> redisTemplate;

    public void publish(StompDTO stompDto) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), stompDto);
    }

}
