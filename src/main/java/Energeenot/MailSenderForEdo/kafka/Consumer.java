package Energeenot.MailSenderForEdo.kafka;

import Energeenot.MailSenderForEdo.dto.MessageDto;
import Energeenot.MailSenderForEdo.sender.Sender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class Consumer {

    private final Sender sender;

    @KafkaListener(topics = "sendFeedbackToStudent", groupId = "edo",
            containerFactory = "KafkaListenerContainerFactory")
    public void listenFeedback(MessageDto dto, Acknowledgment ack) {
        log.info("Received feedback to student email: {}", dto.getToEmail());
        try{
            sender.sendFeedbackToStudent(dto);
        }finally {
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = "sendNotificationOfResetPassword", groupId = "edo",
            containerFactory = "KafkaListenerContainerFactory")
    public void listenResetPassword(MessageDto dto, Acknowledgment ack) {
        log.info("Received attempt to reset password email: {}", dto.getToEmail());
        try{
            sender.sendNotificationOfResetPassword(dto);
        }finally {
            ack.acknowledge();
        }
    }

    @KafkaListener(topics = "sendNotificationOfNewDocuments", groupId = "edo",
            containerFactory = "KafkaListenerContainerFactory")
    public void listenNewDocuments(MessageDto dto, Acknowledgment ack) {
        log.info("Received new document, sending notification to email: {}", dto.getToEmail());
        try{
            sender.sendNotificationOfNewDocuments(dto);
        }finally {
            ack.acknowledge();
        }
    }

}
