package voronin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String position;


    public Manager(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

}
