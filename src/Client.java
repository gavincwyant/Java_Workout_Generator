import java.io.*;
import java.util.ArrayList;

public class Client implements Serializable{
    //private instance variables
    private String name;
    private int phone;
    private int discount;

    private int pushAbility;
    private int pullAbility;
    private int hipHingeAbility;
    private int squatAbility;
    private String username;
    private String password;

    private ArrayList<String> appointmentList = new ArrayList<>();


    //constructors
    public Client(){}

    public Client(String name, int phone)
    {
        this.name = name;
        this.phone = phone;

        Assessment assessment = new Assessment();
        int[] info = new int[4];
        info = assessment.newAssessment();

        this.pushAbility = info[0];
        this.pullAbility = info[1];
        this.squatAbility = info[2];
        this.hipHingeAbility = info[3];


        BufferedWriter writer;
        {
            File file = new File("output.txt");
            try {
                writer = new BufferedWriter(new FileWriter(file));
                writer.write(String.valueOf(info[0]) + "\n");
                writer.write(String.valueOf(info[1]) + "\n");
                writer.write(String.valueOf(info[2]) + "\n");
                writer.write(String.valueOf(info[3]) + "\n");
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    //getters and setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public void setDiscount(int discount)
    {
        this.discount = discount;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPhone()
    {
        return this.phone;
    }

    public int getDiscount()
    {
        return this.discount;
    }

    public void setAppointment(String appointment)
    {
        this.appointmentList.add(appointment);
    }

    public void getAppointments()
    {
        if (appointmentList.size() == 0)
        {
            System.out.println("You have no appointments scheduled.");
        }
        else {
            System.out.print("Your list of appointments: ");
            for (int i = 0; i < appointmentList.size(); i++)
            {
                System.out.print(appointmentList.get(i) + " ");
            }
        }
        System.out.println();
    }

    public void cancelAppointment(String appointment)
    {
        appointmentList.remove(appointment);
        System.out.println("Your session has been successfully canceled!");
    }

    public void setPushAbility(int push)
    {
        this.pushAbility = push;
    }

    public void setPullAbility(int pull)
    {
        this.pullAbility = pull;
    }

    public void setHipHingeAbility(int hinge)
    {
        this.hipHingeAbility = hinge;
    }

    public void setSquatAbility(int squat)
    {
        this.squatAbility = squat;
    }

    public int getPushAbility()
    {
        return this.pushAbility;
    }

    public int getPullAbility()
    {
        return this.pullAbility;
    }

    public int getHipHingeAbility()
    {
        return this.hipHingeAbility;
    }

    public int getSquatAbility()
    {
        return this.squatAbility;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getUsername(){return this.username;}
    public String getPassword(){return this.password;}

    //we are just going to test this process with a generic full body workout!!
    public void createWorkout(Client client)
    {
        Workout workout = new Workout();
        workout.session();
        workout.setsAndReps(client);
        workout.printWorkout();
        workout.saveWorkout();
    }

    public void loadWorkout()
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("workout.txt"));
            String line;

            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
