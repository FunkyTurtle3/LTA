public enum Command {
    ZU((player,input) -> player.toLocation(input)),
    NIMM,
    GIB,
    INVALIDINPUT;

    private Playable playable;
    private Command(Playable playable){
        this.playable = playable;
    }

    public void execute(Player player, String input){
        playable.execute(player, input);
    }
}
