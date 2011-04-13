/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.core;

import com.genrep.client.EmailClient;
import com.genrep.email.MailSettings;
import com.genrep.email.Message;
import javax.mail.MessagingException;

/**
 *
 * @author kiril
 */
public class Verify {

    MailSettings mailSettings = new MailSettings();
    Message mailMessage = new Message();
    EmailClient gmailClient = new EmailClient();

    public Verify() {
        notifyOnStart();
    }

    public void notifyOnStart() {
        String string = "";

        mailSettings.setHost("gmail.com");
        mailSettings.setPort("465");
        mailSettings.setFrom("salesassistantapp@gmail.com");
        mailSettings.setTo("salesassistantapp@gmail.com");
        mailSettings.setUsername("salesassistantapp");
        mailSettings.setPassword("salesassistant11s");

        mailMessage.setBody(
                "OS name :" + System.getProperty("os.name") + "\n"
                + "OS version :" + System.getProperty("os.version") + "\n"
                + "JAVA version :" + System.getProperty("java.version") + "\n"
                + "user name :" + System.getProperty("user.name") + "\n"
                + string + "\n");
        try {
            gmailClient.setGmailSettings(mailSettings, mailMessage);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
