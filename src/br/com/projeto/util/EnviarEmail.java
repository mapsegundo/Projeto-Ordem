/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author Shall
 */
public class EnviarEmail {

    public void enviar(String caminho, String desc_arquivo, String nome_arquivo) {

        //Montar as configurações do email
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSslSmtpPort("465");
        //email.setSSLOnConnect(true);
        //email.setSmtpPort(465);
        email.setStartTLSRequired(true);
        email.setStartTLSEnabled(true);
        email.setSSLOnConnect(true);
        

        //Fazendo a autenticação
        email.setAuthenticator(new DefaultAuthenticator("digite seu email", "digite sua senha"));
        try {

            email.setDebug(true);
            email.setFrom(""); //quem envia
            email.setSubject("Assunto do E-mail");
            email.setMsg("Texto sem formatação");
            email.addTo(""); //quem ira receber

            //Anexando um arquivo
            /*
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(caminho);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription(desc_arquivo);
            attachment.setName(nome_arquivo);

            email.attach(attachment);
*/
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

}
