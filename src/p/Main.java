package p;//package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Terminal terminal = new Terminal();
        String currentDirectory="put here your default directory path";
        String input ="";
        String[] and = {"&"};
        while(true) {
            System.out.print(currentDirectory+ " ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            if(input.equals("exit"))
                break;
            if(input == "\n")
            {
                continue;
            }
            //Scanner in = new Scanner(System.in);
            //String line = in.next();

            String[] command = input.split(" \\| ");
            // System.out.println(command[0]);
            // System.out.println(command[1]);

            for (int i = 0 ; i<command.length;i++) {
                if (command[i] == null)
                {
                    break;
                }

                Parser parser = new Parser(command[i]);
                    for (int z = 0; z < parser.args.length; z++) {
                        if (parser.args[z] == null) {
                            break;
                        }
                        if (!parser.args[z].contains(":") && !parser.args[z].equals(">")  && !parser.args[z].equals(">>") ) {
                            //  System.out.println(parser.args[z]);
                            parser.args[z] = currentDirectory + "\\" + parser.args[z];
                        }

                    }




                switch (parser.cmd) {
                    case "cd": {
                        if(parser.args.length != 2 && parser.args.length != 1 )
                        {
                            System.out.println("cd takes 0 or 1 argument");
                            break;
                        }
                        if(parser.args.length == 1)
                            terminal.cd("");
                        else
                            terminal.cd(parser.args[0]);
                        break;
                    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "ls":
                        terminal.ls(parser.args);
                        break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "cp":
                        if(parser.args.length != 3 )
                        {
                            System.out.println("cp takes 2 arguments");
                            break;
                        }
                        terminal.cp(parser.args[0], parser.args[1]);
                        break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "cat":
                        terminal.cat(parser.args);
                        break;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "more": //the args append null so the args length +1

                        if(parser.args.length != 2 )
                        {
                            System.out.println("more takes 1 argument");
                        }
                        else {
                            terminal.more(parser.args[0]);
                            break;
                        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "mkdir":
                        if(parser.args.length != 2 )
                        {
                            System.out.println("mkdir takes 1 argument");
                            break;
                        }
                        terminal.mkdir(parser.args[0]);
                        break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "rmdir":
                        // terminal.rmdir("","directory name");
                        // break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "mv":
                        if(parser.args.length != 3 )
                        {
                            System.out.println("mv takes 2 arguments");
                            break;
                        }
                        terminal.mv(parser.args[0],parser.args[1]);
                        break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "rm":
                        if(parser.args.length != 2 )
                        {
                            System.out.println("rm takes 1 argument");
                            break;
                        }
                        terminal.rm(parser.args[0]);
                        break;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "args":
                        if(parser.args.length != 1 )
                        {
                            System.out.println("clear takes 0 argument");
                            break;
                        }
                        terminal.args();
                        break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "date":
                        if(parser.args.length != 1 )
                        {
                            System.out.println("clear takes 0 argument");
                            break;
                        }
                        terminal.date();
                        break;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "help":
                        if(parser.args.length != 1 )
                        {
                            System.out.println("clear takes 0 argument");
                            break;
                        }
                        terminal.help();
                        break;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "pwd":
                        if(parser.args.length != 1 )
                        {
                            System.out.println("pwd takes 0 argument");
                            break;
                        }
                        terminal.pwd();
                        break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    case "clear":
                        if(parser.args.length != 1 )
                        {
                            System.out.println("clear takes 0 argument");
                            break;
                        }
                        terminal.clear();
                        break;
                    //////////////////////////////////////////////////////////////////////////////////////////


                }

            }

        }




        //Parser parser = new Parser();
        // terminal.cp("C:\\Users\\Admin\\Desktop\\file.txt", "C:\\Users\\Admin\\Desktop\\file1.txt");
        // terminal.mkdir("","directory name");
        // terminal.rm("C:\\Users\\Admin\\Desktop\\file.txt");
        // terminal.ls("C:\\Users\\Admin\\Desktop");
        // terminal.args();
        // terminal.date();
        // terminal.more("C:\\Users\\Admin\\Desktop","file.txt");
        // terminal.pwd();
        // terminal.help():
        // terminal.cat("C:\\Users\\Admin\\Desktop","file.txt");
        // terminal.rmdir("","directory name");
        // terminal.ls("C:\\Users\\Admin\\Desktop\\n");
        // terminal.clear();
        // terminal.cd("C:\\Users\\Admin\\Desktop\\file.txt");
        // terminal.mv("C:\\Users\\Admin\\Desktop\\ehh.txt","C:\\FCI\\Third Year\\First Term\\Operating System-1\\Assignments\\ehh.txt");
    }

}

///////////////////////////////we must change the directory when we use another laptop