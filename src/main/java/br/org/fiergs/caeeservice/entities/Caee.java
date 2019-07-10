package br.org.fiergs.caeeservice.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CAD_CAEE")
@SequenceGenerator(name = "seqCad_Caee", sequenceName = "SEQCAD_CAEE", allocationSize = 1)
public class Caee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_Caee")
    private Long id;

    @NotEmpty(message = "Código é obrigatório!")
    private String code;

    @NotEmpty(message = "Descrição é obrigatória!")
    private String description;

    private boolean icms = false;
}
