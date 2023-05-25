package com.example.BookWin.model;

import com.example.BookWin.Enum.VaccineType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "dose1")
@Builder
public class Dose1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name= "dose_id")
    String doseId;

    @Column(name= "type")
    VaccineType type;

    @CreationTimestamp
    @Column(name= "vaccination_date")
    Date vaccinationDate;

    @OneToOne
    @JoinColumn
    User user;
}
