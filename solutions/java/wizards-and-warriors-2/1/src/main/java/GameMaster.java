public class GameMaster {

    public String describe(Character character) {
        String characterType = character.getCharacterClass();
        int level = character.getLevel();
        int hitPoints = character.getHitPoints();

        return "You're a level " + level + " " + characterType + " with " + hitPoints + " hit points.";
    }

    public String describe(Destination destination) {
        String destinationName = destination.getName();
        int inhabitants = destination.getInhabitants();

        return "You've arrived at " + destinationName + ", which has " + inhabitants + " inhabitants.";
    }

    public String describe(TravelMethod travelMethod) {
        if (travelMethod == TravelMethod.WALKING) {
            return "You're traveling to your destination by walking.";
        } else {
            return "You're traveling to your destination on horseback.";
        }
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
    }

    public String describe(Character character, Destination destination) {
        return describe(character, destination, TravelMethod.WALKING);
    }
}
