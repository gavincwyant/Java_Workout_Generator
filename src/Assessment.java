import java.util.Scanner;

public class Assessment {

    public Assessment(){}

    public int[] newAssessment()
    {
        int push;
        int pull;
        int squat;
        int hinge;

        int[] ability = new int[4];
        Scanner scan = new Scanner(System.in);

        System.out.println("Can you do a body weight push-up? Enter 'yes' or 'no'");
        String push_answer = scan.next();
        if (push_answer.equals("no")) {push = 1;}
        else {
            System.out.println("Awesome! How many body weight push-ups can you perform?");
            int push_up = scan.nextInt();
            if (push_up >= 4) {push = 4;}
            if (push_up >= 10) {push = 7;}
            if (push_up >= 20) {push = 10;}

            else {push = 2;}
        }


        System.out.println("Okay, can you perform a body weight pull-up? Enter 'yes' or 'no'");
        String pull_answer = scan.next();
        if (pull_answer.equals("no")) {pull = 1;}
        else {
            System.out.println("That's impressive! How many body weight pull-ups can you perform?");
            int pull_up = scan.nextInt();
            if (pull_up >= 5) {pull = 6;}
            if (pull_up >= 10) {pull = 10;}

            else {pull = 3;}
        }

        System.out.println("What is the heaviest squat you can perform? Enter answer as an integer, '10' or '50'");
        int weightedSquat = scan.nextInt();

        if (weightedSquat >= 50) {squat = 4;}
        if (weightedSquat >= 100){squat = 7;}
        if (weightedSquat >= 150){squat = 10;}

        else {squat = 2;}

        System.out.println("Last question! What is the heaviest RDL you can perform? Enter answer as an integer. ");
        int rdl = scan.nextInt();

        if (rdl >= 30){hinge = 3;}
        if (rdl >= 50){hinge = 5;}
        if (rdl >= 100){hinge = 7;}
        if (rdl >= 150){hinge = 10;}

        else{hinge = 1;}

        System.out.println("Thanks so much for completing this assessment! This will help me tailor your workouts specifically to your needs!");

        ability[0] = push;
        ability[1] = pull;
        ability[2] = squat;
        ability[3] = hinge;
        return ability;
    }
}
