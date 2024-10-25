package br.com.actionlabs.carboncalc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("userEmissionFactor")
public class UserEmissionFactor {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;

    private String email;

    private String uf;

    private String phoneNumber;

}
