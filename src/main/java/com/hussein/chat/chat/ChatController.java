package com.hussein.chat.chat;

import com.hussein.chat.service.ChatLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatLogService chatLogService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {
        // Log messages based on type
        if (chatMessage.getType() == MessageType.CHAT) {
            // For a regular chat message, log as "username: content"
            chatLogService.logMessage(chatMessage.getSender() + ": " + chatMessage.getContent());
        } else if (chatMessage.getType() == MessageType.LEAVE) {
            // For a leave event, log as "username left!"
            chatLogService.logMessage(chatMessage.getSender() + " left!");
        }
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        chatLogService.logMessage(chatMessage.getSender() + " joined!");
        return chatMessage;
    }
}