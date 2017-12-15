package pl.blaszczak.herbfinder.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Localization {
    @Id
    @GeneratedValue

    private Integer id;
    public String comment;
    private double localizationN = 49.00;
    private double localizationE = 14.07;
    private Boolean isPrivate;
    private String ecology;
    private Integer adminMark;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;


}
