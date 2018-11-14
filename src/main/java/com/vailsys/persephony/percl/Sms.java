package com.vailsys.persephony.percl;

/**
 * * Sms represents the {@code Sms} PerCL command. See the Sms
 * PerCL documentation for details.
 */
public class Sms extends PerCLCommand {
    private String to;
    private String from;
    private String text;
    private String notificationUrl;

    public Sms(String to, String from, String text) {
        this.setTo(to);
        this.setFrom(from);
        this.setText(text);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }
}
