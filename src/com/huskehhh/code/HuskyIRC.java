package com.huskehhh.code;

import java.io.IOException;
import java.util.Scanner;

import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;

import com.huskehhh.code.commands.*;

public class HuskyIRC {

    public static PircBotX bot = new PircBotX();

    public static void main(String[] args) {

        try {
            Config.loadConfiguration();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {

            bot.setAutoNickChange(true);

            bot.setVersion("HuskyIRC Bot - Kudos to Zachoz for some code.");

            bot.setLogin(Config.user);

            bot.setName(Config.ircuser);

            bot.identify(Config.nickPass);

            bot.setVerbose(true);

            bot.connect(Config.network, 6667);

            bot.setMessageDelay(1000);
            
            bot.setAutoReconnect(true);

            bot.setAutoReconnectChannels(true);

            joinChannels();

        } catch (IrcException e) {
            // do nothing
        } catch (IOException e) {
            // do nothing
        }

        loadListeners();

        end();
    }


    public static void end() {
        Scanner reader = new Scanner(System.in);
        String command = reader.nextLine();
        if (command.equals("end")) {
            bot.disconnect();
            bot.shutdown();
            System.out.println("Bot shutting down! Cya!");
            System.exit(0);
        }
    }


    private static void loadListeners() {
        bot.getListenerManager().addListener(new CheckBanCommand());
        bot.getListenerManager().addListener(new CheckCommand());
        bot.getListenerManager().addListener(new PartCommand());
        bot.getListenerManager().addListener(new JoinCommand());
        bot.getListenerManager().addListener(new MiscCommands());
    }


    private static void joinChannels() {
        for (int i = 0; i < Config.channels.length; i++) {
            bot.joinChannel(Config.channels[i]);
        }
    }

}
