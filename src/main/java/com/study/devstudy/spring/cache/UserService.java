package com.study.devstudy.spring.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 기본 캐싱 - 파라미터가 캐시 키가 됨
    @Cacheable("users")
    public User findById(Long id) {
        System.out.println("DB에서 사용자 조회: " + id);
        return userRepository.findById(id).orElse(null);
    }

    // 복합 키 캐싱
    @Cacheable("users")
    public List<User> findByNameAndAge(String name, int age) {
        // 캐시 키: "users::name_age" 형태로 자동 생성
        return userRepository.findByNameAndAge(name, age);
    }

    // 커스텀 키 지정
    @Cacheable(value = "users", key = "#name + '_' + #age")
    public List<User> findByNameAndAgeWithCustomKey(String name, int age) {
        return userRepository.findByNameAndAge(name, age);
    }

    // 조건부 캐싱
    @Cacheable(value = "users", condition = "#age > 18")
    public User findAdultUser(String name, int age) {
        // 18세 이상인 경우만 캐싱
        return userRepository.findByNameAndAge(name, age).get(0);
    }

    // 결과 기반 조건
    @Cacheable(value = "users", unless = "#result == null")
    public User findUserSafely(Long id) {
        // 결과가 null이 아닌 경우만 캐싱
        return userRepository.findById(id).orElse(null);
    }

    // 특정 캐시 무효화
    @CacheEvict(value = "users", key = "#user.id")
    public void updateUser(User user) {
        userRepository.save(user);
        System.out.println("사용자 업데이트 후 캐시 무효화: ");
    }

    // 모든 캐시 무효화
    @CacheEvict(value = "users", allEntries = true)
    public void deleteAllUsers() {
        userRepository.deleteAll();
        System.out.println("모든 사용자 캐시 무효화");
    }

    // 캐시 갱신 (메서드 실행 후 결과를 캐시에 저장)
    @CachePut(value = "users", key = "#user.id")
    public User saveUser(User user) {
        User saved = userRepository.save(user);
        System.out.println("사용자 저장 후 캐시 갱신: ");
        return saved;
    }

    // 여러 캐시 동시 처리
    @Caching(
            cacheable = @Cacheable("users"),
            evict = {
                    @CacheEvict(value = "userStats", allEntries = true),
                    @CacheEvict(value = "userSummary", key = "#result.departmentId")
            }
    )
    public User findAndInvalidateStats(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
