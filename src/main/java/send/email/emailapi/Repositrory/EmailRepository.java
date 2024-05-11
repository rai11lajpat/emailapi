package send.email.emailapi.Repositrory;

import org.springframework.data.jpa.repository.JpaRepository;

import send.email.emailapi.Entity.Mail;

public interface EmailRepository extends JpaRepository<Mail,Integer>{
    
}
