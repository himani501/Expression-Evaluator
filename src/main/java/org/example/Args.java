package org.example;

import com.beust.jcommander.Parameter;
public class Args {
    @Parameter(names = {"--help","-h"}, help = true, description = "Help Section.")
    boolean help = false;
    @Parameter(names = {"--expression","-e"},description = "Expression meant of evaluation. eg java -jar FILE_NAME.jar -e [EXPRESSION]")
    String expression;
}