package pl.blaszczak.herbfinder.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Attribute {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
}
