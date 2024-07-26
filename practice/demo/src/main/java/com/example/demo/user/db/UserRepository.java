package com.example.demo.user.db;

import com.example.demo.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);
    // findall 매서드, Score 매개변수

    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

//    @Query(
//            value = "SELECT * FROM user as u WHERE u.score >= ?1 AND u.score <= ?2",
//            nativeQuery = true
//    )
//    List<UserEntity> score(int min, int max);


}
