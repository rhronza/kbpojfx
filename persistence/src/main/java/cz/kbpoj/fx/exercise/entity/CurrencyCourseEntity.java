package cz.kbpoj.fx.exercise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.StringJoiner;

@Entity
@Table(name = "CURRENCY_COURSE")
public class CurrencyCourseEntity {

    public CurrencyCourseEntity() {
    }

    public CurrencyCourseEntity(Long id, String currency, Integer amount, Float course) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
        this.course = course;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "course")
    private Float course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

       public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getCourse() {
        return course;
    }

    public void setCourse(Float course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyCourseEntity that)) return false;

        if (!getId().equals(that.getId())) return false;
        if (getCurrency() != null ? !getCurrency().equals(that.getCurrency()) : that.getCurrency() != null)
            return false;
        if (getAmount() != null ? !getAmount().equals(that.getAmount()) : that.getAmount() != null) return false;
        return getCourse() != null ? getCourse().equals(that.getCourse()) : that.getCourse() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getCurrency() != null ? getCurrency().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getCourse() != null ? getCourse().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CurrencyCourseEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("currency='" + currency + "'")
                .add("amount=" + amount)
                .add("course=" + course)
                .toString();
    }
}
