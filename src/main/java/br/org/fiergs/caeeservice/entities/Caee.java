package br.org.fiergs.caeeservice.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CCOR_CAEE")
@SequenceGenerator(name = "seqCCor_Caee", sequenceName = "SEQCCOR_CAEE", allocationSize = 1)
public class Caee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCCor_Caee")
    private Long id;

    @Size(max = 30, message = "A key deve conter no máximo 30 caracteres!")
    private String key;

    @NotEmpty(message = "Nome é obrigatória!")
    @Size(max = 150, message = "O nome deve conter no máximo 150 caracteres!")
    private String name;

    private boolean icm = false;
}
