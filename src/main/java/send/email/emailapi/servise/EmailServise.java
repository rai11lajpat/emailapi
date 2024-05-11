package send.email.emailapi.servise;

import send.email.emailapi.Entity.Mail;

public interface EmailServise {
String sendSimpleEmail(Mail details);
String sendMailWithAtttachment(Mail details);
}
