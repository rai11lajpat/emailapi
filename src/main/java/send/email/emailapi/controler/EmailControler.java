package send.email.emailapi.controler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import send.email.emailapi.Entity.Mail;
import send.email.emailapi.servise.EmailServise;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class EmailControler {
    @Autowired private EmailServise emailServise;

    @PostMapping("/sendSimpleMail")
    public String simple(@RequestBody Mail detailsMail) {
        String status=emailServise.sendSimpleEmail(detailsMail);
        
        return status;
    }

    @PostMapping("/sentwithAttachment")
    public String withAttachment(@RequestBody Mail detailMail){
        String status=emailServise.sendMailWithAtttachment(detailMail);
        return status;
    }

    @GetMapping("/get")
    public List getMails() {
        
        return emailServise.getAllMail();
    }
    
    
}
