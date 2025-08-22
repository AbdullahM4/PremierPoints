package com.pl.PremierPoints.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    // Find player by name (since name is your primary key)
    Optional<Player> findByName(String name);

    // Delete player by name
    void deleteByName(String name);

    // Custom queries for better performance (optional but recommended)
    @Query("SELECT p FROM Player p WHERE p.team = :teamName")
    List<Player> findByTeam(@Param("teamName") String teamName);

    @Query("SELECT p FROM Player p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Player> findByNameContainingIgnoreCase(@Param("name") String name);

    @Query("SELECT p FROM Player p WHERE LOWER(p.pos) LIKE LOWER(CONCAT('%', :position, '%'))")
    List<Player> findByPosContainingIgnoreCase(@Param("position") String position);

    @Query("SELECT p FROM Player p WHERE LOWER(p.nation) LIKE LOWER(CONCAT('%', :nation, '%'))")
    List<Player> findByNationContainingIgnoreCase(@Param("nation") String nation);

    @Query("SELECT p FROM Player p WHERE p.team = :team AND p.pos = :position")
    List<Player> findByTeamAndPos(@Param("team") String team, @Param("position") String position);
}