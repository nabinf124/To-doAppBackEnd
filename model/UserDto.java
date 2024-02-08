
package com.budhathoki.edu.model;
import java.util.List;
import lombok.Data;
@Data
public class UserDto {
    private Long id;
    private String username;
    private String role;
    private List<TaskDTO> tasks;

}


