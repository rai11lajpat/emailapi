package send.email.emailapi.emailDetails;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@SecondaryTable(name ="withAttachmentEmail" )
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
    
}
