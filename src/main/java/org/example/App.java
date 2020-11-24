package org.example;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

/**
 * Hello world!
 *
 */
class App {
    private static Args args = new Args();
    private static JCommander jCommander;

    public static void main(String...argv){
        jCommander = JCommander.newBuilder()
                .addObject(args)
                .build();
        try {
            jCommander.parse(argv);
            if(args.help){
                jCommander.usage();
                System.exit(1);
            }
        }catch (ParameterException e){
            System.err.println("[ERROR] : "+e.getMessage());
            System.exit(1);
        }
        run();
    }

    private static void run(){
        if(args.expression == null){
            System.out.println("[ERROR] : No Valid Command Provided");
        }else{
            System.out.println(Util.solve(args.expression));
        }
    }
}