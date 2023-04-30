package ProjektiProve.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShipDTO {


    private Integer id ;
    @NotNull
    private String name ;
    @NotNull
    private String destination ;

}
