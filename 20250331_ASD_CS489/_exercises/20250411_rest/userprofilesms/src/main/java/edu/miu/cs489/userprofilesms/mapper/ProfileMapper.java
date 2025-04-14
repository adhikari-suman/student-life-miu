package edu.miu.cs489.userprofilesms.mapper;

import edu.miu.cs489.userprofilesms.dto.request.ProfileRequestDTO;
import edu.miu.cs489.userprofilesms.dto.response.ProfileResponseDTO;
import edu.miu.cs489.userprofilesms.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    Profile profileRequestDTOToProfile(ProfileRequestDTO profileRequestDTO);

    ProfileResponseDTO profileToProfileResponseDTO(Profile profile);
}
