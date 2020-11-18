package org.example.portfolio.usermanagement.mappers;

import org.example.portfolio.usermanagement.entities.Portfolio;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(mappingControl = DeepClone.class)
public interface PortFolioCloner {
    PortFolioCloner MAPPER = Mappers.getMapper(PortFolioCloner.class);

    Portfolio clone(Portfolio portfolio);
}
