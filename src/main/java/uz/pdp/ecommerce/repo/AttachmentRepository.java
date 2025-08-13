package uz.pdp.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ecommerce.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}