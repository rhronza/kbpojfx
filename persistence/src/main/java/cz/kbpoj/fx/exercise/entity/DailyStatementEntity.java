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

    public DailyStatementEntity(Long id, LocalDate couserDay, Set<CurrencyCourseEntity> currencyCourseEntities) {
        this.id = id;
        this.couserDay = couserDay;
        this.currencyCourseEntities = currencyCourseEntities;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "courseday")
    private LocalDate couserDay;


    //    @OneToMany(mappedBy = "currencyCourseEntity")
    @OneToMany
    private Set<CurrencyCourseEntity> currencyCourseEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCouserDay() {
        return couserDay;
    }

    public void setCouserDay(LocalDate couserDay) {
        this.couserDay = couserDay;
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
        if (getCouserDay() != null ? !getCouserDay().equals(that.getCouserDay()) : that.getCouserDay() != null)
            return false;
        return getCurrencyCourseEntities() != null ? getCurrencyCourseEntities().equals(that.getCurrencyCourseEntities()) : that.getCurrencyCourseEntities() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getCouserDay() != null ? getCouserDay().hashCode() : 0);
        result = 31 * result + (getCurrencyCourseEntities() != null ? getCurrencyCourseEntities().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DailyStatementEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("couserDay=" + couserDay)
                .add("currencyCourseEntities=" + currencyCourseEntities)
                .toString();
    }
}
