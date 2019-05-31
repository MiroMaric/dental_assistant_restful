package com.miromaric.dentalassistant.service.mapper.impl;

import com.miromaric.dentalassistant.service.mapper.*;
import com.miromaric.dentalassistant.model.Intervention;
import com.miromaric.dentalassistant.model.User;
import com.miromaric.dentalassistant.model.dto.InterventionDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-31T04:04:27+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
public class InterventionMapperImpl implements InterventionMapper {

    @Override
    public InterventionDto toDtoModel(Intervention intervention) {
        if ( intervention == null ) {
            return null;
        }

        InterventionDto interventionDto = new InterventionDto();

        interventionDto.setUsername( interventionUserUsername( intervention ) );
        interventionDto.setDate( intervention.getDate() );
        interventionDto.setNote( intervention.getNote() );

        return interventionDto;
    }

    @Override
    public List<InterventionDto> toDtoModel(List<Intervention> interventions) {
        if ( interventions == null ) {
            return null;
        }

        List<InterventionDto> list = new ArrayList<InterventionDto>( interventions.size() );
        for ( Intervention intervention : interventions ) {
            list.add( toDtoModel( intervention ) );
        }

        return list;
    }

    @Override
    public Intervention toDataModel(InterventionDto interventionDto) {
        if ( interventionDto == null ) {
            return null;
        }

        Intervention intervention = new Intervention();

        intervention.setUser( interventionDtoToUser( interventionDto ) );
        intervention.setDate( interventionDto.getDate() );
        intervention.setNote( interventionDto.getNote() );

        return intervention;
    }

    private String interventionUserUsername(Intervention intervention) {
        if ( intervention == null ) {
            return null;
        }
        User user = intervention.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    protected User interventionDtoToUser(InterventionDto interventionDto) {
        if ( interventionDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( interventionDto.getUsername() );

        return user;
    }
}
