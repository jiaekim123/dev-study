package com.study.devstudy.spring.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 설명 :
 *
 * @author 김지애(Nova) / jiae.kim413@dreamus.io
 * @since 2022/06/07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademyServiceTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AcademyService academyService;

    @After
    public void cleanAll() {
        academyRepository.deleteAll();
        teacherRepository.deleteAll();
    }

    @Before
    public void setup() {
        List<Academy> academies = new ArrayList<>();
        Teacher teacher = teacherRepository.save(new Teacher("선생님"));

        for (int i = 0; i < 10; i++) {
            Academy academy = Academy.builder()
                    .name("강남스쿨" + i)
                    .build();

            academy.addSubject(Subject.builder().name("자바웹개발" + i).teacher(teacher).build());
            academy.addSubject(Subject.builder().name("파이썬자동화" + i).teacher(teacher).build()); // Subject를 추가
            academies.add(academy);
        }

        academyRepository.saveAll(academies);
    }

    @Test
    public void Academy여러개를_조회시_Subject가_N1_쿼리가발생한다() throws Exception {
        //given
        System.out.println("조회 시작: findAllSubjectNames");
        List<String> subjectNames = academyService.findAllSubjectNames();
        System.out.println("조회 끝");

        //then
        assertThat(subjectNames.size(), is(10));
    }

    @Test
    public void Academy여러개를_joinFetch로_가져온다() throws Exception {
        //given
        System.out.println("조회 시작: findAllJoinFetch");
        List<Academy> academies = academyRepository.findAllJoinFetch();
        System.out.println("조회 시작: findAllSubjectNamesByJoinFetch");
        List<String> subjectNames = academyService.findAllSubjectNamesByJoinFetch();
        System.out.println("조회 끝");

        //then
        assertThat(academies.size(), is(20)); // 20개가 조회!?
        assertThat(subjectNames.size(), is(20)); // 20개가 조회!?
    }

    @Test
    public void Academy여러개를_EntityGraph로_가져온다() throws Exception {
        //given
        System.out.println("조회 시작: findAllEntityGraph");
        List<Academy> academies = academyRepository.findAllEntityGraph();
        System.out.println("조회 시작: findAllSubjectNamesByEntityGraph");
        List<String> subjectNames = academyService.findAllSubjectNamesByEntityGraph();
        System.out.println("조회 끝");

        //then
        assertThat(academies.size(), is(10));
        assertThat(subjectNames.size(), is(10));
    }

    @Test
    public void Academy여러개를_distinct해서_가져온다() throws Exception {
        //given
        System.out.println("조회 시작: findAllJoinFetchDistinct");
        List<Academy> academies = academyRepository.findAllJoinFetchDistinct();

        //then
        System.out.println("조회 끝");
        assertThat(academies.size(), is(10));
    }

    @Test
    public void Academy_Subject_Teacher를_한번에_가져온다() throws Exception {
        //given
        System.out.println("조회 시작: findAllWithTeacher");
        List<Teacher> teachers = academyRepository.findAllWithTeacher().stream()
                .map(a -> a.getSubjects().get(0).getTeacher())
                .collect(Collectors.toList());

        //then
        System.out.println("조회 끝");
        assertThat(teachers.size(), is(10));
    }

    @Test
    public void Academy_Subject_Teacher를_EntityGraph한번에_가져온다() throws Exception {
        //given
        System.out.println("조회 시작: findAllEntityGraphWithTeacher");
        List<Teacher> teachers = academyRepository.findAllEntityGraphWithTeacher().stream()
                .map(a -> a.getSubjects().get(0).getTeacher())
                .collect(Collectors.toList());

        //then
        System.out.println("조회 끝");
        assertThat(teachers.size(), is(10));
        assertThat(teachers.get(0).getName(), is("선생님"));

    }
}
