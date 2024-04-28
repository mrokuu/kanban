package org.example.query.column;

import lombok.RequiredArgsConstructor;
import org.example.dtos.ColumnDto;
import org.example.entities.column.Column;
import org.example.repository.column.ColumnQueryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColumnQuery {

    private final ColumnQueryRepository columnQueryRepository;
    public List<ColumnDto> getAllColumns() {
        return columnQueryRepository.findAll(Sort.by(Sort.Order.desc("id")))
                .stream()
                .map(this::mapToColumnDto)
                .collect(Collectors.toList());
    }

    public ColumnDto getColumn(UUID id) {
        Column column = columnQueryRepository.findById(id).orElse(null);
        return mapToColumnDto(column);
    }
    public List<ColumnDto> findAllDtoByProjectId(UUID id) {
        return columnQueryRepository.findAllByProjectIdOrderByNumberOrderAsc(id);
    }




    private ColumnDto mapToColumnDto(Column column) {
        return ColumnDto.builder()
                .id(column.getId())
                .description(column.getDescription())
                .name(column.getName())
                .isWip(column.getIsWip())
                .wip(column.getWip())
                .build();
    }

}
