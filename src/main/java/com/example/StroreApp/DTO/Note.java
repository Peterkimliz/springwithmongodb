package com.example.StroreApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@Data
public class Note {
    @NotBlank(message = "please enter title")
    private String title;
    @NotBlank(message = "please enter body")
    private String body;
    private Map<String, String> data;
}
