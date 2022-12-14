package es.mcg.input.data;

public class DataInput {
    private Integer minute, second;
    private PossessionTeam possession_team;
    private Team team;
    private Player player;
    private Shot shot;
    public DataInput() {
        
    }
    public Integer getMinute() {
        return minute;
    }
    public void setMinute(Integer minute) {
        this.minute = minute;
    }
    public Integer getSecond() {
        return second;
    }
    public void setSecond(Integer second) {
        this.second = second;
    }
    public PossessionTeam getPossession_team() {
        return possession_team;
    }
    public void setPossession_team(PossessionTeam possession_team) {
        this.possession_team = possession_team;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Shot getShot() {
        return shot;
    }
    public void setShot(Shot shot) {
        this.shot = shot;
    }

    
}
