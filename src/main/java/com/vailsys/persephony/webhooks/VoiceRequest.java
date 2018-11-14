package com.vailsys.persephony.webhooks;

import com.vailsys.persephony.api.call.CallStatus;
import com.vailsys.persephony.api.call.Direction;

public class VoiceRequest extends PersyRequest {
    private String callId;
    private CallStatus callStatus;
    private Direction direction;
    private String conferenceId;
    private String queueId;

    public String getCallId() {
        return callId;
    }

    public CallStatus getCallStatus() {
        return callStatus;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public String getQueueId() {
        return queueId;
    }

    public Direction getDirection() {
        return direction;
    }
}
