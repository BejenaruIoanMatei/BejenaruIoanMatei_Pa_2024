package org.example;

import java.util.Scanner;

public class Shell {

    private DocumentRepository repository;

    public Shell(DocumentRepository repository)
    {
        this.repository = repository;
    }

    private Command createCommand(String command , String[] args) throws InvalidCommandException, InvalidDataException
    {
        switch ((command))
        {
            case "view" :
                if(args.length!=2)
                {
                    throw new InvalidDataException("Nu sunt destule argumente.");
                }
                return new ViewCommand(args[1]);
            case "report" :
                return new ReportCommand(repository);
            case "export" :
                if(args.length!=2)
                {
                    throw new InvalidDataException("Nu sunt destule argumente.");
                }
                return  new ExportCommand(repository,args[1]);
            default:
                throw new InvalidCommandException(new Exception("comanda inexistenta"));
        }
    }


    public void start()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Introduceti comanda : ");
            String line = scanner.nextLine();

            String[] args = line.split(" ");
            String command = args[0];

            Command commandObj;

            if(command.equals("quit"))
            {
                break;
            }
            try{
                commandObj = createCommand(command,args);
                commandObj.execute(repository);
            }catch (InvalidCommandException | InvalidDataException e)
            {
                System.out.println("error"+e.getMessage());
            }
            catch (Exception E)
            {
                System.out.println("error");
            }finally {
                //scanner.close();
                //break;
            }
        }
        System.out.println("bye bye...");
    }
}
