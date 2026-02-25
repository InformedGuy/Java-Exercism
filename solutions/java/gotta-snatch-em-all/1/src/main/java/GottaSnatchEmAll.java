import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        if (myCollection.isEmpty() || theirCollection.isEmpty() || myCollection.containsAll(theirCollection)) {
            return false;
        }

        Set<String> uniqueCards = new HashSet<>(myCollection);
        uniqueCards.removeAll(theirCollection);
        return !uniqueCards.isEmpty();
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> common = new HashSet<>(collections.getFirst());

        for (int i = 1; i < collections.size(); i++) {
            common.retainAll(collections.get(i));
        }

        return common;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> uniqueCards = new HashSet<>();
        for (Set<String> collection : collections) {
            uniqueCards.addAll(collection);
        }
        return uniqueCards;
    }
}
