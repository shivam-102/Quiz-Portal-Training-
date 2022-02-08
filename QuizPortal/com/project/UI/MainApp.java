package com.project.UI;

import com.project.Service.QuestionBank;
import com.project.Service.QuizLibrary;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
public class MainApp {
    static Logger log = Logger.getLogger(MainApp.class.getName());
    public static void main(String[] args) {
        Welcome w=new Welcome();
        w.QuizPortalStart();
    }
        /*
        System.out.println("Welcome to Quiz Portal");
        Scanner scanner = new Scanner(System.in);
        CredentialsValidation credentialsValidation = new CredentialsValidation();
        QuestionBank questionBank=new QuestionBank();
        QuizLibrary quizLibrary=new QuizLibrary();
        int choice ;
        do {
            System.out.println("Press 1 to go Admin,Press 2 to go to User and Press 3 to exit");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Click 1 for sign-in or Click 2 for sign-up or click any number to exit");
                int adminChoice = scanner.nextInt();
                if (adminChoice == 1) {
                    System.out.println("Enter the username");
                    String username = scanner.next();
                    System.out.println("Enter password");
                    String password = scanner.next();
                    if (credentialsValidation.checkCredentials(username, password)) {
                        System.out.println("Welcome to the Admin portal.");
                        System.out.println("Press 1 to visit the Question Bank ");
                        System.out.println("Press 2 to visit the Quiz Bank");
                        System.out.println("Press 3 to exit");
                        int option;
                        while(true){
                            option=scanner.nextInt();
                            if(option==1){
                                System.out.println("Press 1 to view the available questions");
                                System.out.println("Press 2 to add Question, Options, Difficulty(easy, difficulty and hard), correct answer");
                                System.out.println("Press 3 delete any question");
                                System.out.println("Press 0 to exit and logout");
                                int questionOption=scanner.nextInt();
                                if(questionOption==1){
                                    ArrayList list= questionBank.printQuestions();
                                    for(int pointer=0;pointer<list.size();pointer++){
                                        System.out.println(list.get(pointer).toString());
                                    }

                                }
                                else if(questionOption==2){
                                    System.out.println("Enter the question");
                                    String question=scanner.nextLine();
                                    System.out.println("Enter the options you want to keep");
                                    String options[]=new String[4];
                                    for(int input=0;input< options.length;input++){
                                        System.out.println("Enter option"+(input+1));
                                        options[input]=scanner.nextLine();
                                    }
                                    System.out.println("Enter the difficulty level");
                                    String difficulty=scanner.nextLine();
                                    System.out.println("Enter the correct answer");
                                    String answer=scanner.nextLine();
                                    System.out.println(questionBank.addQuestion(question,options,difficulty,answer));
                                }
                                else if(questionOption==3){
                                    questionBank.printQuestions();
                                    System.out.println("Select the question number you want to delete");
                                    int toDelete=scanner.nextInt();
                                    System.out.println(questionBank.deleteQuestion(toDelete+1));

                                }
                                else if(questionOption==0)
                                {
                                    break;
                                }
                                else{
                                    System.out.println("Please enter correct option");
                                }

                            }
                            else if(option==2) {
                                while (true) {
                                    System.out.println("Press 1 to create New Quiz and add Questions");
                                    System.out.println("Press 2 to delete few questions from the quiz");
                                    System.out.println("Press 3 to exit the quiz");
                                    int quizChoice = scanner.nextInt();
                                    if (quizChoice == 1) {
                                        System.out.println("View the available questions");
                                        ArrayList listToRefer = quizLibrary.view();
                                        for (int pointer = 0; pointer < listToRefer.size(); pointer++) {
                                            System.out.println(listToRefer.get(pointer).toString());
                                        }

                                        System.out.println("Number of questions you want add in this quiz");
                                        int numberOfQuestions = scanner.nextInt();
                                        System.out.println("Provide the question numbers you want to add into the quiz:");
                                        int toAdd[] = new int[numberOfQuestions];
                                        for (int pointer = 0; pointer < numberOfQuestions; pointer++) {
                                            toAdd[pointer] = scanner.nextInt();
                                        }
                                        System.out.println(quizLibrary.createQuiz(toAdd));
                                        System.out.println(quizLibrary.quiz);
                                    } else if (quizChoice == 2) {
                                        System.out.println("Enter the quiz code in which you want to modify the questions");
                                        int quizCode = scanner.nextInt();
                                        if (quizLibrary.quiz.containsKey(quizCode)) {
                                            System.out.println("How many question you want to delete");
                                            int number = scanner.nextInt();
                                            System.out.println("Enter the question number which you want to delete");
                                            int toDeleteArr[] = new int[number];
                                            for (int pointer = 0; pointer < toDeleteArr.length; pointer++) {
                                                System.out.println("Enter question number you want to delete");
                                                System.out.println(quizLibrary.deleteQuestion(scanner.nextInt()));
                                            }
                                            System.out.println("Questions in the present quiz");
                                            ArrayList list = questionBank.printQuestions();
                                            for (int pointer = 0; pointer < list.size(); pointer++) {
                                                System.out.println(list.get(pointer).toString());
                                            }

                                        } else {
                                            System.out.println("Please enter a valid quiz code");
                                        }
                                    }
                                    else if(quizChoice==3){
                                        break;
                                    }
                                    else{
                                        System.out.println("Please enter a valid option");
                                    }
                                }
                            }

                        }
                    } else {
                        if(credentialsValidation.admin.containsKey(username)){
                            log.info("Wrong username or password");
                        }
                        else{
                            log.info("Username does not exist.You have to register as a new User");
                        }

                    }
                } else if (adminChoice == 2) {
                    log.info("Enter the username you want to register:");
                    String newUserName = scanner.next();
                    log.info("Enter the password to register:");
                    String newPassword = scanner.next();
                    while (true) {
                        if (credentialsValidation.admin.containsKey(newUserName)) {
                            log.info("Username already exists. Please choose another one!");
                            newUserName = scanner.next();
                            log.info("Enter the password to register:");
                            newPassword = scanner.next();
                        } else {
                            credentialsValidation.registerNewUser(newUserName, newPassword);
                            break;
                        }
                    }

                }
            }
                else if (choice == 2) {
                    //user
                } else {
                    break;
                }

        }while (true);
    }

         */
}