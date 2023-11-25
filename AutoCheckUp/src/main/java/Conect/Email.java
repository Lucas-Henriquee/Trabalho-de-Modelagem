package Conect;

import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {

    public static void envia() throws RuntimeException {

        final String username = "no.reply.autocheckup@hotmail.com"; // Seu endereço de e-mail
        final String password = "Te$tE#23*"; // Sua senha

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp-mail.outlook.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com"); // Servidor SMTP (exemplo: Gmail)
        props.put("mail.smtp.port", "587"); // Porta do servidor SMTP

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // E-mail remetente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kauapsilveira@gmail.com")); // E-mail destinatário
            message.setSubject("Assunto do e-mail");
            
            // Criar o corpo do e-mail em HTML
            String htmlBody = "<img src=\"cid:imagem\" height=\"120px\" width=\"120px\"> <p></p>"
                            + "<div> Olá, "+ "Kauã" +"</div>"
                            + "<p>Aqui está sua chave para validação do email: </p>"
                            + "<p>"+ new Criptografia().generate("kauapsilveira@gmail.com") + "</p>"
                            + "<p>Atenciosamente, <br> AutoCheck</p>";

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(htmlBody, "text/html; charset=utf-8");

            // Anexar a imagem
            MimeBodyPart imagemPart = new MimeBodyPart();
            imagemPart.attachFile("src/main/java/Images/LogoF.jpeg"); // Substitua com o caminho da sua imagem
            imagemPart.setContentID("<imagem>"); // Definir o ID da imagem

            // Adicionar a imagem como parte do conteúdo
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlPart);
            multipart.addBodyPart(imagemPart);
            

            message.setContent(multipart);
            //message.setText("Testando 123");
            // Enviar e-mail
            Transport.send(message);

            System.out.println("E-mail com imagem enviado com sucesso!");

        }catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
