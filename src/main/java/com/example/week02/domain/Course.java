package com.example.week02.domain;

import com.example.week02.dto.CourseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Course extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String tutor;

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

//    Dto를 그릇으로 사용하는 생성자 추가
//    (Database에 정보를 저장하는 녀석은 Course가 될테니 Dto 그릇에 담긴 데이터를 쉽게 추가해줄 수 있도록 생성자를 만든다)
    public Course(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
    
}

//@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
//@Entity
//public class Course extends Timestamped {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
//    private Long id;
//
//    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
//    private String title;
//
//    @Column(nullable = false)
//    private String tutor;
//
//    public Course(String title, String tutor) {
//        this.title = title;
//        this.tutor = tutor;
//    }
//
////    자신과 같은 참조변수를 인자로 받아 update
//    public void update(Course course) {
//        this.title = course.title;
//        this.tutor = course.tutor;
//    }
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public String getTutor() {
//        return this.tutor;
//    }
//
//
//}
