package com.example.demo.controller;

import com.example.demo.model.chatJpa;
import com.example.demo.service.ChatJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * Case 1. 채팅 보낼 때
 * 채팅 쳐서 send 버튼 누를 경우
 * => 보낸 메시지는 그대로 유지 해서 react 배열의 userMessage에 저장, AI 메시지 값만 서버에서 받아오기 (getAiMessages 수행) ***
 * => handleMessages 함수에서 채팅방 배열 업뎃
 * => handleMessages 함수에서 메시지 배열 업뎃
 * => handleMessages 함수 막바지에 추가한 채팅방 배열 정보 인서트 (insertChatMessages 수행) ***
 * => 채팅창에 보임
 *
 * Case 2. 초기 화면
 * 해당 아이디에 있는 모든 채팅방 정보 불러오기(selectChat) ***
 *
 * Case 3. 삭제 하기
 * 해당 아이디에 있는 해당 채팅방 번호로 삭제 (deleteCaht) ***
 */


@RestController
@RequestMapping("/chatJpa")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatJpaController {

    private final ChatJpaService chatJpaService;

    @Autowired
    public ChatJpaController(ChatJpaService chatJpaService) {
        this.chatJpaService = chatJpaService;
    }

    // 초기 진입시 해당 유저아이디의 채팅방 및 메시지 정보 불러오기
    @PostMapping("/selectChat")
    public List<chatJpa> selectChat(@RequestBody Map<String, String> userInfo) {
        String userId = userInfo.get("username");
        System.out.println("LoginRequest user: " + userId);
        System.out.println("result login: " + chatJpaService.selectChat(userId));

        return chatJpaService.selectChat(userId);
    }

    // AI 챗봇 호출
    @PostMapping("/getAiMessages")
    public List<chatJpa> getAiMessages(@RequestBody Map<String, Integer> chatInfo) {
        int chatId = chatInfo.get("chatId");
        List<chatJpa> aiMessages = null; // AI 서버 호출해서 메시지 값 받아오는 부분
        System.out.println("LoginRequest user: " + chatId);
        System.out.println("chatId: " + chatJpaService.insertChat(chatId));

        return aiMessages;
    }

    // 해당 유저아이디의 메시지전송을 눌렀을 때 결과(전송버튼 눌렀을 때 채팅방 및 메시지 정보 insert)
    @PostMapping("/insertChatMessages")
    public int insertChat(@RequestBody Map<String, Integer> chatInfo) {
        int chatId = chatInfo.get("chatId");
        System.out.println("LoginRequest user: " + chatId);
        System.out.println("chatId: " + chatJpaService.insertChat(chatId));

        return chatJpaService.insertChat(chatId);
    }

    // 해당 유저아이디 + 채팅방아이디의 채팅방 삭제
    @PostMapping("/deleteChat")
    public int deleteChat(@RequestBody Map<String, Integer> chatInfo) {
        int chatId = chatInfo.get("chatId");
        System.out.println("LoginRequest user: " + chatId);
        System.out.println("result login: " + chatJpaService.deleteChat(chatId));

        return chatJpaService.deleteChat(chatId);
    }

}
