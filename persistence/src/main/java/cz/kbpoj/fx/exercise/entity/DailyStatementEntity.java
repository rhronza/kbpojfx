package cz.kbpoj.fx.exercise.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;
import java.util.StringJoiner;

@Entity
@Table(name = "DAILY_STATEMENT")

public class DailyStatementEntity {

    public DailyStatementEntity() {
    }

    public DailyStatementEntity(Long id, LocalDate courseDay, Set<CurrencyCourseEntity> currencyCourseEntities) {
        this.id = id;
        this.courseDay = courseDay;
        this.currencyCourseEntities = currencyCourseEntities;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "courseday")
    private LocalDate courseDay;


    //    @OneToMany(mappedBy = "currencyCourseEntity")
    @OneToMany
    private Set<CurrencyCourseEntity> currencyCourseEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(LocalDate couserDay) {
        this.courseDay = couserDay;
    }

    public Set<CurrencyCourseEntity> getCurrencyCourseEntities() {
        return currencyCourseEntities;
    }

    public void setCurrencyCourseEntities(Set<CurrencyCourseEntity> currencyCourseEntities) {
        this.currencyCourseEntities = currencyCourseEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DailyStatementEntity that)) return false;

        if (!getId().equals(that.getId())) return false;
        if (getCourseDay() != null ? !getCourseDay().equals(that.getCourseDay()) : that.getCourseDay() != null)
            return false;
        return getCurrencyCourseEntities() != null ? getCurrencyCourseEntities().equals(that.getCurrencyCourseEntities()) : that.getCurrencyCourseEntities() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getCourseDay() != null ? getCourseDay().hashCode() : 0);
        result = 31 * result + (getCurrencyCourseEntities() != null ? getCurrencyCourseEntities().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DailyStatementEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("couserDay=" + courseDay)
                .add("currencyCourseEntities=" + currencyCourseEntities)
                .toString();
    }
}
