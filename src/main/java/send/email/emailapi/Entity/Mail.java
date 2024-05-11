package send.email.emailapi.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SimpleEMail")
@SecondaryTable(name ="withAttachmentEmail",pkJoinColumns = @PrimaryKeyJoinColumn(name="email_id") )
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_id")
    private int id;
    private String recipient;
    private String msgBody;
    private String subject;
    @Column(table = "withAttachmentEmail",name = "attachment")
    private String attachment;
    
}
