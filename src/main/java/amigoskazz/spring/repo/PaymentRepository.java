package amigoskazz.spring.repo;

import amigoskazz.spring.entities.PaymentStatus;
import amigoskazz.spring.entities.PaymentType;
import amigoskazz.spring.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType (PaymentType type);
}
