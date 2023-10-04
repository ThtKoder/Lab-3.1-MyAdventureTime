import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

@SuppressWarnings("SpellCheckingInspection")
public class Main {
    public static void main(String[] args) {
        double popularity = 50;
        //popularity, declared in a global context
        int firstChoice = welcometoGame();
        zeroPopularity(popularity);
        //main menu selections
        boolean firstMenuDone = firstMenu(firstChoice, popularity);
        zeroPopularity(popularity);
        //first days in office
        if(firstMenuDone == true) {
            popularity = cabinetMeeting(popularity,false);
            zeroPopularity(popularity);
        }
        else{
            firstMenu(firstChoice, popularity);
            zeroPopularity(popularity);
        }
        String reElection = writingSpeeches(popularity);
        //last
        System.out.println(reElection);
        System.out.println("Would you like to play again? (1) Yes, (2) No.");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        if(option == 1){
            main(null);
        }
        else{
            System.exit(1);
        }
    }
    public static int welcometoGame() {
        System.out.println("Wow we weren't expecting that, BUT CONGRATS YOU HAVE JUST BEEN NAMED");
        System.out.println("\nTHE PRESIDENT OF 'EURPACIFICA'\n");

        System.out.println("And it is up to you to rule our country prosperously, and to ensure 4 years (if not more) of peace and happiness");
        System.out.println("\nThroughout the game your popularity ranking will be shown at the bottom of your screen, if it hits 0 you will be assasinated.");
        System.out.println("\nThere will also be a value given to your economy (and how you are handling it) given to you by international creditors.");
        System.out.println("If this number hits zero, your popularity will also be below 30, until your economy has improved.");

        System.out.println("Therefore you have a tough road ahead, however, the people of EURPACIFICA have faith in you to do the job.");

        System.out.println("\nYour popularity is currently: 50%");
        //popularity initialized at 50
        System.out.println("Good Luck, and enter (1), to continue to the game or (2), to quit.");
        //welcome to the user

        Scanner scanner = new Scanner(System.in);
        int firstChoice = scanner.nextInt();
        //prompting user menu option
        return firstChoice;
    }
    public static boolean firstMenu(int firstChoice, double popularity){
        //boolean to ensure the user has completed the first menu before going to any other menu
        if (firstChoice == 1) {
            double firstPopularity = firstDaysInOffice(popularity);
            System.out.println("\nCurrent Polling: " + firstPopularity + "%\n");
            System.out.println();
            //to enter the game
        }
        else if (firstChoice == 2) {
            System.exit(1);
            System.out.println("Thanks for playing");
            //to exit the game
        }
        else {
            System.out.println("Since no valid selection the game will end.");
            System.exit(1);
            //if there's a different answer game automatically quits
        }
        return true;
    }
    public static double firstDaysInOffice(double popularity) {
        Random random = new Random();
        int generator = random.nextInt(3) + 1;
        //randomly generates a scenario
        if (generator == 1) {

            System.out.println("While campaigning in the street, you encounter a homeless person");
            System.out.println("Press 1 to tell him off, Press 2 to give him food and a blanket, Press 3 to ignore him entirely.");

            Scanner scanner = new Scanner(System.in);
            int encounter = scanner.nextInt();

            if (encounter == 1) {
                System.out.println("Your actions have caused outrage among certain voters.");
                return popularity %15;
            } else if (encounter == 2) {
                System.out.println("Voters have applauded your actions on social media.");
                return popularity += 5;
            } else if (encounter == 3) {
                System.out.println("Not many people noticed, as the camera was panned away.");
                return popularity;
            }
        } else if (generator == 2) {
            popularity = recession(popularity);
        } else {
            System.out.println("A popular minister is vehemently disagreeing with your policy.");
            System.out.println("You must either fire him and risk public wrath (1), or compromise on your values (2)");
            Scanner threeRandom = new Scanner(System.in);
            int ministerChoice = threeRandom.nextInt();
            //prompts the user for
            if (ministerChoice == 1) {
                System.out.println("The public is furious and believes that you should have kept him in power");
                double choiceOnePopularity = popularity/1.05;
                System.out.println("Current Polling: " + choiceOnePopularity + "%");
                return choiceOnePopularity;
            } else if (ministerChoice == 2) {
                System.out.println("The public is cautious about your flip flopping and you subsequently lose a few popularity points");
                double choiceOnePopularity = popularity - 2;
                System.out.println("Current Polling: " + choiceOnePopularity + "%");
                return choiceOnePopularity;
            } else {
                System.exit(1);
                //Exit code 1 = error in runtime
            }
        }
        return popularity;
    }
    public static double recession(double popularity){
        System.out.println("Your economy is currently experiencing an economic recession. Your new popularity has dropped.");
        double recessionPopularity = Math.round(popularity / 1.4);
        System.out.println("Current Polling: " + recessionPopularity + "%");
        cabinetMeeting(popularity, true);
        String reElection = writingSpeeches(popularity);
        //last
        System.out.println(reElection);
        System.out.println("Would you like to play again? (1) Yes, (2) No.");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        if(option == 1){
            main(null);
        }
        return popularity;
    }
    public static double cabinetMeeting(double popularity, boolean recession) {
        System.out.println("You now have your first cabinet meeting, choose which matter you would like to address.");
        System.out.println("Press 1 for Healthcare, Press 2 for Economy, Press 3 for Foreign Policy or 4 for Random.");
        System.out.println("Note: Focusing on the economy after a recession can help boost your popularityn even more.");
        Scanner scanner = new Scanner(System.in);
        int cabinetChoice = scanner.nextInt();
        if (cabinetChoice == 1) {
            popularity = healthChoice(popularity);
        } else if (cabinetChoice == 2) {
            popularity = economyChoice(popularity, recession);
        } else if (cabinetChoice == 3) {
            popularity = foreignChoice(popularity);
        } else if (cabinetChoice == 4) {
            Random random = new Random();
            int generator = random.nextInt(3) + 1;

            if(generator == 1){
                popularity = healthChoice(popularity);
            }
            else if(generator == 2){
                popularity = economyChoice(popularity, recession);
            }
            else if(generator == 3){
                popularity = foreignChoice(popularity);
            }
        }
        else {

        }
        return popularity;
    }
    public static double healthChoice(double popularity){
        System.out.println("You have chosen to focus on Healthcare.");
        System.out.println("Currently your healthcare economy relies on large HMOs taking advantage of the small individual consumer");
        System.out.println("Propose policies to prioritize individuals (1), Propose more HMO friendly policies (2), remain at status quo (3).");
        Scanner healthScan = new Scanner(System.in);
        int healthChoice = healthScan.nextInt();
        if(healthChoice == 1){
            System.out.println("While corporations are unhappy, your population is very happy knowing they have affordable healthcare.");
            popularity += 3;
            zeroPopularity(popularity);
            System.out.println("\nCurrent Polling: " + popularity + "%\n");
            return popularity;
        }
        else if(healthChoice == 2){
            System.out.println("Focusing soley on HMOs and Large companies has greatly upset your voters.");
            popularity -= 5;
            zeroPopularity(popularity);
            System.out.println("\nCurrent Polling: " + popularity + "%\n");
            return popularity;
        }
        else if(healthChoice == 3){
            System.out.println("Remaining at the status quo has left some population upset");
            popularity -= 2;
            zeroPopularity(popularity);
            System.out.println("\nCurrent Polling: " + popularity + "%\n");
            return popularity;
        }
        else{
            System.exit(1);
        }
        return popularity;
    }
    public static double economyChoice(double popularity, boolean recession){
        System.out.println("You have chosen to focus on the Economy.");
        System.out.println("Currently your economy is at a crossroads between choosing to prioritize adapting to climate change or profit");
        System.out.println("Propose policies to prioritize adapting to climate change (1), prioritize profits (2), remain at status quo (3).");
        Scanner economyScan = new Scanner(System.in);
        int economyChoice = economyScan.nextInt();
        if(economyChoice == 1){
            System.out.println("Corporations are slightly unhappy, but the population as a whole is excited knowing that they have a greener future.");
            if(recession && ((popularity * 3) <= 100)){
                popularity *= 3;
            }
            else{
                popularity += 7;
            }
            zeroPopularity(popularity);
            System.out.println("\nCurrent Polling: " + popularity + "%\n");
            return popularity;
        }
        else if(economyChoice == 2){
            System.out.println("Focusing soley on large companies somewhat upset voters.");
            if(recession == true){
                popularity -= 2;
            }
            else{
                popularity -= 5;
            }
            zeroPopularity(popularity);
            System.out.println("\nCurrent Polling: " + popularity + "%\n");
            return popularity;
        }
        else if(economyChoice == 3){
            System.out.println("Remaining at the status quo has left some population in doubt about your leadership.");
            if(recession == true){
                popularity %= 6;
            }
            else{
                popularity -= 3;
            }
            zeroPopularity(popularity);
            System.out.println("\nCurrent Polling: " + popularity + "%\n");
            return popularity;
        }
        else{
            System.exit(1);
        }
        return popularity;
    }
    public static double foreignChoice(double popularity){
        System.out.println("You have chosen to focus on Foreign Policy.");
        System.out.println("Currently your the world remains very divided and ");
        System.out.println("Propose policies to prioritize long-time allys (1), break down barriers with old adversaries (2), remain at status quo (3).");
        Scanner foreignScan = new Scanner(System.in);
        int foreignChoice = foreignScan.nextInt();
        if(foreignChoice == 1){
            System.out.println("Citizens are not surprised and not really effected too much.");
            popularity += 1;
            System.out.println("\nCurrent Polling: " + popularity + "%\n");
            return popularity;
        }
        else if(foreignChoice == 2){
            System.out.println("Citizens are a bit concerned, but how will you explain yourself?");
            System.out.println("(1), It is important to forge new paths and break down old icy relationships...");
            System.out.println("(2), We have nothing to fear as the strongest nation in the world...");
            System.out.println("(3), Wait I did what......");
            int rationaleChoice = foreignScan.nextInt();
            if(rationaleChoice == 1){
                popularity +=3;
            }
            else if(rationaleChoice == 2){
                popularity += 2;
            }
            else{
                popularity -= 5;
            }
            System.out.println("\nCurrent Polling: " + popularity + "%\n");
            return popularity;
        }
        else if(foreignChoice == 3){
            System.out.println("Remaining at the status quo has left some of your people in doubt about your leadership.");
            popularity -= 2;
            System.out.println("\nCurrent Polling: " + popularity + "%\n");
            return popularity;
        }
        else{
            System.exit(1);
        }
        return popularity;
    }
    public static String writingSpeeches(double popularity) {
        System.out.println("Your final test, will require you to write a speech for the population.");
        System.out.println("Note, your speech can impact the chances of your election.");
        System.out.println("\nSince this is a game, you are only allowed one sentance, so choose your topic wisely...");
        Scanner scanner = new Scanner(System.in);
        int electionLikelihood = (int) (popularity / 1.05);
        String speech = scanner.nextLine();

        if (speech.contains("I promise to improve the economy")){
            electionLikelihood += 2;
        }
        else if (speech.contains("improve") && speech.contains("healthcare")) {
            electionLikelihood += 3;
        } else if (speech.contains("education") && speech.contains("provide") || speech.contains("improve")) {
            electionLikelihood += 5;
        }

        if (electionLikelihood >= 50){
            String victory = "WELL DONE, YOU HAVE GOT RE-ELECTED, look out for our second iteration fo this game! :)";
            return victory + "\nYou won with" + electionLikelihood + " % of the vote.";
        }
        else{
            String loss = "Unfortunately your opponnet won, better luck next time, but we hope you enjoyed playing this game!";
            return loss + "\nYou only had" + electionLikelihood + " % of the vote.";
        }
    }
    public static void zeroPopularity(double popularity){
        if(popularity == 0){
            System.out.println("You have been assasinated due to unpopularity.");
            System.exit(1);
        }
        else{
            System.out.println("\n");
        }
    }
}