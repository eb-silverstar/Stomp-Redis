package com.example.stompnredis.redis;

import com.example.stompnredis.stomp.StompDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisSubscriber implements MessageListener {

    private final ObjectMapper objectMapper;

    private final RedisTemplate<String, Object> redisTemplate;

    private final SimpMessageSendingOperations sendingOperations;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            String publishMessage = redisTemplate.getStringSerializer().deserialize(message.getBody());
            StompDTO stompDto = objectMapper.readValue(publishMessage, StompDTO.class);

            sendingOperations.convertAndSend(stompDto.getDestination(), stompDto);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}