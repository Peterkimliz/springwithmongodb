package com.example.StroreApp;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@SpringBootApplication
public class StroreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StroreAppApplication.class, args);
	}

	@Bean
	FirebaseMessaging firebaseMessaging() throws IOException {
		GoogleCredentials googleCredentials = GoogleCredentials.fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(googleCredentials).build();
		FirebaseApp firebaseApp=FirebaseApp.initializeApp(options,"SpringStore");
		return FirebaseMessaging.getInstance(firebaseApp);
	}

}
