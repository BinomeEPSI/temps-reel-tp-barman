package fr.epsi.binome;

public class Bottle {

	private String name;
	private int capacity;
	private int mutex;

	public Bottle(String name) {
		this(name, 50);
	}

	public Bottle(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.mutex = 1;
	}

	public String getName() {
		return this.name;
	}

	public synchronized boolean take(long timeout) throws InterruptedException {
		if (this.mutex == 0) {
			this.wait(timeout);
			// Timeout error
			if (this.mutex == 0) {
				return false;
			}
		}
		this.mutex--;
		return true;
	}

	public synchronized void release() {
		this.mutex++;
		this.notify();
	}

	@Override
	public String toString() {
		return this.name;
	}
}
