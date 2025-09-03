package com.project.depo_ai.service.Email;

import com.project.depo_ai.repository.Email.IEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendVerificationEmail(String recipient, String verificationCode) throws MessagingException {
        String htmlContent = generateHtmlContent(verificationCode);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom("hello.hamzacicek@gmail.com");
        helper.setTo(recipient);
        helper.setSubject("Şifre Sıfırlama Kodu");
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }

    private String generateHtmlContent(String verificationCode) {
        // Burada sadece HTML içerik üretimi var
        return "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>... Doğrulama </title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f4f4f4;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .email-container {\n" +
                "            width: 100%;\n" +
                "            padding: 20px;\n" +
                "            background-color: #f4f4f4;\n" +
                "        }\n" +
                "        .email-content {\n" +
                "            background-color: #ffffff;\n" +
                "            padding: 30px;\n" +
                "            border-radius: 8px;\n" +
                "            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        h1 {\n" +
                "            color: #4CAF50;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        p {\n" +
                "            font-size: 16px;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "        .verification-code {\n" +
                "            font-size: 24px;\n" +
                "            font-weight: bold;\n" +
                "            color: #333;\n" +
                "            background-color: #f0f8ff;\n" +
                "            padding: 10px;\n" +
                "            border-radius: 5px;\n" +
                "            text-align: center;\n" +
                "            margin-top: 20px;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            font-size: 14px;\n" +
                "            text-align: center;\n" +
                "            margin-top: 20px;\n" +
                "            color: #777;\n" +
                "        }\n" +
                "        @media (max-width: 600px) {\n" +
                "            .email-content {\n" +
                "                padding: 20px;\n" +
                "            }\n" +
                "            h1 {\n" +
                "                font-size: 22px;\n" +
                "            }\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"email-container\">\n" +
                "        <div class=\"email-content\">\n" +
                "            <h1>...  Doğrulama Kodunuz</h1>\n" +
                "            <p>Merhaba,</p>\n" +
                "            <p>Bu e-posta, ... platformunda hesap doğrulamanız için gönderilmiştir.</p>\n" +
                "            <p>Doğrulama kodunuzu aşağıda bulabilirsiniz:</p>\n" +
                "            <div class=\"verification-code\">" + verificationCode + "</div>\n" +
                "            <p>Bu kodu kullanarak hesabınızı doğrulayabilirsiniz. Kod yalnızca 1 saat geçerlidir.</p>\n" +
                "            <div class=\"footer\">\n" +
                "                <p>... Eğitim Platformu</p>\n" +
                "                <p>Bu e-posta, ...'ne kayıt olduğunuz için size gönderilmiştir. Eğer bu e-postayı almayı istemiyorsanız, lütfen aboneliğinizi iptal edin.</p>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}
