package voronin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "user")
public class User {
    @Id
    private long id;
    private String name;
    private String surname;
    private Boolean isAdmin;
}
