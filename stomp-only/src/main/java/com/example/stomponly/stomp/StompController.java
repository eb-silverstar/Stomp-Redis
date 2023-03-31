package com.example.stomponly.stomp;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StompController {

    private final SimpMessageSendingOperations sendingOperations;

    /**
     * 공간 좌표 송신
     *
     * @param id
     * @param stompDto
     */
    @MessageMapping("/{id}")
    public void sendGrid(@DestinationVariable("id") String id, StompDTO stompDto) {
        sendingOperations.convertAndSend("/space/" + id, stompDto);
    }

}
