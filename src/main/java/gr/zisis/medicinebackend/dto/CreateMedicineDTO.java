package gr.zisis.medicinebackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateMedicineDTO {
    private String name;
    private String expirationDate;
    private Integer stock;
    private String barcode;
    private String remarks;
}
