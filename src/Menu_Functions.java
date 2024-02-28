import java.io.*;
import java.util.Scanner;


public class Menu_Functions {

    public Menu_Functions(){}

    Client[] clientList = new Client[1];
    File newFile = new File("C:\\Users\\gavin\\OneDrive\\Documents\\client.txt");




    public void menu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (newFile.length() != 0)
        {
            clientList[0] = loadObject();
        }



        System.out.println("Welcome to GCW GYM!");
        System.out.println("Enter '1' to add a new client.");
        System.out.println("Enter '2' to view current workout.");
        System.out.println("Enter '3' to schedule a session.");
        System.out.println("Enter '4' cancel a session.");
        System.out.println("Enter '5' to save your information.");
        System.out.println("Enter '6' to quit!");


        int ch = Integer.parseInt(br.readLine());

        while(ch != 6)
        {
            switch(ch)
            {
                case 1 :
                    System.out.println("Enter the name of the new client");
                    String name = br.readLine();
                    System.out.println("Enter the phone number the the new client");
                    int phone = Integer.parseInt(br.readLine());
                    System.out.println("Please enter a Username");
                    String user = br.readLine();
                    System.out.println("Please enter a Password");
                    String pass = br.readLine();
                    System.out.println("Okay great! For all new clients, we must complete an assessment. I'm going to ask you some general questions about the client");

                    Client client = new Client(name, phone);
                    client.setUsername(user);
                    client.setPassword(pass);
                    clientList[0] = client;


                    client.createWorkout(client);
                    System.out.println("Thanks so much for completing your assessment! I hope you enjoy your first workout!");
                    break;

                case 2 :
                    if (clientList[0] == null)
                    {
                        System.out.println("Try option 1 first!");
                    }
                    else {
                        System.out.println("Enter Username:");
                        String username = br.readLine();
                        System.out.println("Enter Password:");
                        String password = br.readLine();

                        if(username.equals(clientList[0].getUsername()) && password.equals(clientList[0].getPassword()))
                        {
                            clientList[0].loadWorkout();
                        }
                        else
                        {
                            System.out.println("Incorrect Username or Password");
                        }
                    }
                    break;

                case 3 :
                    System.out.println("Enter a date for your workout. 'MM/DD/YYYY'");
                    String appointment = br.readLine();
                    clientList[0].setAppointment(appointment);
                    clientList[0].getAppointments();
                    break;

                case 4 :
                    System.out.println("Enter the date of the appointment you would like to cancel. 'MM/DD/YYYY'");
                    String cancel = br.readLine();
                    clientList[0].cancelAppointment(cancel);
                    break;

                case 5 :
                    saveObject(clientList[0]);
                    break;

                case 6 :
                    break;

            }

            System.out.println("\nEnter '1' to add a new client.\nEnter '2' to view current workout.\nEnter '3' to schedule a session.\nEnter '4' cancel a session.\nEnter '5' to save your information.\nEnter '6' to quit!\n");
            ch = Integer.parseInt(br.readLine());

        }

    }

    public static Client loadObject() {
        Client loadClient = new Client();
        try{
            FileInputStream file = new FileInputStream("C:\\Users\\gavin\\OneDrive\\Documents\\client.txt");
            ObjectInputStream source = new ObjectInputStream(file);
            loadClient = (Client) source.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadClient;
    }

    public static void saveObject(Client client) {
        try {
            FileOutputStream file = new FileOutputStream("C:\\Users\\gavin\\OneDrive\\Documents\\client.txt");
            ObjectOutputStream destination = new ObjectOutputStream(file);
            destination.writeObject(client);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

