package nl.roundtree.day03;

record ElfGroup(Rucksacks rucksacks) {

    int getSumOfBadgeItemPriority() {
        return Compartment.getItemPriority(rucksacks.getBadgeItem());
    }
}
