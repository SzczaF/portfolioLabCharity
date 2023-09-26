package pl.coderslab.charity.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(min =6, max=20)
    private String userName;

    @NotBlank
    @Length(min =2, max=50)
    private String forename;

    @NotBlank
    @Length(min =2, max=60)
    private String surname;

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotEmpty
    @ManyToMany
    private List<Role> roles;

    @NotNull
    private boolean active;

}
