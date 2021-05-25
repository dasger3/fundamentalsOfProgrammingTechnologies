package voronin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleResponse {
    Long id;
    String name;
    int levelAccess;
}
