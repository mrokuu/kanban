package org.example.mediator;

import org.example.mediator.response.Result;

public interface Sender {
    <TRequest extends Request, TResponse extends Result> TResponse send(TRequest request);

}
