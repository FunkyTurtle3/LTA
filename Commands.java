public enum Commands {
    ZU((player,input) -> player.toLocation(input)),
    NIMM((player, input) -> player.takeItem(input)),
    GIB((player, input) -> player.dropItem(input)),
    INVALIDINPUT((player, input) -> player.invalidInput(input));

    private final Playable playable;

    Commands(Playable playable){
        this.playable = playable;
    }

    public String execute(Player player, String input){
        return playable.execute(player, input);
    }
}
