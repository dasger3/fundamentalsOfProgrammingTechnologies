package voronin.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table (name = "atu")
public abstract class AdministrativeTerritorialUnit<T, V> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long parent_id = 0L;

    @Column
    private Long center_id = -1L;

    @Enumerated(EnumType.STRING)
    private TypeOfATU typeOfATU;

    @Column
    private String title;

    @Column
    private double square;

    @Column
    private int population;

    @Embedded
    private Manager manager;

    @Transient
    private ArrayList<T> internalList1;
    @Transient
    private ArrayList<V> internalList2;

    AdministrativeTerritorialUnit(TypeOfATU typeOfATU, String title,  double square, int population, String name, String surname, String position) {
        this.typeOfATU = typeOfATU;
        this.title = title;
        this.square = square;
        this.population = population;
        manager = new Manager(name,surname,position);
        internalList1 = new ArrayList<T>();
        internalList2 = new ArrayList<V>();

    }


    public void addToList1 (T aty1) {
        internalList1.add(aty1);
    }

    public void addToList2 (V aty2) {
        internalList2.add(aty2);
    }

    public void setManager(String name, String surname, String position) {
        this.manager = new Manager(name,surname,position);
    }

    @Override
    public String toString () {
        StringBuilder str = new StringBuilder();
        str.setLength(10);
        str.append(title);
        str.setLength(5);
        str.append(title);
        return str.toString();
    }

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public class Manager {

        String name;
        String surname;
        String position;
    }
}
