package kz.example.G129.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "DURATION")
    private double duration;

    @ManyToOne
    @JoinColumn(name = "DIRECTOR_ID")
    private Director director;

}
