package p;

public class Parser {
    String cmd ;
    String[] cmds = {"cd", "ls", "cp", "cat", "more", "mkdir", "rmdir", "mv", "rm", "args", "date", "help", "pwd", "clear"};
    String [] args ;

    public Parser (String line) {
        if (!line.isEmpty()) {
            //   System.out.println("line = [" + line + "]");

            cmd = line.split(" ")[0];
            String quotes = "\"";

            // System.out.println(cmd);

            if (!parse(line)) {
                System.out.println("Invalid input");
                return;
            } else if (parse(line)) {

                args = new String[line.split(" ").length];

                for (int i = 1; i < line.split(" ").length; i++) {
                     args[i - 1] = line.split(" ")[i];
                }

            }


        }
    }


    public boolean parse(String input)
    {
        for(int i =0; i<cmds.length; i++)
        {
            if(cmds[i].equals(cmd))
            {
                return true;
            }

        }
        return false;
    }

    public String getCmd()
    {
        return null;
    }




     public String[] getArguments(){return args;}
}
