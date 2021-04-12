package voronin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleUser role;

    public User (String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
