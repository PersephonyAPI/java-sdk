package com.vailsys.persephony.webhooks.percl;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.webhooks.PersyRequest;
import com.vailsys.persephony.webhooks.VoiceRequest;

import static com.vailsys.persephony.json.PersyGson.gson;

public class OutDialIfMachineCallback extends VoiceRequest {
    private MachineType machineType;
    private String parentCallId;

    private OutDialIfMachineCallback(){}

    public static OutDialIfMachineCallback createFromJson(String jsonString) throws PersyException {
        try {
            return gson.fromJson(jsonString, OutDialIfMachineCallback.class);
        } catch (JsonIOException | JsonSyntaxException je){
            throw new PersyJSONException(je);
        }
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public String getParentCallId() {
        return parentCallId;
    }
}
