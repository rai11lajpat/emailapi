package send.email.emailapi.helper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import send.email.emailapi.Entity.Mail;
import send.email.emailapi.Repositrory.EmailRepository;
import send.email.emailapi.servise.EmailServise;

@Service
public class EmailServiseImpl implements EmailServise {

    @Autowired EmailRepository emailRepository;
    @Autowired private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;



    @Override
    public String sendSimpleEmail(Mail details){
        try {
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());


            javaMailSender.send(mailMessage);
            emailRepository.save(details);
            return "Mail sent Successfully...";
        } catch (Exception e) {
            return "Error while sending email";
        }
    }


    
    

    @Override
    public String sendMailWithAtttachment(Mail details) {
        // TODO Auto-generated method stub
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setSubject(details.getSubject());
            mimeMessageHelper.setText(details.getMsgBody());
            FileSystemResource file=new FileSystemResource(details.getAttachment());

            mimeMessageHelper.addAttachment(file.getFilename(), file);
            javaMailSender.send(mimeMessage);
            emailRepository.save(details);

            return "Sent Successfully with attachment......";
        } catch (Exception e) {
            return "Error......";
        }
        
    }

    


    @Override
    public List getAllMail() {
        List<Mail> list=(List<Mail>)this.emailRepository.geList();
        return list;
    }


    




}
