package amigoskazz.spring;

import amigoskazz.spring.entities.PaymentStatus;
import amigoskazz.spring.entities.PaymentType;
import amigoskazz.spring.entities.Payment;
import amigoskazz.spring.entities.Student;
import amigoskazz.spring.repo.PaymentRepository;
import amigoskazz.spring.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class StudentManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository) {
        return args -> {
            studentRepository.save(Student.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .code("112233")
                    .programmId("CS")
                        .build());
            studentRepository.save(Student.builder()
                    .firstName("Jane")
                    .lastName("Doe")
                    .code("445566")
                    .programmId("CS")
                    .build());
            studentRepository.save(Student.builder()
                    .firstName("Alice")
                    .lastName("Doe")
                    .code("778899")
                    .programmId("CS")
                    .build());
            studentRepository.save(Student.builder()
                    .firstName("Bob")
                    .lastName("Doe")
                    .code("112233")
                    .programmId("CS")
                    .build());


            PaymentType[] type = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(student -> {
                for (int i = 0; i < 10; i++) {
                    int index = random.nextInt(type.length);
                    Payment payment = Payment.builder()
                            .amount(1000+(int)(Math.random() + 20000))
                            .type(type[index])
                            .status(PaymentStatus.CRAETED)
                            .date(LocalDate.now())
                            .student(student)
                            .build();
                    paymentRepository.save(payment);

                }
            });

        };
    }

}
