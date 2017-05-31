package ua.servise;


public interface MailSenderService {

    void sendMail(String theme, String mailBody, String email);

}
