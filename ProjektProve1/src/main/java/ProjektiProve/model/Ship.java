package ProjektiProve.model;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "ships")
public class Ship  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column
    private String name ;
    @Column
    private String destination;

    @ToString.Exclude
    @OneToMany(mappedBy = "ship" , cascade = CascadeType.ALL)
    private List<Passenger> passengerList ;



}
