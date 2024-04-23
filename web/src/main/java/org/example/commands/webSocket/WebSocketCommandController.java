package org.example.commands.webSocket;

import org.example.BaseController;
import org.example.entities.task.Task;
import org.example.dispacher.Mediator;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WebSocketCommandController extends BaseController {

    public WebSocketCommandController(Mediator mediator) {
        super(mediator);
    }

    @MessageMapping("/task/{project_id}")
    @SendTo("/updatedTask/{project_id}")
    public Task updateTask(@DestinationVariable String project_id, Task task) {
        return null;
    }
}
