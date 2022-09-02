package by.bntu.poisit.spring.sprshop.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
public class MailHandler{

    @Autowired
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void sendMessage(String emailTo, String subject, String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        try {
            javaMailSender.send(mailMessage);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

}
