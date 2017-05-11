package com.senither.event.manager.events;

import com.senither.event.manager.event.GameEvent;

public class TestEvent extends GameEvent
{

    private final String name;

    public TestEvent(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
