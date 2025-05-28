public enum Commands {
    ZU((gameEngine, input) -> gameEngine.toLocation(input)),
    NIMM((gameEngine, input) -> gameEngine.takeItem(input)),
    GIB((gameEngine, input) -> gameEngine.dropItem(input)),
    INVALIDINPUT((gameEngine, input) -> "Das verstehe ich nicht");

    private final Playable playable;

    Commands(Playable playable){
        this.playable = playable;
    }

    public String execute(GameEngine gameEngine, String input){
        return playable.execute(gameEngine, input);
    }
}