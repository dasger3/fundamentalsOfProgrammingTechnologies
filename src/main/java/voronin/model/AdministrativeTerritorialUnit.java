package voronin.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    @NotBlank
    @Column
    private String title;

    @Column
    private double square;

    @Column
    private int population;

    @OneToOne
    @JoinColumn(name = "manager_id", unique = true)
    private Manager manager;

    public AdministrativeTerritorialUnit(TypeOfATU typeOfATU, String title,  double square, int population) {
        this.typeOfATU = typeOfATU;
        this.title = title;
        this.square = square;
        this.population = population;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministrativeTerritorialUnit that = (AdministrativeTerritorialUnit) o;
        if ((parent == null && that.parent!=null) || (this.parent != null && that.parent==null))
            return false;
        if (parent !=null)
            if(!Objects.equals(parent.atuId, that.parent.atuId))
                return false;
        if ((center_id == null && that.center_id!=null) || (this.center_id != null && that.center_id==null))
            return false;
        if (center_id !=null)
            if(!Objects.equals(center_id.atuId, that.center_id.atuId))
                return false;
        if ((manager == null && that.manager!=null) || (this.manager != null && that.manager==null))
            return false;
        if (manager !=null)
            if(!Objects.equals(manager.getManagerId(), that.manager.getManagerId()))
                return false;

        return Double.compare(that.square, square) == 0 && population == that.population && Objects.equals(atuId, that.atuId) && typeOfATU == that.typeOfATU && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atuId, parent.atuId, center_id.atuId, typeOfATU, title, square, population, manager.getManagerId());
    }
}
