package com.senither.event.manager.events;

import com.senither.event.manager.event.GameEvent;

public class ChatMessageEvent extends GameEvent
{

    private final String name;
    private final String message;

    public ChatMessageEvent(String name, String message)
    {
        this.name = name;
        this.message = message;
    }

    public String getName()
    {
        return name;
    }

    public String getMessage()
    {
        return message;
    }
}
