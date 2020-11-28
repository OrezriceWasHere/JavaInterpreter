package Interpreter.Commands.util;

import Expression.Expression;
import Interpreter.CalcExpresion;
import Interpreter.Commands.Exceptions.InvalidArgumentsException;
import Interpreter.Commands.Exceptions.ParseException;
import Interpreter.Commands.Fundation.Command;

public class Return extends Command<Integer> {

    private Integer returnStatus;

    public static final String RETURN_COMMAND_NAME = "return";

    public Return() {
        super(RETURN_COMMAND_NAME);
    }

    @Override
    public Integer execute() {
        if (returnStatus == null) {
            throw new VerifyError("Impossible return command: no value set for return");
        }
        System.exit(returnStatus);
        return returnStatus;
    }

    /**
     * Build a a return command out of string of arguments.
     * Assumption is args[0] = 'return' and args[1...length] = expression: 3 + 5 - 2 * 8 ....
     * @param args the arguments of command
     * @throws InvalidArgumentsException if arguments do not match above order.
     */
    @Override
    public void setArgs(String[] args) throws InvalidArgumentsException {
        String commandName = getName();
        if (args.length <= 1) {
            throw new InvalidArgumentsException("Command " + commandName +
                    " was not given enough parameters");
        } else if (!args[0].equals(commandName)) {
            throw new InvalidArgumentsException("Command " + commandName
                    + " did not start with command name");
        }
        StringBuffer argumentBuffer = new StringBuffer();
        for (int i = 1; i < args.length; i++) {
            argumentBuffer.append(args[i]);
        }
        String argumentString = argumentBuffer.toString();
        this.returnStatus = (int) CalcExpresion.calc(argumentString);
        super.setArgs(args);
    }

    public Integer getReturnStatus() {
        return returnStatus;
    }
}

