package amigoskazz.spring.controller;

import amigoskazz.spring.entities.Payment;
import amigoskazz.spring.entities.PaymentStatus;
import amigoskazz.spring.entities.Student;
import amigoskazz.spring.repo.PaymentRepository;
import amigoskazz.spring.repo.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PaymentController {
    private final PaymentRepository paymentRepository;
    private final StudentRepository studentRepository;

    public PaymentController(PaymentRepository paymentRepository, StudentRepository studentRepository) {
        this.paymentRepository = paymentRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping(path = "/payments")
    public List<Payment> allPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping(path = "/student/{code}/payments")
    public List<Payment> paymentsByStudent (@PathVariable String code) {
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping(path = "/paymentsByStatus/{status}")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentRepository.findById(id).get();
    }

    @GetMapping(path = "/students")
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/students/{code}")
    public Student getStudentByCode(@PathVariable String code) {
        return studentRepository.findByCode(code);
    }

    @GetMapping(path = "/studentsByProgramId/{programmId}")
    public List<Student> getStudentByProgrammId(@RequestParam String programmId) {
        return studentRepository.findByProgrammId(programmId);
    }

}
