package Interpreter.Commands.util;

import Interpreter.Commands.Exceptions.InvalidArgumentsException;
import Interpreter.Commands.Fundation.Command;

public class Return<T> extends Command<T> {

    @Override
    public T execute() {
        return null;
    }

    @Override
    public void setArgs(String[] args) throws InvalidArgumentsException {
        if(args.length != 2) // args[0] == return && args[1] == return value
        {
            throw new InvalidArgumentsException();
        }
        super.setArgs(args);

    }
}

