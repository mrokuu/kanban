package org.example.query.column;

import lombok.RequiredArgsConstructor;
import org.example.dtos.ColumnDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/column")
@CrossOrigin
@RequiredArgsConstructor
public class ColumnQueryController {

    private final ColumnQuery columnQuery;
    @GetMapping("/all")
    public ResponseEntity<List<ColumnDto>> getAllColumns() {
        List<ColumnDto> allColumns = columnQuery.getAllColumns();

        return new ResponseEntity<>(allColumns, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColumnDto> getColumn(@PathVariable("id") UUID id) {
        ColumnDto columnDto = columnQuery.getColumn(id);

        if (columnDto != null) {
            return new ResponseEntity<>(columnDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allByProject/{id}")
    public ResponseEntity<List<ColumnDto>> findAllByProjectId(@PathVariable("id") UUID id) {
        List<ColumnDto> columns = columnQuery.findAllDtoByProjectId(id);
        return new ResponseEntity<>(columns, HttpStatus.OK);
    }
}
