package org.example.webSocket;

import org.example.BaseController;
import org.example.commands.task.UpdateTaskCommand;
import org.example.mediator.Mediator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WebSocketController extends BaseController {

    public WebSocketController(Mediator mediator) {
        super(mediator);
    }


}
