package voronin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    private String name;
    private String surname;
    private String position;


    public Manager(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

}
