package es.mcg.errors;

public class EventsError extends Exception {
    public EventsError()
    {
        super();
    }

    public EventsError(String message)
    {
        super(message);
    }

    public EventsError(String message, Throwable exception)
    {
        super(message, exception);
    }
}
