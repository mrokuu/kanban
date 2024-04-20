package org.example.mediator;

import org.example.mediator.response.Result;

public interface RequestHandler<TRequest extends Request, TResponse extends Result> {
    TResponse handle(TRequest tRequest);
}
