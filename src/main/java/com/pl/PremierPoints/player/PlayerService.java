package com.pl.PremierPoints.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getTeam() != null && teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName() != null &&
                        player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPos(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPos() != null &&
                        player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByNation(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation() != null &&
                        player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getTeam() != null && player.getPos() != null &&
                        team.equals(player.getTeam()) && position.equals(player.getPos()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();

            // Update all fields, checking for null values
            if (updatedPlayer.getNation() != null) {
                playerToUpdate.setNation(updatedPlayer.getNation());
            }
            if (updatedPlayer.getPos() != null) {
                playerToUpdate.setPos(updatedPlayer.getPos());
            }
            if (updatedPlayer.getAge() != null) {
                playerToUpdate.setAge(updatedPlayer.getAge());
            }
            if (updatedPlayer.getMp() != null) {
                playerToUpdate.setMp(updatedPlayer.getMp());
            }
            if (updatedPlayer.getStarts() != null) {
                playerToUpdate.setStarts(updatedPlayer.getStarts());
            }
            if (updatedPlayer.getMin() != null) {
                playerToUpdate.setMin(updatedPlayer.getMin());
            }
            if (updatedPlayer.getGls() != null) {
                playerToUpdate.setGls(updatedPlayer.getGls());
            }
            if (updatedPlayer.getAst() != null) {
                playerToUpdate.setAst(updatedPlayer.getAst());
            }
            if (updatedPlayer.getPk() != null) {
                playerToUpdate.setPk(updatedPlayer.getPk());
            }
            if (updatedPlayer.getCrdy() != null) {
                playerToUpdate.setCrdy(updatedPlayer.getCrdy());
            }
            if (updatedPlayer.getCrdr() != null) {
                playerToUpdate.setCrdr(updatedPlayer.getCrdr());
            }
            if (updatedPlayer.getXg() != null) {
                playerToUpdate.setXg(updatedPlayer.getXg());
            }
            if (updatedPlayer.getXag() != null) {
                playerToUpdate.setXag(updatedPlayer.getXag());
            }
            if (updatedPlayer.getTeam() != null) {
                playerToUpdate.setTeam(updatedPlayer.getTeam());
            }

            return playerRepository.save(playerToUpdate);
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }

    // Additional helper method
    public Optional<Player> getPlayerByName(String name) {
        return playerRepository.findByName(name);
    }
}