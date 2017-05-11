package com.senither.event.manager;

import com.senither.event.manager.event.GameEventManager;
import com.senither.event.manager.event.GameListener;
import com.senither.event.manager.events.ChatMessageEvent;
import com.senither.event.manager.events.TestEvent;

public class Main implements GameListener
{

    public static void main(String[] args)
    {
        new Main();
    }

    public Main()
    {
        GameEventManager gem = new GameEventManager();

        gem.registerEvents(new Listener(), getClass());

        gem.fireEvent(new ChatMessageEvent("Alexis", "This is a test message"));
        gem.fireEvent(new TestEvent("Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
    }
}
