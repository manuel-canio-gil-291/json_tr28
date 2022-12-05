package es.mcg.input.data;

import java.util.Date;

public class EventsData {
    private String data;
    private Integer index, period;
    private Date timestap;
    private Integer minute, second;
    private Type type;
    private Integer possession;
    private PossessionTeam possesion_team;
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
}
