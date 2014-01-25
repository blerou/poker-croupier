package com.devillsroom.poker.player;

import org.junit.Test;

import java.io.IOException;

public class PlayerServiceTest {

    @Test
    public void testStart2Players() throws InterruptedException, IOException {

        startPlayerThread("Java Player 1", 9200, new SimpleStrategy());
        startPlayerThread("Java Player 2", 9201, new SimpleStrategy());

        System.out.println(execCmd("bundle exec ruby ../../croupier/scripts/integration_test_external_players.rb"));
        //execCmd("bundle exec ruby ../../croupier/scripts/integration_test_external_players.rb");
    }

    public static String execCmd(String cmd) throws java.io.IOException {
        Process p = Runtime.getRuntime().exec(cmd);
        java.util.Scanner s = new java.util.Scanner(p.getErrorStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    private void startPlayerThread(String name, int port, Strategy strategy) throws InterruptedException {
        Thread t = new Thread(new PlayerService(name, port, strategy));
        t.start();
    }


}
