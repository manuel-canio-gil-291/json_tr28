package es.mcg.input.data;

public class BallRecovery {
    private Boolean recovery_failure;

    public BallRecovery()
    {
        this.recovery_failure = false;
    }

    public Boolean getRecovery_failure() {
        return recovery_failure;
    }

    public void setRecovery_failure(Boolean recovery_failure) {
        this.recovery_failure = recovery_failure;
    }
    
}
