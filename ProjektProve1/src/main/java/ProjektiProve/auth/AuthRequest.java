package ProjektiProve.auth;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @NotNull
    private String email ;
    @NotNull
    private String password;

}
