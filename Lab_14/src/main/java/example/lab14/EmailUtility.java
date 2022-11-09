package example.lab14;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.Properties;

public class EmailUtility {
    @SneakyThrows
    public static void sendEmail(String host, String port,
                                 final String userName, final String password, String toAddress,
                                 String subject, String message) {


        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);

        Transport.send(msg);
    }

    @SneakyThrows
    public static String showMessages(final String userEmail, final String password, final String imap)
    {
        Properties properties = new Properties();
        properties.put("mail.imaps.ssl.trust", "*");
        Store store = Session.getInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(userEmail, password);
            }
        }).getStore("imaps");
        store.connect(imap, userEmail, password);
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        StringBuilder result = new StringBuilder();



        for (Message message: folder.getMessages(1, 8))
        {
            result.append("<a href='/Lab_14/getmessage?date=")
                    .append(message.getSentDate())
                    .append("'>")
                    .append(message.getSubject())
                    .append("</a><br>");
        }

        folder.close(true);
        store.close();
        return result.toString();
    }

    @SneakyThrows
    public static String getMessage(final String userEmail, final String password, final String date, final String imap)
    {
        var properties = new Properties();
        properties.put("mail.imaps.ssl.trust", "*");
        Store store = Session.getInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(userEmail, password);
            }
        }).getStore("imaps");
        store.connect(imap, userEmail, password);
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        StringBuilder result = new StringBuilder();
        for (Message message: folder.getMessages())
        {
            if (message.getSentDate().toString().equals(date))
            {
                result.append("<div>");
                result.append("<p>Sender:   ").append(InternetAddress.toString(message.getFrom())).append("<br/>");
                result.append("Theme:   ").append(message.getSubject()).append("<br/>");
                String messageContent = "";
                String contentType = message.getContentType();

                if (contentType.contains("multipart"))
                {
                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++)
                    {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        messageContent = part.getContent().toString();
                    }
                }
                else if (contentType.contains("text/plain") || contentType.contains("text/html"))
                {
                    Object content = message.getContent();
                    if (content != null)
                    {
                        messageContent = content.toString();
                    }
                }
                result.append("Message: ").append(messageContent).append("<br/>");
                result.append("Date:    ").append(message.getSentDate()).append("</p>");
                result.append("</div>");
                result.append("-----------------------------------------------");
                result.append("</br>");
                break;
            }
        }

        folder.close(true);
        store.close();
        return result.toString();
    }


}