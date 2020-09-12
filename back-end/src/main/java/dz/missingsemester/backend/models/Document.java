package dz.missingsemester.backend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Document implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @ManyToOne
    private Course course;
    @Lob
    private byte[] data;
    private LocalDate createdAt;
    private LocalDate updateAt;

    protected Document() {
    }

    @PrePersist
    private void beforePersist(){
        this.createdAt = LocalDate.now();
        this.updateAt = LocalDate.now();
    }

    @PreUpdate
    private void beforeUpdate(){
        this.updateAt = LocalDate.now();
    }

    public Document(String name, String type, byte[] data, Course course) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

