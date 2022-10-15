package com.example.StroreApp.controllers;

import com.example.StroreApp.DTO.Note;
import com.example.StroreApp.services.PushNotificationService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sendNotification")
public class NotificationController {
   @Autowired
    private PushNotificationService pushNotificationService;

    @PostMapping
    public String sendNotification(@RequestBody @Validated Note note) throws FirebaseMessagingException {
        return pushNotificationService.sendNotification(note,"token");
    }
}
