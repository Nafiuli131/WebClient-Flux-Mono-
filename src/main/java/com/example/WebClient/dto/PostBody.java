package com.example.WebClient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostBody {
    private int userId;
    private int id;
    private String title;
    private String body;
}
