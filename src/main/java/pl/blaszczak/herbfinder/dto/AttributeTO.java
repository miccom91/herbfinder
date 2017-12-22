package pl.blaszczak.herbfinder.dto;

import lombok.*;
import pl.blaszczak.herbfinder.domain.Attribute;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class AttributeTO {
    private Integer id;
    @NotNull
    @Size(max =20, min = 2,  message = "Opis musi posiadać minium 2 znaki")
    private String description;

    AttributeTO(Attribute attribute){
        id = attribute.getId();
        description = attribute.getDescription();
    }
}
