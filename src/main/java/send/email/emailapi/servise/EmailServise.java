package send.email.emailapi.servise;

import java.util.List;

import send.email.emailapi.Entity.Mail;

public interface EmailServise {
String sendSimpleEmail(Mail details);
String sendMailWithAtttachment(Mail details);
List getAllMail();
}
