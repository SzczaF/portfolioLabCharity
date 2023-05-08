package pl.coderslab.charity.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @NotNull
    @OneToMany
    private List<Category> categories;

    @NotNull
    @ManyToOne
    private Institution institution;

    @Size(max = 255)
    private String street;

    @Size(max = 100)
    private String city;

    @Size(max = 50)
    private String zipCode;

    // TODO Czemu nie LocalDateTime ? :)
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;

    @Size(max = 4000)
    private String pickUpComment;


}
