package pl.blaszczak.herbfinder.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Species {

    @Id
    @GeneratedValue
    public  Integer id;
    private String discription;
    //w odzielnej tablicy wlasciwosci roslin


}
