package es.mcg.input.data;

public class FreezeFrame {
    private Double[] location;
    private Player player;
    private Position position;
    private Boolean teammate;

    public FreezeFrame()
    {
        this.location = null;
        this.teammate = false;
    }

    public Double[] getLocation() {
        return location;
    }

    public void setLocation(Double[] location) {
        this.location = location;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Boolean getTeammate() {
        return teammate;
    }

    public void setTeammate(Boolean teammate) {
        this.teammate = teammate;
    }
}
