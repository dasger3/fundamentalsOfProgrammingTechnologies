package voronin.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor

@Entity
@Table (name = "atu")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "atuId")
public class AdministrativeTerritorialUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atuId;

    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "parent_id")

    private AdministrativeTerritorialUnit parent;

    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "center_id", unique = true)

    private AdministrativeTerritorialUnit center_id;

    @Enumerated(EnumType.STRING)
    private TypeOfATU typeOfATU;

    @Column
    private String title;

    @Column
    private double square;

    @Column
    private int population;

    @OneToOne
    @JoinColumn(name = "manager_id", unique = true)
    private Manager manager;

    AdministrativeTerritorialUnit(TypeOfATU typeOfATU, String title,  double square, int population, String name, String surname, String position) {
        this.typeOfATU = typeOfATU;
        this.title = title;
        this.square = square;
        this.population = population;
        manager = new Manager(name,surname,position);

    }


}
