package com.hussein.chat.chat;

import lombok.*;
import org.apache.logging.log4j.message.Message;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;
}
