package com.miromaric.dentalassistant.model.dto;

import java.util.Objects;
import javax.validation.constraints.NotNull;

public class SideInterventionDto {

    private Long patientID;
    private Long toothID;
    private Long toothSideID;
    @NotNull
    private Long interventionID;
    @NotNull
    private Long toothSideStateID;
    private String note;

    public SideInterventionDto() {
    }

    public SideInterventionDto(Long interventionID, Long patientID, Long toothID, Long toothSideID, Long toothSideStateID, String note) {
        this.interventionID = interventionID;
        this.patientID = patientID;
        this.toothID = toothID;
        this.toothSideID = toothSideID;
        this.toothSideStateID = toothSideStateID;
        this.note = note;
    }

    public Long getInterventionID() {
        return interventionID;
    }

    public void setInterventionID(Long interventionID) {
        this.interventionID = interventionID;
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

    public Long getToothSideID() {
        return toothSideID;
    }

    public void setToothSideID(Long toothSideID) {
        this.toothSideID = toothSideID;
    }

    public Long getToothSideStateID() {
        return toothSideStateID;
    }

    public void setToothSideStateID(Long toothSideStateID) {
        this.toothSideStateID = toothSideStateID;
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
        hash = 97 * hash + Objects.hashCode(this.interventionID);
        hash = 97 * hash + Objects.hashCode(this.patientID);
        hash = 97 * hash + Objects.hashCode(this.toothID);
        hash = 97 * hash + Objects.hashCode(this.toothSideID);
        hash = 97 * hash + Objects.hashCode(this.toothSideStateID);
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
        final SideInterventionDto other = (SideInterventionDto) obj;
        if (!Objects.equals(this.interventionID, other.interventionID)) {
            return false;
        }
        if (!Objects.equals(this.patientID, other.patientID)) {
            return false;
        }
        if (!Objects.equals(this.toothID, other.toothID)) {
            return false;
        }
        if (!Objects.equals(this.toothSideID, other.toothSideID)) {
            return false;
        }
        return Objects.equals(this.toothSideStateID, other.toothSideStateID);
    }

    @Override
    public String toString() {
        return "SideInterventionDto{" + "interventionID=" + interventionID + ", patientID=" + patientID + ", toothID=" + toothID + ", toothSideID=" + toothSideID + ", toothSideStateID=" + toothSideStateID + ", note=" + note + '}';
    }

}
