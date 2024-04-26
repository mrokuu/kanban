package org.example.repository.column;

import org.example.dtos.ColumnDto;
import org.example.entities.column.Column;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ColumnQueryRepository extends JpaRepository<Column, UUID> {
    List<ColumnDto> findAllByProjectIdOrderByNumberOrderAsc(UUID id);
}
