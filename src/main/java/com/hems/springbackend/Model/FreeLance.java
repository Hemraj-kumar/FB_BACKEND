package com.hems.springbackend.Model;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("freelance")
@Data
public class FreeLance {
    @Id
    private String user_id;
    private String user_name;
    private String password;
    @Value("${Role:Freelancer}")
    private String Role;
    private String[] Skills;
}
