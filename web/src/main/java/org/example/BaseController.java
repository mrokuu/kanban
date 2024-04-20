package org.example;

import lombok.RequiredArgsConstructor;
import org.example.mediator.Mediator;

@RequiredArgsConstructor
public abstract class BaseController {

    protected final Mediator mediator;

}
