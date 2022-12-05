package es.mcg.input.data;

public class Lineup {
    private Player player;
    private Position position;
    private Integer jersey_number;

    public Lineup()
    {
        this.jersey_number = 0;
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

    public Integer getJersey_number() {
        return jersey_number;
    }

    public void setJersey_number(Integer jersey_number) {
        this.jersey_number = jersey_number;
    }
}
