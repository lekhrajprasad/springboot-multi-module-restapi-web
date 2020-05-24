package com.lpras.lombok.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialDTO {
    private String id;
    private String title;
    private String description;
    private boolean published;
}
