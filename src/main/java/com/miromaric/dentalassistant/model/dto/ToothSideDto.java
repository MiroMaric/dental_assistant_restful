package com.miromaric.dentalassistant.model.dto;

import java.util.Objects;
import javax.validation.constraints.NotNull;

public class ToothSideDto {

    
    private Long patientID;
    private Long toothID;
    @NotNull(message = "Polje toothSideLabelID je obavezno")
    private Long toothSideLabelID;

    public ToothSideDto() {
    }

    public ToothSideDto(Long patientID, Long toothID, Long toothSideLabelID) {
        this.patientID = patientID;
        this.toothID = toothID;
        this.toothSideLabelID = toothSideLabelID;
    }

    public Long getToothID() {
        return toothID;
    }

    public void setToothID(Long toothID) {
        this.toothID = toothID;
    }

    public Long getToothSideLabelID() {
        return toothSideLabelID;
    }

    public void setToothSideLabelID(Long toothSideLabelID) {
        this.toothSideLabelID = toothSideLabelID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.patientID);
        hash = 31 * hash + Objects.hashCode(this.toothID);
        hash = 31 * hash + Objects.hashCode(this.toothSideLabelID);
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
        final ToothSideDto other = (ToothSideDto) obj;
        if (!Objects.equals(this.patientID, other.patientID)) {
            return false;
        }
        if (!Objects.equals(this.toothID, other.toothID)) {
            return false;
        }
        return Objects.equals(this.toothSideLabelID, other.toothSideLabelID);
    }

    @Override
    public String toString() {
        return "ToothSideDto{" + "patientID=" + patientID + ", toothID=" + toothID + ", toothSideLabelID=" + toothSideLabelID + '}';
    }
    
    
    
}
