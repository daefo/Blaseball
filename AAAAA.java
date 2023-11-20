import java.util.*;
import java.io.*;
    
class Main {
  static void print(String line) {
    System.out.println(line);
  }
    
  static void spacer(int val) {
    for (int i = 1; i <= val; i++) {
      System.out.println("");
    }
  }
    
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    
    File players = new File("Players.txt");
    File fnames = new File("Fnames.txt");
    File lnames = new File("Lnames.txt");
    File batPow = new File("BattingPower.txt");
    try {
      if (players.exists() == false) {
        System.out.println("Made new file players.txt");
        players.createNewFile();
      }
      if (fnames.exists() == false) {
        fnames.createNewFile();
      }
      if (lnames.exists() == false) {
        lnames.createNewFile();
      }
      if (batPow.exists() == false) {
        batPow.createNewFile();
      }
      // add more ifs for each file
    } // make new file if need be
    catch (IOException e) {
      e.printStackTrace();
    }
    
    try {
      BufferedWriter playerWriter = new BufferedWriter(new FileWriter(players, true)); // Player Writer
      BufferedReader playerReader = new BufferedReader(new FileReader("Players.txt")); // Player Reader
    
      BufferedReader fnameReader = new BufferedReader(new FileReader("Fnames.txt"));
      BufferedReader lnameReader = new BufferedReader(new FileReader("Lnames.txt"));
    
      ArrayList<String> Flist = new ArrayList<String>();
      ArrayList<String> Llist = new ArrayList<String>();
      String flistR = fnameReader.readLine();
      while (flistR != null) {
        Flist.add(flistR);
        flistR = fnameReader.readLine();
      }
      fnameReader.close(); // reformat Fnames.txt to an Array called "Flist"
      String llistR = lnameReader.readLine();
      while (llistR != null) {
        Llist.add(llistR);
        llistR = lnameReader.readLine();
      }
      lnameReader.close(); // reformat Lnames.txt to an Array called "Llist"
    
      /*
       * for(int i=1; i<=13;i++){
       * int firstnameVal = rand.nextInt(4944)+1;
       * int lastnameVal = rand.nextInt(999)+1;
       * 
       * String firstname = Flist.get(firstnameVal);
       * String lastname = Llist.get(lastnameVal);
       * String playername = firstname+" "+lastname;
       * 
       * playerWriter.write("\n"+playername);
       * System.out.println("Added "+playername);
       * 
       * }
       */ // add 13 new players to "Players.txt"
    
      BufferedWriter battingWriter = new BufferedWriter(new FileWriter(batPow, true));
      BufferedReader battingReader = new BufferedReader(new FileReader("BattingPower.txt"));
    
      ArrayList<String> PlayerList = new ArrayList<String>();
      String playerCt = playerReader.readLine();
      while (playerCt != null) {
        PlayerList.add(playerCt);
        playerCt = playerReader.readLine();
      } // format Players.txt to an Array
    
    
    
     /*
      int batVal = rand.nextInt(100) + 1;
      battingWriter.write("" + batVal);
      System.out.println(batVal);
      for (int i = 1; i <= PlayerList.size()-1; i++) {
        batVal = rand.nextInt(100) + 1;
        battingWriter.write("\n" + batVal);
        System.out.println(batVal);
      }
      */ //add 14 new batting values (writes to the first line)
      ArrayList<String> BattingList= new ArrayList<String>();
      String bats = battingReader.readLine();
      while (bats != null){
      BattingList.add(bats);
      bats = battingReader.readLine();
    } // format BattingPower.txt to an Array
    
      // debug
      System.out.println(PlayerList);
      System.out.println(BattingList);
      // end debug

      print("Input a name, and it will display their batting power");
      String nameCheck1 = input.next();
      String nameCheck2 = input.next();
      String nameCheck = nameCheck1+" "+nameCheck2;
      if(PlayerList.contains(nameCheck)){
       int Ind = PlayerList.indexOf(nameCheck);
       System.out.println(PlayerList.get(Ind)+" has a batting power of "+BattingList.get(Ind));
      }









      
    
      battingWriter.close();
      playerWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    spacer(3);
    System.out.println("Shit worked");
  }
}