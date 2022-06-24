package softuni.bg.battleships.services;

import org.springframework.stereotype.Service;
import softuni.bg.battleships.models.Ship;
import softuni.bg.battleships.models.dtos.StartBattleDTO;
import softuni.bg.battleships.repositories.ShipRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {

    private final ShipRepository shipRepository;

    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void attack(StartBattleDTO attackData) {
        Optional<Ship> attackerOpt = this.shipRepository.findById((long) attackData.getAttackerId());
        Optional<Ship> defenderOpt = this.shipRepository.findById((long) attackData.getDefenderId());

        if (attackerOpt.isEmpty() || defenderOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        Ship attacker = attackerOpt.get();
        Ship defender = defenderOpt.get();

        long newDefenderHealth = defender.getHealth() - attacker.getPower();

        if (newDefenderHealth <= 0) {
            this.shipRepository.delete(defender);
        } else {
            defender.setHealth(newDefenderHealth);
            this.shipRepository.save(defender);
        }

    }
}
