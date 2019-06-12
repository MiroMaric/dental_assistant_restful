package com.miromaric.dentalassistant.model.dto;

import java.util.Objects;
import javax.validation.constraints.NotNull;

public class RootInterventionDto {
    private Long patientID;
    private Long toothID;
    private Long toothRootID;
    @NotNull
    private Long interventionID;
    @NotNull
    private Long toothRootStateID;
    private String note;

    public RootInterventionDto() {
    }

    public RootInterventionDto(Long patientID, Long toothID, Long toothRootID, Long interventionID, Long toothRootStateID, String note) {
        this.patientID = patientID;
        this.toothID = toothID;
        this.toothRootID = toothRootID;
        this.interventionID = interventionID;
        this.toothRootStateID = toothRootStateID;
        this.note = note;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public Long getToothID() {
        return toothID;
    }

    public void setToothID(Long toothID) {
        this.toothID = toothID;
    }

    public Long getToothRootID() {
        return toothRootID;
    }

    public void setToothRootID(Long toothRootID) {
        this.toothRootID = toothRootID;
    }

    public Long getInterventionID() {
        return interventionID;
    }

    public void setInterventionID(Long interventionID) {
        this.interventionID = interventionID;
    }

    public Long getToothRootStateID() {
        return toothRootStateID;
    }

    public void setToothRootStateID(Long toothRootStateID) {
        this.toothRootStateID = toothRootStateID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.patientID);
        hash = 71 * hash + Objects.hashCode(this.toothID);
        hash = 71 * hash + Objects.hashCode(this.toothRootID);
        hash = 71 * hash + Objects.hashCode(this.interventionID);
        hash = 71 * hash + Objects.hashCode(this.toothRootStateID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RootInterventionDto other = (RootInterventionDto) obj;
        if (!Objects.equals(this.patientID, other.patientID)) {
            return false;
        }
        if (!Objects.equals(this.toothID, other.toothID)) {
            return false;
        }
        if (!Objects.equals(this.toothRootID, other.toothRootID)) {
            return false;
        }
        if (!Objects.equals(this.interventionID, other.interventionID)) {
            return false;
        }
        return Objects.equals(this.toothRootStateID, other.toothRootStateID);
    }

    @Override
    public String toString() {
        return "RootInterventionDto{" + "patientID=" + patientID + ", toothID=" + toothID + ", toothRootID=" + toothRootID + ", interventionID=" + interventionID + ", toothRootStateID=" + toothRootStateID + ", note=" + note + '}';
    }
    
}
