package dz.missingsemester.backend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private EducationLevel level;
    @OneToMany
    private List<Document> documents;

    protected Course() {
    }

    public Course(String name, EducationLevel level) {
        this.name = name;
        this.level = level;
    }

    public void addDocument(Document document){
        this.documents.add(document);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(EducationLevel level) {
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EducationLevel getLevel() {
        return level;
    }

    public List<Document> getDocuments() {
        return documents;
    }
}
