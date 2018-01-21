package pl.blaszczak.herbfinder.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    @Column(length = 10000)
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Herb herb;

}
