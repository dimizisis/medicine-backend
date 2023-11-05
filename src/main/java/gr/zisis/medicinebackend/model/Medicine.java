package gr.zisis.medicinebackend.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(
        name = "medicine",
        uniqueConstraints = @UniqueConstraint(
                name = "name_date_barcode",
                columnNames = {"name", "expirationDate", "barcode"}
        )
)
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String expirationDate;
    @Column
    private Integer stock;
    @Column
    private String barcode;
    @Column
    private String remarks;
}
