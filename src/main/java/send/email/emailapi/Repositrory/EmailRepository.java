package send.email.emailapi.Repositrory;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import send.email.emailapi.Entity.Mail;


public interface EmailRepository extends CrudRepository<Mail,Integer>{
    
    @Query(value="select * from emailapi.smpleemail",nativeQuery=true)
    public List<Mail> geList();
}
