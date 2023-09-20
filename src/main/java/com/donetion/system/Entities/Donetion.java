package com.donetion.system.Entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Donation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Donetion {
    private String medicinesName;
    private String emailId;
    private String contactNo;
    private String address;
    private String purchaseDate;
    private String expireDate;

}
