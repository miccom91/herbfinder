package pl.blaszczak.herbfinder.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String password;
    private String name;
    private String lastname;
    private String phone;
    private String adress;
    private String postnumber;
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;
    private Boolean isActive;
    private MultipartFile multipartFile;
    private String image;
}
