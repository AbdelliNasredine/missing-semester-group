package dz.missingsemester.backend.repositories;

import dz.missingsemester.backend.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository  extends JpaRepository<Document, Long> {
}
