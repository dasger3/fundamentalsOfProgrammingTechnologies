package voronin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Village extends AdministrativeTerritorialUnit<Village, Village> {
    private String occupation;

    public Village (TypeOfATU typeOfATU, String title,  double square, int population,
                    String name, String surname, String position,
                    String occupation) {
        super(typeOfATU,title,square, population, name,surname,position);
        this.occupation = occupation;
    }
    public Village (TypeOfATU typeOfATU, String title,  double square, int population,
                    String name, String surname, String position) {
        super(typeOfATU,title,square, population, name,surname,position);
    }
}
