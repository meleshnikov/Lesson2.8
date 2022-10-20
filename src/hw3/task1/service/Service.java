package hw3.task1.service;


import hw3.task1.transport.Transport;

import java.util.LinkedList;
import java.util.Queue;

public class Service<T extends Transport> {

    private final Queue<T> queue = new LinkedList<>();

    public void addToQueue(T transport) {
        if (transport != null) {
            queue.offer(transport);
        }
    }

    public void service() {
        if (!queue.isEmpty()) {
            queue.poll();
        }
    }


}
