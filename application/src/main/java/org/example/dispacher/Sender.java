package org.example.dispacher;

import org.example.dispacher.response.Result;

public interface Sender {
    <TRequest extends Request, TResponse extends Result> TResponse send(TRequest request);

}
