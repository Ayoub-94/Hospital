package com.example.hospital;

import com.example.hospital.entities.Medecin;
import com.example.hospital.entities.Patient;
import com.example.hospital.entities.RendezVous;
import com.example.hospital.entities.StatusRDV;
import com.example.hospital.repositories.MedecinRepository;
import com.example.hospital.repositories.PatientRepository;
import com.example.hospital.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication{

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository){
		return args ->{
			Stream.of("Ayoub","Hassan","Soufiane")
					.forEach(name->{;
			Patient patient = new Patient();
			patient.setNom(name);
			patient.setDateNaissance(new Date());
			patient.setMalade(false);
			patientRepository.save(patient);
					});

			Stream.of("Abdel","Ahmed","Fatima")
					.forEach(name->{;

						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						medecinRepository.save(medecin);
					});
			Patient patient=patientRepository.findById(1L).orElse(null);

			Medecin medecin=medecinRepository.findByNom("Abdel");

			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);

			rendezVousRepository.save(rendezVous);




		};
	}

}
