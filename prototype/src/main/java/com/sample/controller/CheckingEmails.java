package com.sample.controller;


import javax.mail.*;
import java.util.Properties;

public class CheckingEmails {

    public String check(String user, String password) {
        String host = "imap.gmail.com";// change accordingly
        String mailStoreType = "imap";

        StringBuilder text = new StringBuilder();
        try {

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "995");
            properties.put("mail.imap.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("imaps");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            text.append("messages.length---" + messages.length);
            text.append("\n");

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                text.append("---------------------------------");
                text.append("\n");
                text.append("Email Number " + (i + 1));
                text.append("\n");
                text.append("Subject: " + message.getSubject());
                text.append("\n");
                text.append("From: " + message.getFrom()[0]);
                text.append("\n");
                text.append("Text: " + message.getContent().toString());

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();
    }


}