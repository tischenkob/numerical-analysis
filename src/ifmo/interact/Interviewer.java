package ifmo.interact;

import java.io.PrintWriter;
import java.util.Scanner;

public class Interviewer implements CanInterview {
    private final String VISUAL_AID = " > ";
    Scanner in;
    PrintWriter out;

    public Interviewer(Scanner in) {
        this.in = in;
    }

    @Override
    public boolean prompt(String question) {
        question += " y/n (blank = 'yes')";
        return prompt(
                question,
                new String[]{"yes", "y", ""},
                new String[]{"no", "n"}
                );
    }

    @Override
    public boolean prompt(String question, String positive, String negative){
        return prompt(
                question,
                new String[]{positive},
                new String[]{negative}
                );
    }

    @Override
    public boolean prompt(String question, String[] positive, String[] negative) {
        String answer = askString(question).trim().toLowerCase();
        System.out.println();
        for (String option : positive) {
            if (answer.equals(option)) return true;
        }
        for (String option : negative) {
            if (answer.equals(option)) return false;
        }
        return prompt(question, positive, negative);
    }

    @Override
    public String askString(String question) {
        System.out.print(question + VISUAL_AID);
        return in.nextLine();
    }

    @Override
    public int askInteger(String question) {
        System.out.print(question + VISUAL_AID);
        return in.nextInt();
    }
}
