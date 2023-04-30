package ProjektiProve.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "passenger")

public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Integer age ;


    @ManyToOne
    @JoinColumn(name = "ship_id" , referencedColumnName = "id")
    private Ship ship;

}
