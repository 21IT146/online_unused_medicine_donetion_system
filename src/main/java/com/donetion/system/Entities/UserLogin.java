package com.donetion.system.Entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_Data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLogin {

    private int Id;
    private String Email;
    private String Password;
}
