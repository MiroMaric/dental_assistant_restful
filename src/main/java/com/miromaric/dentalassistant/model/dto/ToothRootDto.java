package com.miromaric.dentalassistant.model.dto;

import java.util.Objects;
import javax.validation.constraints.NotNull;

public class ToothRootDto {
    
    private Long patientID;
    private Long toothID;
    @NotNull(message = "Polje toothRootLabelID je obavezno")
    private Long toothRootLabelID;

    public ToothRootDto() {
    }

    public ToothRootDto(Long patientID, Long toothID, Long toothRootLabelID) {
        this.patientID = patientID;
        this.toothID = toothID;
        this.toothRootLabelID = toothRootLabelID;
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

    public Long getToothRootLabelID() {
        return toothRootLabelID;
    }

    public void setToothRootLabelID(Long toothRootLabelID) {
        this.toothRootLabelID = toothRootLabelID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.patientID);
        hash = 47 * hash + Objects.hashCode(this.toothID);
        hash = 47 * hash + Objects.hashCode(this.toothRootLabelID);
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
        final ToothRootDto other = (ToothRootDto) obj;
        if (!Objects.equals(this.patientID, other.patientID)) {
            return false;
        }
        if (!Objects.equals(this.toothID, other.toothID)) {
            return false;
        }
        return Objects.equals(this.toothRootLabelID, other.toothRootLabelID);
    }

    @Override
    public String toString() {
        return "ToothRootDto{" + "patientID=" + patientID + ", toothID=" + toothID + ", toothRootLabelID=" + toothRootLabelID + '}';
    }
    
}
