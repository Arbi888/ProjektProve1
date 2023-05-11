package ProjektiProve.model;


import lombok.*;


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
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "ship_id" , referencedColumnName = "id")
    private Ship shipID;





}
