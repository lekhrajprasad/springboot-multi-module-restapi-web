package com.lpras.lombok.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "email") //to load from yml file
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email implements Serializable {
    private static final long serialVersionUID = 4L;
    private String to;
    private String from;
    private String subject;
    private List<Object> attachments;
    private Map<String, Object> model;

    private String body;
    private String phone;
}
