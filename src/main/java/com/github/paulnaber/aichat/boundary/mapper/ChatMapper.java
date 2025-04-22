package com.github.paulnaber.aichat.boundary.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.github.paulnaber.aichat.boundary.dto.ChatDto;
import com.github.paulnaber.aichat.domain.Chat;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class ChatMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "lastActiveDate", target = "lastActiveDate")
    public abstract ChatDto mapEntityToDto(Chat entity);



    public abstract List<ChatDto> mapListEntityToDto(List<Chat> entities);
}
