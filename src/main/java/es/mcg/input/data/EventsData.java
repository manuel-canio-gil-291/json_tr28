package es.mcg.input.data;

import java.util.Date;

public class EventsData {
    private String data;
    private Integer index, period;
    private Date timestap;
    private Integer minute, second;
    private Type type;
    private Integer possession;
    private PossessionTeam possession_team;
    private PlayPattern play_pattern;
    private Boolean out;
    private Boolean off_camera;
    private Team team;
    private Player player;
    private Position position;
    private Double[] location;
    private Double duration;
    private Tactics tactics;
    private Boolean under_pressure;
    private Boolean counterpress;
    private String[] related_events;
    private Dribble dribble;
    private BallReceipt ball_receipt;
    private BallRecovery ball_recovery;
    private Pass pass;
    private Carry carry;
    private Clearance clearance;
    private Interception interception;
    private Block block;
    private Duel duel;
    private FoulWon foul_won;
    private FoulCommitted foul_committed;
    private InjuryStoppage injury_stoppage;
    private Shot shot;

    public EventsData()
    {
        this.data = "";
        this.index = 0;
        this.period = 0;
        this.minute = 0;
        this.second = 0;
        this.possession = 0;
        this.out = false;
        this.off_camera = false;
        this.location = null;
        this.duration = 0.0;
        this.under_pressure = false;
        this.counterpress = false;
        this.related_events = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getTimestap() {
        return timestap;
    }

    public void setTimestap(Date timestap) {
        this.timestap = timestap;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getPossession() {
        return possession;
    }

    public void setPossession(Integer possession) {
        this.possession = possession;
    }

    public PossessionTeam getPossession_team() {
        return possession_team;
    }

    public void setPossession_team(PossessionTeam possession_team) {
        this.possession_team = possession_team;
    }

    public PlayPattern getPlay_pattern() {
        return play_pattern;
    }

    public void setPlay_pattern(PlayPattern play_pattern) {
        this.play_pattern = play_pattern;
    }

    public Boolean getOut() {
        return out;
    }

    public void setOut(Boolean out) {
        this.out = out;
    }

    public Boolean getOff_camera() {
        return off_camera;
    }

    public void setOff_camera(Boolean off_camera) {
        this.off_camera = off_camera;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Double[] getLocation() {
        return location;
    }

    public void setLocation(Double[] location) {
        this.location = location;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Tactics getTactics() {
        return tactics;
    }

    public void setTactics(Tactics tactics) {
        this.tactics = tactics;
    }

    public Boolean getUnder_pressure() {
        return under_pressure;
    }

    public void setUnder_pressure(Boolean under_pressure) {
        this.under_pressure = under_pressure;
    }

    public Boolean getCounterpress() {
        return counterpress;
    }

    public void setCounterpress(Boolean counterpress) {
        this.counterpress = counterpress;
    }

    public String[] getRelated_events() {
        return related_events;
    }

    public void setRelated_events(String[] related_events) {
        this.related_events = related_events;
    }

    public Dribble getDribble() {
        return dribble;
    }

    public void setDribble(Dribble dribble) {
        this.dribble = dribble;
    }

    public BallReceipt getBall_receipt() {
        return ball_receipt;
    }

    public void setBall_receipt(BallReceipt ball_receipt) {
        this.ball_receipt = ball_receipt;
    }

    public BallRecovery getBall_recovery() {
        return ball_recovery;
    }

    public void setBall_recovery(BallRecovery ball_recovery) {
        this.ball_recovery = ball_recovery;
    }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }

    public Carry getCarry() {
        return carry;
    }

    public void setCarry(Carry carry) {
        this.carry = carry;
    }

    public Clearance getClearance() {
        return clearance;
    }

    public void setClearance(Clearance clearance) {
        this.clearance = clearance;
    }

    public Interception getInterception() {
        return interception;
    }

    public void setInterception(Interception interception) {
        this.interception = interception;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public Duel getDuel() {
        return duel;
    }

    public void setDuel(Duel duel) {
        this.duel = duel;
    }

    public FoulWon getFoul_won() {
        return foul_won;
    }

    public void setFoul_won(FoulWon foul_won) {
        this.foul_won = foul_won;
    }

    public FoulCommitted getFoul_committed() {
        return foul_committed;
    }

    public void setFoul_committed(FoulCommitted foul_committed) {
        this.foul_committed = foul_committed;
    }

    public InjuryStoppage getInjury_stoppage() {
        return injury_stoppage;
    }

    public void setInjury_stoppage(InjuryStoppage injury_stoppage) {
        this.injury_stoppage = injury_stoppage;
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }
}
