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
    private double localizationN;
    private double localizationE;
    private Boolean isPrivate;
    @Enumerated(EnumType.STRING)
    private Ecology ecology;
    private Integer adminMark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Herb herb;

}
