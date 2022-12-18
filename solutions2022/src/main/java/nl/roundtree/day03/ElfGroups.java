package nl.roundtree.day03;

import java.util.List;

record ElfGroups(List<ElfGroup> elfGroups) {

    int getSumOfBadgeItemPriorityForAllGroups() {
        return elfGroups
                .stream()
                .mapToInt(ElfGroup::getSumOfBadgeItemPriority)
                .sum();
    }
}
