package Energeenot.MailSenderForEdo.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private String uniqueCode;
    private String toEmail;
    private String fio;
    private String numberGroup;
    private String messageToTeacher;
    private String token;
    private String teacherName;
    private String feedback;
}
