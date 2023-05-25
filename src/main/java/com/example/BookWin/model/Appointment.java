package com.example.BookWin.model;

import com.example.BookWin.Enum.DoseNo;
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
@Table(name = "appointment")
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @CreationTimestamp
    @Column(name = "date_of_appoinment")
    Date dateOfAppointment;

    @Column(name = "appointment_no", unique = true,nullable = false)
    String appointmentNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "dose_no")
    DoseNo doseNo;

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Doctor doctor;



}





