package org.example.dispacher;

import org.example.dispacher.response.Result;

public interface RequestHandler<TRequest extends Request, TResponse extends Result> {
    TResponse handle(TRequest tRequest);
}
