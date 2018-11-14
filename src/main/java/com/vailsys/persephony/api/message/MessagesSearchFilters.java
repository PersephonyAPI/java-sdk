package com.vailsys.persephony.api.message;

/**
 * Represents the possible fields one can set as filters when retrieving a list of messages.
 */
public class MessagesSearchFilters {
    /**
     * Only show messages to this phone number.
     */
    private String to;

    /**
     * Only show messages from this phone number.
     */
    private String from;

    /**
     * Only show messages sent at or after this time (GMT), given as YYYY-MM-DD hh:mm:ss.
     */
    private String beginTime;

    /**
     * Only show messages sent at or before this time (GMT), given as YYYY-MM-DD hh:mm:ss.
     */
    private String endTime;

    /**
     * Only show messages with this direction property. Allows filtering for messages sent by Persephony or received by Persephony.
     */
    private Direction direction;

    public String getTo() {
        return to;
    }

    /**
     * Only show messages to this phone number.
     * @param to The To phone number to filter by.
     */
    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    /**
     * Only show messages from this phone number.
     * @param from The from phone number to filter by.
     */
    public void setFrom(String from) {
        this.from = from;
    }

    public String getBeginTime() {
        return beginTime;
    }

    /**
     * Only show messages sent at or after this tim (GMT), given as YYYY-MM-DD hh:mm:ss.
     * @param beginTime The beginning of the range to filter by.
     */
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    /**
     * Only show messages sent at or before this time (GMT), given as YYYY-MM-DD hh:mm:ss.
     * @param endTime The end range to filter by.
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Only show messages from this direction.
     * @param direction The direction to filter by.
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
