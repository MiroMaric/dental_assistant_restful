package com.miromaric.dentalassistant.model.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;

/**
 *
 * @author MikoPC
 */
public class ToothDto implements Serializable{
    
    @NotNull
    private Long patientID;
    @NotNull
    private Long toothLabelID;

    public ToothDto() {
    }

    public ToothDto(Long patientID, Long toothLabelID) {
        this.patientID = patientID;
        this.toothLabelID = toothLabelID;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public Long getToothLabelID() {
        return toothLabelID;
    }

    public void setToothLabelID(Long toothLabelID) {
        this.toothLabelID = toothLabelID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.patientID);
        hash = 89 * hash + Objects.hashCode(this.toothLabelID);
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
        final ToothDto other = (ToothDto) obj;
        if (!Objects.equals(this.patientID, other.patientID)) {
            return false;
        }
        return Objects.equals(this.toothLabelID, other.toothLabelID);
    }

    @Override
    public String toString() {
        return "ToothDto{" + "patientID=" + patientID + ", toothLabelID=" + toothLabelID + '}';
    }
    
}
