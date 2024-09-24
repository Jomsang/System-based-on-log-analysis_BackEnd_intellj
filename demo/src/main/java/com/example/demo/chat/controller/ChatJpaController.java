package com.example.demo.chat.controller;

import com.example.demo.chat.dto.MessageDto;
import com.example.demo.chat.service.ChatJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.example.demo.chat.dto.ChatDto;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.*;


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
    public ChatJpaController(ChatJpaService chatJpaService)
    {
        this.chatJpaService = chatJpaService;
    }
    @PostMapping("/testApi")
    public String testApi(@RequestBody String testStr) {

        return testStr;
    }
    // 초기 진입시 해당 유저아이디의 채팅방 및 메시지 정보 불러오기
    @PostMapping("/selectChat")
    public List<ChatDto> selectChat(@RequestBody Map<String, String> userInfo) {
        String userId = userInfo.get("userId");
        return chatJpaService.selectChat(userId);
    }

    // AI 챗봇 호출
    @PostMapping("/getAiMessages")
    public ResponseEntity<List<Map<String, String>>> getAiMessages(@RequestBody Map<String, Object> chatInfo) {

        HashMap<String, String> userMessageObj = (HashMap<String, String>) chatInfo.get("userMessage");


        String textMessage = userMessageObj.get("textMessage").toString();
        String imageBase64 = userMessageObj.get("imgMessage").toString(); // base64 이미지 데이터

        // Flask 서버 URL 설정
        String flaskUrl = "http://localhost:5000/chat";

        RestTemplate restTemplate = new RestTemplate();

        // MultiValueMap에 텍스트 메시지와 이미지를 담아 Flask로 전송
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("textMessage", textMessage);
        requestBody.add("imgMessage", imageBase64);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        try {
            // Flask 서버로 POST 요청을 보내고 결과를 받음
            ResponseEntity<Map> response = restTemplate.postForEntity(flaskUrl, requestEntity, Map.class);

            Map<String, String> responseBody = (Map<String, String>) response.getBody();

            // 응답을 List<Map<String, String>>로 변환하여 클라이언트에 전달
            List<Map<String, String>> responseList = new ArrayList<>();
            responseList.add(responseBody);

            return ResponseEntity.ok(responseList);
        } catch (Exception e) {
            // 에러 발생 시 에러 메시지 반환
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Flask 서버와의 통신 오류: " + e.getMessage());
            List<Map<String, String>> errorList = new ArrayList<>();
            errorList.add(errorResponse);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorList);
        }
    }

    // 해당 유저아이디의 메시지전송을 눌렀을 때 결과(전송버튼 눌렀을 때 채팅방 및 메시지 정보 insert)
    // 새로운 메시지 전송
    @PostMapping("/insertChatMessages")
    public ResponseEntity<String> insertChatMessages(@RequestBody ChatDto chat) {
        System.out.println(chat.getChatId());
        System.out.println(chat.getChatName());
        chatJpaService.insertChat(chat);
        return ResponseEntity.ok("Success: Chat message inserted successfully");
    }

    // 해당 유저아이디 + 채팅방아이디의 채팅방 삭제
    // 채팅방 삭제
    @PostMapping("/deleteChat")
    public ResponseEntity<String> deleteChat(@RequestBody Map<String, String> chatInfo) {
        String userId = chatInfo.get("userId");
        Long chatId = Long.valueOf(chatInfo.get("chatId"));
        int delCnt = chatJpaService.deleteChat(userId, chatId);
        if(delCnt > 0) {return ResponseEntity.ok("Success: Chat message deleted successfully");}
        return ResponseEntity.badRequest().body("Bad Request");

    }

    // 채팅방 최대 번호 가져오기
    @GetMapping("/getMaxChatId")
    public String getMaxChatId(@RequestParam("userId") String userId) {
        return chatJpaService.getMaxChatId(userId);
    }

}
