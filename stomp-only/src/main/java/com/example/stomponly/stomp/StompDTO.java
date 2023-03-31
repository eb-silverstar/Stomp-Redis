package com.example.stomponly.stomp;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class StompDTO {

    /**
     * 처리 구분 (init or update)
     */
    private String stat;

    /**
     * 사용자 좌표 정보 목록
     */
    private List<Map<String, Object>> users;

    /**
     * 스몰톡 좌표 정보 목록
     */
    private List<Map<String, Object>> smallTalks;

}