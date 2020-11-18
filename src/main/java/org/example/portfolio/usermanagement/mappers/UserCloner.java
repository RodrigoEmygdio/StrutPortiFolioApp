package org.example.portfolio.usermanagement.mappers;

import org.example.portfolio.usermanagement.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

@Mapper(mappingControl = DeepClone.class)
public interface UserCloner {
    UserCloner MAPPER = Mappers.getMapper(UserCloner.class);

    User clone(User user);
}
