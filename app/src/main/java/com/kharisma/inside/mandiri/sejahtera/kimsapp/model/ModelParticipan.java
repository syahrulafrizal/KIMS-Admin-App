package com.kharisma.inside.mandiri.sejahtera.kimsapp.model;

public class ModelParticipan {
    String participanName, participanNote, participanDeadline;

    public ModelParticipan(String participanName, String participanNote, String participanDeadline) {
        this.participanName = participanName;
        this.participanNote = participanNote;
        this.participanDeadline = participanDeadline;
    }

    public String getParticipanName() {
        return participanName;
    }

    public void setParticipanName(String participanName) {
        this.participanName = participanName;
    }

    public String getParticipanNote() {
        return participanNote;
    }

    public void setParticipanNote(String participanNote) {
        this.participanNote = participanNote;
    }

    public String getParticipanDeadline() {
        return participanDeadline;
    }

    public void setParticipanDeadline(String participanDeadline) {
        this.participanDeadline = participanDeadline;
    }
}
