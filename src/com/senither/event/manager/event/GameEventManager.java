package com.senither.event.manager.event;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

public class GameEventManager
{

    private final HashMap<String, EventContainer> events = new HashMap<>();

    public GameEventManager()
    {
    }

    public void registerEvents(GameListener instance, Class game)
    {
        Class<? extends GameListener> iClass = instance.getClass();

        for (Method method : iClass.getMethods()) {
            if (method.getAnnotations().length == 0) {
                continue;
            }

            boolean isEvent = false;
            for (Annotation an : method.getAnnotations()) {
                if (an.annotationType().getName().equals(GameEventHandler.class.getName())) {
                    isEvent = true;
                    break;
                }
            }

            if (isEvent) {
                if (method.getParameterTypes().length != 1) {
                    System.err.println("A event handler method was found but failed to be loaded due to invalid parameters(Method: " + method.getName() + ")");
                }
                Class<?> pt = method.getParameterTypes()[0];

                if (!events.containsKey(pt.getName())) {
                    events.put(pt.getName(), new EventContainer());
                }

                events.get(pt.getName()).add(instance.getClass().getName(), method.getName());
            }
        }
    }

    public void fireEvent(GameEvent event)
    {
        if (!events.containsKey(event.getClass().getName())) {
            return;
        }

        events.get(event.getClass().getName()).fire(event);
    }
}
