package com.donetion.system.Entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Registration {

    private String Username;
    private String Email;
    private String Password;
}
