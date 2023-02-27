package zoo;

import animals.Lion;
import animals.Snake;
import animals.Wolf;
import cage.AnimalCage;
import cage.LionCage;
import cage.SnakeCage;
import cage.WolfCage;

public class Zoo {

    public AnimalCage<Wolf> wolfs = new WolfCage();
    public AnimalCage<Lion> lions = new LionCage();
    public AnimalCage<Snake> snakes = new SnakeCage();

    public Zoo() {
    };

    public Zoo(AnimalCage<Wolf> wolfs,
               AnimalCage<Lion> lions,
               AnimalCage<Snake> snakes) {
        this.wolfs = wolfs;
        this.lions = lions;
        this.snakes = snakes;
    }

    public void showAllLions() {
        System.out.println();
        System.out.println("Все львы в зоопарке: ");
        System.out.println(lions);
    }

    public Lion takeOfLion() {
        return lions.releaseAnimalFromCage();
    }

    public void addLion(Lion lion) {
        lions.addAnimal(lion);
    }
}