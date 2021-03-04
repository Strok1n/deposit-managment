package state;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AppState {
  //  public static Vector<String> passportColumns = new Vector
    private static Vector<Vector<String>> passports;






    public static Vector<Vector<String>> getPassports() {
        return passports;
    }

    public static void setPassports(Vector<Vector<String>> passports) {
        AppState.passports = passports;
       // passportColumns = new Vector<>();
        //passportColumns.add();
    }
}