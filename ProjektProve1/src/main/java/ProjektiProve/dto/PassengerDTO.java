package ProjektiProve.dto;

import ProjektiProve.model.Ship;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerDTO {

    //@NotNull
    private Integer id ;
    //@NotNull
    private String name;
    //@NotNull
    private String surname;
    //@NotNull
    private Integer age ;
    // @NotNull
    @JsonIgnore
    private Ship ship;



}
