package pl.coderslab.charity.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive //sprawdza czy większe niż 0
    private Integer quantity;

    @NotEmpty
    @ManyToMany
    private Set<Category> categories;

    @NotNull
    @ManyToOne
    private Institution institution;

    @NotBlank
    @Length(max = 255)
    private String street;

    @NotBlank
    @Length(max = 100)
    private String city;

    @NotBlank
    @Length(max = 50)
    private String zipCode;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull
    private LocalTime pickUpTime;

    @Length(max = 4000)
    private String pickUpComment;


}
