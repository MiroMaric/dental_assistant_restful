package com.miromaric.dentalassistant.model.dto;

import java.util.Objects;
import javax.validation.constraints.NotNull;

public class ToothInterventionDto {
    
    private Long patientID;
    private Long toothID;
    private Long toothInterventionID;
    @NotNull
    private Long interventionID;
    @NotNull
    private Long toothStateID;
    private String note;

    public ToothInterventionDto() {
    }

    public ToothInterventionDto(Long patientID, Long toothID, Long toothInterventionID, Long interventionID, Long toothStateID, String note) {
        this.patientID = patientID;
        this.toothID = toothID;
        this.toothInterventionID = toothInterventionID;
        this.interventionID = interventionID;
        this.toothStateID = toothStateID;
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

    public Long getToothInterventionID() {
        return toothInterventionID;
    }

    public void setToothInterventionID(Long toothInterventionID) {
        this.toothInterventionID = toothInterventionID;
    }

    public Long getInterventionID() {
        return interventionID;
    }

    public void setInterventionID(Long interventionID) {
        this.interventionID = interventionID;
    }

    public Long getToothStateID() {
        return toothStateID;
    }

    public void setToothStateID(Long toothStateID) {
        this.toothStateID = toothStateID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.patientID);
        hash = 73 * hash + Objects.hashCode(this.toothID);
        hash = 73 * hash + Objects.hashCode(this.toothInterventionID);
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
        final ToothInterventionDto other = (ToothInterventionDto) obj;
        if (!Objects.equals(this.patientID, other.patientID)) {
            return false;
        }
        if (!Objects.equals(this.toothID, other.toothID)) {
            return false;
        }
        return Objects.equals(this.toothInterventionID, other.toothInterventionID);
    }

    @Override
    public String toString() {
        return "ToothInterventionDto{" + "patientID=" + patientID + ", toothID=" + 
                toothID + ", toothInterventionID=" + toothInterventionID + ", interventionID=" + 
                interventionID + ", toothStateID=" + toothStateID + ", note=" + note + '}';
    }
    
}
