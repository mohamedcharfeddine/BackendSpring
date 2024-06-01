package com.example.pfemed.repository;

import com.example.pfemed.models.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("SELECT SUM(a.prix) " +
            "FROM Mission m " +
            "JOIN m.articles a " +
            "WHERE m.id = :missionId " +
            "GROUP BY m.id, m.employee.id")
    List<Object[]> calculerPrixArticlesParMissionEtEmploye(@Param("missionId") Long missionId);

}
