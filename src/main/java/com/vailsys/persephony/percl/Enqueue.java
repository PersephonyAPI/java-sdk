package com.vailsys.persephony.percl;

public class Enqueue extends PerCLCommand {
    private String queueId;
    private String actionUrl;
    private String waitUrl;
    private String notificationUrl;

    public Enqueue(String queueId, String actionUrl){
        this.setQueueId(queueId);
        this.setActionUrl(actionUrl);
    }

    public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getWaitUrl() {
        return waitUrl;
    }

    public void setWaitUrl(String waitUrl) {
        this.waitUrl = waitUrl;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }
}
