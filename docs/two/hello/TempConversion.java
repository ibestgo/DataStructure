package com.bestgo.hello;

public class TempConversion {

  public TempConversion() {
  }

  public String timeConversion(String s) {
    // s in hh:mm:ssAM
    String[] hms;

    if(s.endsWith("PM") || s.endsWith("AM")) {
      String ts = s.substring(0, s.length()-2);
      hms = ts.split(":");
      if(hms.length != 3) {
        throw new IllegalArgumentException("error");
      }

      if(s.endsWith("AM")) {
        if(hms[0].equals("12")) hms[0] = "00";
      } else {  // PM
        if(!hms[0].equals("12")) {  // add 12
          try {
            if(hms[0].startsWith("0")) { // 01-09 => 13-21
              hms[0] = ""+(Integer.parseInt(hms[0].substring(1))+12);
            } else { // 10-11 => 22-23
              hms[0] = ""+(Integer.parseInt(hms[0])+12);
            }
          } catch(NumberFormatException ex) {
            ex.printStackTrace();
          }
        }
      }
    } else {
      throw new IllegalArgumentException("error");
    }

    return hms[0]+":"+hms[1]+":"+hms[2];
  }
}
