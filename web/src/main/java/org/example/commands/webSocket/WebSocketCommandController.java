package org.example.commands.webSocket;

import org.example.BaseController;
import org.example.dtos.ColumnDto;
import org.example.dtos.CommentDto;
import org.example.dtos.ProjectDto;
import org.example.dtos.TaskDto;
import org.example.entities.task.Task;
import org.example.dispacher.Mediator;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin
public class WebSocketCommandController extends BaseController {

    public WebSocketCommandController(Mediator mediator) {
        super(mediator);
    }

    @MessageMapping("/deleteTask/{project_id}")
    public void deleteTask(@DestinationVariable UUID projectId, TaskDto taskDto) {

    }

    @MessageMapping("/saveProject/{project_id}")
    @SendTo("/project/{project_id}")
    public ProjectDto saveProject(@DestinationVariable UUID projectId, ProjectDto projectDto) {
        return null;
    }

    @MessageMapping("/deleteProject/{project_id}")
    public void deleteProject(@DestinationVariable UUID projectId) {

    }

    @MessageMapping("/saveComment/{task_id}")
    @SendTo("/comment/{task_id}")
    public CommentDto saveComment(@DestinationVariable UUID taskId, CommentDto commentDto) {
        return null;
    }

    @MessageMapping("/saveColumn/{project_id}")
    @SendTo("/column/{project_id}")
    public ColumnDto saveColumn(@DestinationVariable UUID project_id, ColumnDto columnDto) {
        return null;
    }

    @MessageMapping("/saveColumnNoChangeInOrder/{project_id}")
    public void saveColumnNoChangeInOrder(@DestinationVariable UUID projectId, ColumnDto columnDto) {

    }

    @MessageMapping("/deleteColumn/{project_id}")
    public void deleteColumn(@DestinationVariable UUID projectId, ColumnDto columnDto) {

    }
}
