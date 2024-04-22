package org.example.webSocket;

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
public class WebSocketController extends BaseController {

    public WebSocketController(Mediator mediator) {
        super(mediator);
    }

    @MessageMapping("/task/{project_id}")
    @SendTo("/updatedTask/{project_id}")
    public Task updateTask(@DestinationVariable String project_id, Task task) {
        return null;
    }
}
