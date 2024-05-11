package send.email.emailapi.Repositrory;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import send.email.emailapi.Entity.Mail;


public interface EmailRepository extends CrudRepository<Mail,Integer>{


    
    @Query(value="SELECT simpleemail.email_id,\n" + //
                "       simpleemail.msg_body,\n" + //
                "       simpleemail.recipient,\n" + //
                "       simpleemail.subject,\n" + //
                "       with_attachment_email.attachment \n" + //
                "FROM emailapi.simpleemail \n" + //
                "LEFT JOIN emailapi.with_attachment_email ON simpleemail.email_id = with_attachment_email.email_id;",nativeQuery=true)
    public List<Mail> geList();


    @Query(value = "SELECT simpleemail.email_id,\n" + //
                "       simpleemail.msg_body,\n" + //
                "       simpleemail.recipient,\n" + //
                "       simpleemail.subject,\n" + //
                "       with_attachment_email.attachment \n" + //
                "FROM emailapi.simpleemail \n" + //
                "LEFT JOIN emailapi.with_attachment_email ON simpleemail.email_id = with_attachment_email.email_id\n" + //
                "where with_attachment_email.email_id is null;",nativeQuery=true)
public List<Mail> getSimpleList();
    @Query(value = "SELECT simpleemail.email_id,\n" + //
                "       simpleemail.msg_body,\n" + //
                "       simpleemail.recipient,\n" + //
                "       simpleemail.subject,\n" + //
                "       with_attachment_email.attachment \n" + //
                "FROM emailapi.simpleemail \n" + //
                "Right JOIN emailapi.with_attachment_email ON simpleemail.email_id = with_attachment_email.email_id;",nativeQuery = true)
    public List<Mail> getAttachList();
}
