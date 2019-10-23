package p;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Terminal{

    private String currentDirectory="put here your default directory path";
    private String foundCharacter;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cp(String sourcePath, String destinationPath ) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(sourcePath);
            outputStream = new FileOutputStream(destinationPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
        finally {
            inputStream.close();
            outputStream.close();
        }



    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void redirectOperatorTrunc(String inputToFile, String fileName) throws IOException
    {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(inputToFile);
        fileWriter.close();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void redirectOperatorAppend(String inputToFile, String fileName) throws IOException
    {
        FileWriter fileWriter = new FileWriter(fileName, true);
        fileWriter.write(inputToFile);
        fileWriter.close();
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void mv(String sourcePath, String destinationPath)
    {
        File oldfile = new File(sourcePath);

        // renaming the file and moving it to a new location
        if(oldfile.renameTo
                (new File(destinationPath)))
        {
            // if file copied successfully then delete the original file
            oldfile.delete();
            System.out.println("File moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }


    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void mkdir(String givenPath)
    {

        File directory = new File(givenPath);
        boolean successful = directory.mkdir();
        if(successful)
        {
            System.out.println("Directory created successfully.");
        }
        else
            System.out.println("Failed creating directory" );
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //delete directory ---> msh httms7 gher ella lw elly gwaha etmsa7
    public void rm(String givenPath)
    {
        File file = new File(givenPath);
        if(file.delete())
            System.out.println("File deleted successfully.");
        else
            System.out.println("Failed removing file");

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void rmdir(String givenPath)
    {
        File directory = new File(givenPath);
        if(directory.delete())
        {
            System.out.println("successfully deleted directory.");
        }
        else
            System.out.println("Failed deleting directory");

    }


    public void pwd()
    {
        System.out.println("Current directory: " + currentDirectory);
    }
    // public void cat(String[] paths);

    private Integer foundOperatorIndex(String[] args) throws NullPointerException
    {
        foundCharacter = "&";
        if(args.length > 2 )
        {
            for(int i =0; i < args.length - 1; i++)
            {
                if(args[i].equals(">") )
                {
                    foundCharacter = ">";
                    return i;
                }
                else if(args[i].equals(">>")) {
                    foundCharacter = ">>";
                    return  i;
                }
            }
        }
        return -1;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void ls(String[] args) throws IOException {
        File folder = new File(currentDirectory);
        File[] listOfFiles =  folder.listFiles();               //contains all files in the working directory
        Integer index = foundOperatorIndex(args);
        switch (foundCharacter) {
            case "&":
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        System.out.println(listOfFiles[i].getName());
                    } else if (listOfFiles[i].isDirectory()) {
                        System.out.println(listOfFiles[i].getName());
                    }
                }

                break;
            case ">": {

                FileWriter fileWriter = new FileWriter(args[index+1]);
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        fileWriter.write(listOfFiles[i].getName());
                        fileWriter.write('\n');
                    }
                    else if (listOfFiles[i].isDirectory()) {
                        fileWriter.write(listOfFiles[i].getName());
                        fileWriter.write('\n');

                    }
                }
                fileWriter.close();
                break;
            }
                case ">>":

                    FileWriter fileWriter = new FileWriter(args[index+1], true);
                    for (int i = 0; i < listOfFiles.length; i++) {
                        if (listOfFiles[i].isFile()) {
                            fileWriter.write(listOfFiles[i].getName());
                            fileWriter.write('\n');

                        }
                        else if (listOfFiles[i].isDirectory()) {
                            fileWriter.write(listOfFiles[i].getName());
                            fileWriter.write('\n');

                        }
                    }
                    fileWriter.close();
                    break;
            }
            foundCharacter = "&";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void date()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void clear()
    {
        for (int i=0;i<30;i++)
        {
            System.out.println("\n");
        }
        // System.out.print("\033[H\033[2J");
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void args()
    {
        System.out.println("cp oldFile newFile");
        System.out.println("rm filepath");
        System.out.println("rmdir directorypath");
        System.out.println("mkdir directorypath");
        System.out.println("ls: List all files in the directory");
        System.out.println("cd: change directory");
        System.out.println("cat: path1 path2 etc. ");
        System.out.println("more: Scroll down 10 lines  ");
        System.out.println("mv:source path destination path");
        System.out.println("mv: path");
        System.out.println("args:list all command arguments");
        System.out.println("date:Current date/time ");
        System.out.println("help: none");
        System.out.println("exit: none");
        System.out.println("pwd: none");
        System.out.println("clear:clear terminal or print \n");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void help()
    {
        System.out.println("cp: copy file");
        System.out.println("rm: remove file");
        System.out.println("rmdir: remove directory");
        System.out.println("mkdir: create directory");
        System.out.println("ls: List all files in the directory");
        System.out.println("cd: change directory");
        System.out.println("cat: prints out files content");
        System.out.println("more: Scroll down ");
        System.out.println("|: separate commands");
        System.out.println(">: redirect operator (truncate mode)");
        System.out.println(">>:redirect operator (append mode) ");
        System.out.println("mv: move file ");
        System.out.println("args:list all command arguments");
        System.out.println("date:Current date/time ");
        System.out.println("help: lists all commands");
        System.out.println("exit:stop all");
        System.out.println("pwd:print working directory");
        System.out.println("clear:clear terminal");




    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cd(String directoryPath)
    {
        if( directoryPath != "")
            currentDirectory = directoryPath;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cat(String[] args) throws IOException
    {
        File folder = new File(currentDirectory);
        File[] listOfFiles =  folder.listFiles();               //contains all files in the working directory
        Integer index = foundOperatorIndex(args);

        switch (foundCharacter)
        {
            case "&":
            {
                for(int i = 0; i< args.length - 1; i++)
                {
                    File directory = new File(args[i]);
                    BufferedReader br = new BufferedReader(new FileReader(directory));
                    String st;

                    while ((st = br.readLine()) != null)
                    {
                        System.out.println(st);

                    }
                }
                break;
            }
            case ">>":
            {
                for(int i = index - 1 ; i< args.length - 1 && i != index; i++)
                {
                    FileWriter fileWriter = new FileWriter(args[index + 1], true);

                    File directory = new File(args[i]);
                    BufferedReader br = new BufferedReader(new FileReader(directory));
                    String st;

                    while ((st = br.readLine()) != null)
                    {
                        fileWriter.write(st);
                    }
                    fileWriter.close();

                }
                break;
            }
            case ">":
            {
                for(int i = index - 1 ; i< args.length - 1 && i != index; i++)
                {
                    FileWriter fileWriter = new FileWriter(args[index + 1]);

                    File directory = new File(args[i]);
                    BufferedReader br = new BufferedReader(new FileReader(directory));
                    String st;

                    while ((st = br.readLine()) != null)
                    {
                        fileWriter.write(st);
                    }
                    fileWriter.close();

                }
                break;
            }

        }
        foundCharacter = "&";


    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void more(String givenPath) throws IOException
    {


        File directory = new File(givenPath );
        BufferedReader br = new BufferedReader(new FileReader(directory));
        String st;
        Scanner in = new Scanner(System.in);

        String continu;
        int stop = 1;
        while ((st = br.readLine()) != null)
        {
            System.out.println(st);
            if (stop % 10 == 0)
            {
                continu = in.nextLine();
            }
            stop++;
        }



        /*
        File file = new File("C:\\Users\\RS3\\Desktop\\file.txt");
        Scanner sc = new Scanner(file);

        // we just need to use \\Z as delimiter
        sc.useDelimiter("\\Z");

        System.out.println(sc.next());
        */
    }

// Add any other required command in the same structure…..
}





