package com.example.StroreApp.services;

import com.example.StroreApp.DTO.Note;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.rmi.server.LogStream.log;

@Slf4j
@Service
public class PushNotificationService {
  @Autowired
    private  FirebaseMessaging firebaseMessaging;

    public String sendNotification(Note note, String token) throws FirebaseMessagingException {

        Notification notification=Notification
                .builder().setTitle(note.getTitle())
                .setBody(note.getBody())
                .build();
        Message message= Message.builder()
                .setTopic("BGDSSoD-GPdUMjoqBtG9Zx-VfYYSIHwS0ZQS1bVABsSEQkjQTEq1lrURZk3c6a-CxRMcrjeRDh0tW4eIvKDCkdk")
                .setNotification(notification)
                .putAllData(note.getData())
                .build();
        return firebaseMessaging.send(message);

    }


}

