package voronin.model;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@EqualsAndHashCode

@Entity
@Table (name = "atu")
public class AdministrativeTerritorialUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atuId;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private AdministrativeTerritorialUnit parent;

    @OneToOne
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


    public AdministrativeTerritorialUnit () {

    }
    AdministrativeTerritorialUnit(TypeOfATU typeOfATU, String title,  double square, int population, String name, String surname, String position) {
        this.typeOfATU = typeOfATU;
        this.title = title;
        this.square = square;
        this.population = population;
        manager = new Manager(name,surname,position);
        //internalList1 = new ArrayList<Long>();
        //internalList2 = new ArrayList<Long>();

    }


    //    public void addToList1 (T aty1) {
//        internalList1.add(aty1);
//    }
//
//    public void addToList2 (V aty2) {
//        internalList2.add(aty2);
//    }

//    public void setManager(String name, String surname, String position) {
//        this.manager = new Manager(name,surname,position);
//    }

    @Override
    public String toString () {
        StringBuilder str = new StringBuilder();
        str.setLength(10);
        str.append(title);
        str.setLength(5);
        str.append(title);
        return str.toString();
    }


}
