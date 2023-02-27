package cage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import animals.Wolf;
import animals.comparators.WolfComparator;

public class WolfCage implements AnimalCage<Wolf> {

    private ArrayList<Wolf> wolfsInCage;
    private LocalDate dateFeed;

    public WolfCage() {
        this.wolfsInCage = new ArrayList<Wolf>();
    }

    public WolfCage(ArrayList<Wolf> wolfs) {
        this.wolfsInCage = wolfs;
    }

    @Override
    public void addAnimal(Wolf animal) {
        if (animal instanceof Wolf) {
            wolfsInCage.add((Wolf) animal);
        }

    }

    public ArrayList<Wolf> getAll() {
        return wolfsInCage;
    }

    @Override
    public LocalDate feed(double weightFoodKG) {
        double foodForOne = weightFoodKG / wolfsInCage.size();
        for (Wolf el : wolfsInCage) {
            el.feed(foodForOne);
        }
        dateFeed = LocalDate.now();
        return dateFeed;
    }

    @Override
    public LocalDate checkDateTheLastFeeding() {
        return dateFeed;
    }

    @Override
    public String toString() {
        StringBuilder wolfs = new StringBuilder();
        for (Wolf el : wolfsInCage) {
            wolfs.append(el.toString());
            wolfs.append(" - За решеткой");
            wolfs.append("\n");
        }
        return wolfs.toString();
    }

    public void sortByWeightAndAge() {
        Collections.sort(wolfsInCage, new WolfComparator());
    }

    @Override
    public Wolf releaseAnimalFromCage() {
        if (wolfsInCage.size() > 0) {
            Wolf wolfRemoved = wolfsInCage.get(0);
            wolfsInCage.remove(0);
            return wolfRemoved;
        }
        return null;
    }
}