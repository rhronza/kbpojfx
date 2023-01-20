package cz.kbpoj.fx.exercise.facade;

import cz.kbpoj.fx.exercise.domain.Courses;
import cz.kbpoj.fx.exercise.exception.KbpojDayIsOlderThenOneMonthException;
import cz.kbpoj.fx.exercise.service.CourseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Implementation of {@link CourseFacade }
 */
@Service
public class CourseFacadeImpl implements CourseFacade {

    private final CourseService courseService;

    public CourseFacadeImpl(CourseService courseService) {
        this.courseService = courseService;
    }


    @Override
    public Courses getDayCource(LocalDate dayCourse) {
        if (LocalDate.now().minusMonths(1).isAfter(dayCourse)) {
            throw new KbpojDayIsOlderThenOneMonthException("Day is older than 1 month.", dayCourse);
        }
        return courseService.getDayCource(dayCourse);
    }
}
