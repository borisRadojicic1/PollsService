package com.doodle.PollService.repositories;

import com.doodle.PollService.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, String> {

    @Query("select p from Poll p where lower(p.title) like lower(concat(:title,'%'))")
    List<Poll> findAllByTitle(@Param("title") String title);

    @Query("select p from Poll p where p.initiated > :date")
    List<Poll> findAllCreatedAfter(@Param("date") Timestamp date);

}
