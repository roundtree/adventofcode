package nl.roundtree.day03;

public class ElfGroup {

    final Rucksacks rucksacks;

    ElfGroup(final Rucksacks rucksacks) {
        this.rucksacks = rucksacks;
    }

    int getSumOfBadgeItemPriority() {
        return Compartment.getItemPriority(rucksacks.getBadgeItem());
    }
}
