package com.devillsroom.poker.player;

import org.junit.Test;

import java.io.IOException;

public class PlayerServiceTest {

    @Test
    public void testStart2Players() throws InterruptedException, IOException {

        startPlayerThread("Nu Player", 9200, new RaiseOnPairPlayer());
        startPlayerThread("old Player", 9201, new RaiseOnPairOrCheckPlayer());

        //System.out.println(execCmd("bundle exec ruby ../../croupier/scripts/integration_test_external_players.rb"));
//        execCmd("bundle exec ruby ../../croupier/scripts/integration_test_external_players.rb");
        System.in.read();
    }

    private void startPlayerThread(String name, int port, Player player) throws InterruptedException {
        Thread t = new Thread(new PlayerService(name, port, player));
        t.start();
    }
}
