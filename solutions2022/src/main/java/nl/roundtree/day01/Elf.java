package nl.roundtree.day01;

import java.util.ArrayList;
import java.util.List;

public class Elf {

    final List<Integer> caloriesPerFoodItem = new ArrayList<>();

    void addFoodItemNumberOfCalories(int numberOfCalories) {
        caloriesPerFoodItem.add(numberOfCalories);
    }

    int getTotalNumberOfCalories() {
        return caloriesPerFoodItem
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public String toString() {
        return "Elf{" +
                "caloriesPerFoodItem=" + caloriesPerFoodItem +
                '}';
    }
}
