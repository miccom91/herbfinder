package pl.blaszczak.herbfinder.dto;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class UserTO {
    private Integer id;
    private String email;
    @NotNull
    @Size(max =20, min = 3, message = "Hasło musi posiadać minimum 3 znaki")
    private String password;
    @NotNull
    @Size(max =20, min = 2,  message = "Imie musi posiadać minium 2 znaki")
    private String name;
    @NotNull
    @Size(max =20, min = 2,  message = "Nazwisko musi posiadać minium 2 znaki")
    private String lastname;
    @Pattern(regexp = "^([0+]48)?\\d{9}$",message = "Niewłaściwy format telefonu")
    private String phone;
    private String adress;
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}",message = "Nieprawidłowy format kodu pocztowego. Format 00-00")
    private String postnumber;
}
