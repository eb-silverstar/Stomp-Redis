package com.example.stompnredis.stomp;

import com.example.stompnredis.redis.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StompController {

    private final RedisPublisher redisPublisher;

    /**
     * 공간 좌표 송신
     *
     * @param id
     * @param stompDto
     */
    @MessageMapping("/{id}")
    public void sendGrid(@DestinationVariable("id") String id, StompDTO stompDto) {
        stompDto.setDestination("/space/" + id);
        redisPublisher.publish(stompDto);
    }

}
