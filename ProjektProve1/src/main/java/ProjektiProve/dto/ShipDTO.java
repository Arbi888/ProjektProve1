package ProjektiProve.dto;

import ProjektiProve.model.Passenger;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ShipDTO {


    private Integer id ;
    //@NotNull
    private String name ;
    //@NotNull
    private String destination ;
    private List<PassengerDTO> passengerList;

}
