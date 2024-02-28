import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Workout {

    private String push;
    private String pushIsometric;
    private String pull;
    private String pullIsometric;
    private String hip;
    private String hipIsometric;
    private String squat;
    private String squatIsometric;

    public String[] pushCompounds = {"Incline DB Bench-Press", "Flat BB Bench-Press", "Incline BB Push-Up", "Cable Crossover"};
    public String[] pushIso = {"Tricep Push-Down", "French-Press", "Incline Skull-Crusher", "Shoulder Circuit"};
    public String[] pullCompounds = {"Pronated Lat-Pulldown", "Seated Cable Row", "Single-Arm DB Row", "Face-pull"};
    public String[] pullIso = {"DB Bicep Curl", "Cable Pullover", "DB Hammer Curl", "Spider Curl", "Waiter Curl"};
    public String[] hipHingeCompounds = {"DB RDL", "Reverse Lunge", "Sumo Squat"};
    public String[] hipHingeIso = {"Cybex Leg Curl", "Banded/Weighted Hip-Up", "Cybex Rotary Calf"};
    public String[] squatCompound = {"Cybex Leg Press", "Goblet Squat", "BB Back-squat"};
    public String[] squatIso = {"Cybex Leg Extension", "Wall-Sit", "Split Squat"};

    public Workout()
    {
    }

    public void setPush()
    {
        this.push = pushCompounds[(int)(3*(Math.random()))];
        this.pushIsometric = pushIso[(int)(3*(Math.random()))];
    }

    public String getPush()
    {
        return this.push;
    }
    public String getPushIsometric(){return this.pushIsometric;}

    public void setPull()
    {
        this.pull = pullCompounds[(int)(3*(Math.random()))];
        this.pullIsometric = pullIso[(int)(3*(Math.random()))];
    }

    public String getPull()
    {
        return this.pull;
    }
    public String getPullIsometric(){return this.pullIsometric;}

    public void setHip()
    {
        this.hip = hipHingeCompounds[(int)(3*(Math.random()))];
        this.hipIsometric = hipHingeIso[(int)(3*(Math.random()))];
    }

    public String getHip()
    {
        return this.hip;
    }
    public String getHipIsometric(){return this.hipIsometric;}

    public void setSquat()
    {
        this.squat = squatCompound[(int)(3*(Math.random()))];
        this.squatIsometric = squatIso[(int)(3*(Math.random()))];
    }

    public String getSquat()
    {
        return this.squat;
    }
    public String getSquatIsometric(){return this.squatIsometric;}

    public void session()
    {
        setPush();
        setPull();
        setHip();
        setSquat();
    }

    int pushComReps;
    int pushIsoReps;
    int pullComReps;
    int pullIsoReps;
    int squatComReps;
    int squatIsoReps;
    int hipComReps;
    int hipIsoReps;

    int pushComSets;
    int pushIsoSets;
    int pullComSets;
    int pullIsoSets;
    int squatComSets;
    int squatIsoSets;
    int hipComSets;
    int hipIsoSets;

    public void setsAndReps(Client client)
    {
        if (client.getPushAbility() >= 5)
        {
            pushComReps = 12;
            pushComSets = 3;
            pushIsoReps = 20;
            pushIsoSets = 4;
        }
        else {
            pushComReps = 8;
            pushComSets = 3;
            pushIsoReps = 10;
            pushIsoSets = 3;
        }
        if (client.getPullAbility() >= 5)
        {
            pullComReps = 10;
            pullComSets = 3;
            pullIsoReps = 20;
            pullIsoSets = 4;
        }
        else{
            pullComReps = 8;
            pullComSets = 3;
            pullIsoReps = 12;
            pullIsoSets = 3;
        }
        if (client.getSquatAbility() >= 5)
        {
            squatComReps = 15;
            squatComSets = 3;
            squatIsoReps = 18;
            squatIsoSets = 4;
        }
        else{
            squatComReps = 10;
            squatComSets = 3;
            squatIsoReps = 10;
            squatIsoSets = 3;
        }
        if (client.getHipHingeAbility() >= 5)
        {
            hipComReps = 15;
            hipComSets = 3;
            hipIsoReps = 20;
            hipIsoSets = 4;
        }
        else{
            hipComReps = 10;
            hipComSets = 3;
            hipIsoReps = 12;
            hipIsoSets = 3;
        }
    }


    public void printWorkout()
    {
        System.out.println("Full Body Workout:");
        System.out.println("_____________________________________________________");
        System.out.println("Push Movements: ");
        System.out.println("A1: " + getPush() + " for " + pushComSets + " sets of " + pushComReps + " reps");
        System.out.println("A2: " + getPushIsometric() + " for " + pushIsoSets + " sets of " + pushIsoReps + " reps");
        System.out.println("Pull Movements: ");
        System.out.println("B1: " + getPull() + " for " + pullComSets + " sets of " + pullComReps + " reps");
        System.out.println("B2: " + getPullIsometric() + " for " + pullIsoSets + " sets of " + pullIsoReps + " reps");
        System.out.println("Hip Movements: ");
        System.out.println("C1: " + getHip() + " for " + hipComSets + " sets of " + hipComReps + " reps");
        System.out.println("C2: " + getHipIsometric() + " for " + hipIsoSets + " sets of " + hipIsoReps + " reps");
        System.out.println("Squat Movements: ");
        System.out.println("D1: " + getSquat() + " for " + squatComSets + " sets of " + squatComReps + " reps");
        System.out.println("D2: " + getSquatIsometric() + " for " + squatIsoSets + " sets of " + squatIsoReps + " reps");
        System.out.println("_____________________________________________________");
    }

    public void saveWorkout()
    {
        BufferedWriter writer;
        {
            try {
                writer = new BufferedWriter(new FileWriter("workout.txt"));

                writer.write("Full Body Workout:\n");
                writer.write("_____________________________________________________\n");
                writer.write("Push Movements: \n");
                writer.write("A1: " + getPush() + " for " + pushComSets + " sets of " + pushComReps + " reps\n");
                writer.write("A2: " + getPushIsometric() + " for " + pushIsoSets + " sets of " + pushIsoReps + " reps\n");
                writer.write("Pull Movements: \n");
                writer.write("B1: " + getPull() + " for " + pullComSets + " sets of " + pullComReps + " reps\n");
                writer.write("B2: " + getPullIsometric() + " for " + pullIsoSets + " sets of " + pullIsoReps + " reps\n");
                writer.write("Hip Movements: \n");
                writer.write("C1: " + getHip() + " for " + hipComSets + " sets of " + hipComReps + " reps\n");
                writer.write("C2: " + getHipIsometric() + " for " + hipIsoSets + " sets of " + hipIsoReps + " reps\n");
                writer.write("Squat Movements: \n");
                writer.write("D1: " + getSquat() + " for " + squatComSets + " sets of " + squatComReps + " reps\n");
                writer.write("D2: " + getSquatIsometric() + " for " + squatIsoSets + " sets of " + squatIsoReps + " reps\n");
                writer.write("_____________________________________________________\n");

                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
