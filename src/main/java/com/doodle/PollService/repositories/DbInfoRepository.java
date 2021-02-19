package com.doodle.PollService.repositories;

import com.doodle.PollService.models.DbInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbInfoRepository extends JpaRepository<DbInfo, Boolean> {
}
