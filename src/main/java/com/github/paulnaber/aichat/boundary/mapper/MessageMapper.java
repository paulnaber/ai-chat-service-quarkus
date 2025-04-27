package com.github.paulnaber.aichat.boundary.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.github.paulnaber.aichat.boundary.dto.MessageDto;
import com.github.paulnaber.aichat.domain.Message;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class MessageMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "senderType", target = "senderType")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "chatId", target = "chatId")
    public abstract MessageDto mapEntityToDto(Message entity);



    public abstract List<MessageDto> mapListEntityToDto(List<Message> entities);
}
