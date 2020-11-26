package Interpreter.Commands.util;

import Interpreter.Commands.Exceptions.InvalidArgumentsException;
import Interpreter.Commands.Fundation.Command;

public class Number extends Command<Double> {
    double value;

    @Override
    public Double execute() {
        return Double.parseDouble(this.getArgs()[0]);
    }

    @Override
    public void setArgs(String... args) throws InvalidArgumentsException {
        if(this.getArgs().length != 1) // args[0] == value
        {
            throw new InvalidArgumentsException();
        }

        // Will throw an exception if fails.
        this.value = Double.parseDouble(this.getArgs()[0]);

        super.setArgs(args);
    }
}
