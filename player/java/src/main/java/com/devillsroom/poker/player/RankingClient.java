package com.devillsroom.poker.player;


import com.devillsroom.poker.client.Card;
import com.devillsroom.poker.client.HandDescriptor;
import com.devillsroom.poker.client.Ranking;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.List;

public class RankingClient implements Ranking.Iface{

    private Ranking.Client client;

    public RankingClient() throws TTransportException {
        TTransport transport = new TSocket("localhost", 9080);
        TProtocol protocol = new TBinaryProtocol(transport);
        client = new Ranking.Client(protocol);
        transport.open();
    }

    @Override
    public HandDescriptor rank_hand(List<Card> cards) throws TException {
        return client.rank_hand(cards);
    }
}
