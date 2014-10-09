package Exercises.Chapter09;

import java.util.ArrayList;

class V2Radiator {
    V2Radiator(ArrayList list) {
        for(int x=0; x<5; x++) {
            list.add(new SimUnit("V2Radiator"));
        }
    }
}

class V3Radiator extends V2Radiator {
    V3Radiator(ArrayList lglist) {
        super(lglist);
        for(int g=0; g<10; g++) {
            lglist.add(new SimUnit("V3Radiator"));
        }
    }
}

class RetentionBot {
    RetentionBot(ArrayList rlist) {
        rlist.add(new SimUnit("Retention"));
    }
}

class SimUnit {
    String botType;
    SimUnit(String type) {
        botType = type;
        System.out.println(botType + " botType created.");
    }
    int powerUse() {
        if ("Retention".equals(botType)) {
            return 2;
        } else {
            return 4;
        }
    }
}
