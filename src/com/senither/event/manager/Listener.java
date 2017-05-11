package com.senither.event.manager;

import com.senither.event.manager.event.GameEventHandler;
import com.senither.event.manager.event.GameListener;
import com.senither.event.manager.events.ChatMessageEvent;
import com.senither.event.manager.events.TestEvent;

public class Listener implements GameListener
{

    public void testMethod()
    {
        System.out.println("test method");
    }

    public boolean getTestMethod()
    {
        System.out.println("get test method");
        return false;
    }

    @GameEventHandler
    public void onTest(TestEvent e)
    {
        System.out.println("Test event was called with text \"" + e.getName() + "\"!");
    }

    @GameEventHandler
    public void onChatMessage(ChatMessageEvent e)
    {
        System.out.println(e.getName() + " said: " + e.getMessage());
    }
}
