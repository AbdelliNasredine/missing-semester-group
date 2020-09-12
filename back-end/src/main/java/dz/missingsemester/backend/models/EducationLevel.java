package dz.missingsemester.backend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class EducationLevel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Course> courses;

    protected EducationLevel(){}

    public EducationLevel(String name) {
        this.name = name;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
