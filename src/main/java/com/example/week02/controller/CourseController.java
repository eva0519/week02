package com.example.week02.controller;

import com.example.week02.domain.Course;
import com.example.week02.dto.CourseRequestDto;
import com.example.week02.repository.CourseRepository;
import com.example.week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {


//    Get 요청 (조회) - 전체 강의 조회 기능  _동일한 URL 맵핑을 사용하는데 집중
    private final CourseRepository courseRepository;

    @GetMapping("/api/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }


//    Post 요청 (생성) - 신규 강의 생성 기능  _동일한 URL 맵핑을 사용하는데 집중
    private final CourseService courseService;

    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return courseRepository.save(course);
    }


//      Put 요청 (수정) - 강의 수정 기능      _의도인지 모르겠는데 이렇게하면 기존에 DB 값이 들어가 있을 경우 다 지우고 수정된 값 하나만 남긴다
    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }


//      Delete 요청 (삭제) - 강의 삭제 기능
    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }

}